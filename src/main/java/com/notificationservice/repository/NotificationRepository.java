package com.notificationservice.repository;

import com.notificationservice.model.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationRepository {

    private final Map<String, List<Notification>> notifications = new HashMap<>();
}
