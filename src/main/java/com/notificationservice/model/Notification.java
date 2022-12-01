package com.notificationservice.model;

import lombok.Data;

@Data
public class Notification {

    private final String from;
    private final String to;
    private final String message;

    public static Notification of(String from, String to, String message) {
        return new Notification(from, to, message);
    }
}
