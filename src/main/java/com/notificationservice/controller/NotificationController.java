package com.notificationservice.controller;

import com.notificationservice.model.Notification;
import com.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("https://localhost:3000")
@RequestMapping("/notification-service")
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public Mono<Notification> receiveNotification(@RequestBody Mono<Notification> notificationMono) {
        log.info("Received notification: {}", notificationMono.toString());
        return service.receiveNotification(notificationMono);
    }
}
