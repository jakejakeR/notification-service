package com.notificationservice.controller;

import com.notificationservice.model.Notification;
import com.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin("https://localhost:3000")
@RequestMapping("/notification-service")
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public Mono<Notification> receiveNotification(@RequestBody Mono<Notification> notificationMono) {
        return service.receiveNotification(notificationMono);
    }
}
