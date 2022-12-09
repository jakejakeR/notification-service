package com.notificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private String from;
    private String to;
    private String message;
    private String redirectTo;
    private Boolean isRead;
}
