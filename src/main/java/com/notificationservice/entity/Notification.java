package com.notificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private String id;
    private String senderName;
    private String recipientId;
    private String message;
    private String redirectTo;
    private Boolean isRead;
    private LocalDateTime receiptDate;
}
