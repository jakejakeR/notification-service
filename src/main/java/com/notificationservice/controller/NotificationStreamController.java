package com.notificationservice.controller;

import com.notificationservice.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@CrossOrigin("https://127.0.0.1:3000")
@RequestMapping("/notification-service/stream")
public class NotificationStreamController {

    private final Flux<Notification> flux;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Notification> getNotificationUpdates() {
        return flux;
    }
}
