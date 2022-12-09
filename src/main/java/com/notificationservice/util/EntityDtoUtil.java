package com.notificationservice.util;

import com.notificationservice.dto.NotificationDto;
import com.notificationservice.entity.Notification;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    private EntityDtoUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static NotificationDto toDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        BeanUtils.copyProperties(notification, dto);
        return dto;
    }

    public static Notification toEntity(Notification dto) {
        Notification notification = new Notification();
        BeanUtils.copyProperties(dto, notification);
        return notification;
    }
}
