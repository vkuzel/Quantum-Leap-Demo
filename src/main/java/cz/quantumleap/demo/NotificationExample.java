package cz.quantumleap.demo;

import cz.quantumleap.admin.notification.NotificationDao;
import cz.quantumleap.admin.notification.NotificationDefinition;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class NotificationExample implements NotificationDefinition {

    private static final String NOTIFICATION_CODE = "EXAMPLE_NOTIFICATION";

    private NotificationDao notificationDao;

    public NotificationExample(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public String getNotificationCode() {
        return NOTIFICATION_CODE;
    }

    @Override
    public String getMessageCode() {
        return "ql-demo.notification-example.message";
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void createNotification() {
        String currentTime = LocalDate.now().toString();
        notificationDao.createNotificationForAll(NOTIFICATION_CODE, Collections.singletonList(currentTime));
    }
}
