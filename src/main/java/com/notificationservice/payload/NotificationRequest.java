package com.notificationservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    private String senderUsername;
    private String recipientId;
    private String message;
    private String redirectUrl;
}
