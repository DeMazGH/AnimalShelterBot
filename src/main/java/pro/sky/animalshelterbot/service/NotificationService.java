package pro.sky.animalshelterbot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.animalshelterbot.model.Notification;
import pro.sky.animalshelterbot.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void create(long chatId, String text, LocalDateTime dateTime) {
        Notification notification = new Notification();
        notification.setChatId(chatId);
        notification.setNotificationText(text);
        notification.setDateTime(dateTime.truncatedTo(ChronoUnit.MINUTES));
        notificationRepository.save(notification);
    }
}
