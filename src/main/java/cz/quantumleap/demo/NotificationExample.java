package cz.quantumleap.demo;

import cz.quantumleap.core.notification.NotificationDefinition;
import cz.quantumleap.core.notification.NotificationManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class NotificationExample implements NotificationDefinition {

    private static final String NOTIFICATION_CODE = "EXAMPLE_NOTIFICATION";

    @Override
    public String getNotificationCode() {
        return NOTIFICATION_CODE;
    }

    @Override
    public String getMessageCode() {
        return "ql-demo.notification-example.message";
    }

    @Component
    public static class NotificationGenerator {

        private final NotificationManager notificationManager;

        public NotificationGenerator(NotificationManager notificationManager) {
            this.notificationManager = notificationManager;
        }

        @Scheduled(cron = "*/15 * * * * *")
        @Scheduled(initialDelay = 15 * 60_000, fixedRate = 15 * 60_000)
        public void createNotification() {
            String currentTime = LocalDate.now().toString();
            notificationManager.createNotificationForAll(NOTIFICATION_CODE, Collections.singletonList(currentTime));
        }
    }
}
