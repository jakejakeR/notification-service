package com.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private String id;
    private String senderName;
    private String recipientId;
    private String message;
    private String redirectTo;
    private Boolean isRead;
}
