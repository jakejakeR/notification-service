package com.notificationservice.controller;

import com.notificationservice.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("https://127.0.0.1:3000")
@RequestMapping("/notification-service/stream")
public class NotificationStreamController {

    private final Flux<NotificationDto> flux;

    @GetMapping(value = "{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<NotificationDto> getNotificationUpdates(@PathVariable String userId) {
        log.info("Subscribing user with id {}", userId);
        return flux
                .filter(notificationDto -> notificationDto.getTo().equals(userId))
                .doOnNext(notificationDto -> log.info("Notification: {}", notificationDto));
    }
}
