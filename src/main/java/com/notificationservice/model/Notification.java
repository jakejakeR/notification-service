package com.notificationservice.model;

public record Notification(String from, String to, String message, String redirectTo) {
}
