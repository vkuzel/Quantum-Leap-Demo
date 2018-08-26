package cz.quantumleap.demo;

import cz.quantumleap.admin.notification.NotificationDao;
import cz.quantumleap.admin.notification.transport.NotificationDefinition;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class PeriodicMaintenanceNotification implements NotificationDefinition {

    private static final String NOTIFICATION_CODE = "PERIODIC_MAINTENANCE_NOTIFICATION";

    private NotificationDao notificationDao;

    public PeriodicMaintenanceNotification(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public String getNotificationCode() {
        return NOTIFICATION_CODE;
    }

    @Override
    public String getMessageCode() {
        return "ql-demo.periodic-maintenance-notification.message";
    }

    @Scheduled(fixedDelay = 3600_000)
    public void createNotification() {
        if (LocalDate.now().getDayOfMonth() != 1) {
            return;
        }

        String currentMonth = String.valueOf(LocalDate.now().getMonthValue());
        notificationDao.createNotificationForAll(NOTIFICATION_CODE, Collections.singletonList(currentMonth));
    }
}
