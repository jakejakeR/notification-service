package com.notificationservice.service;

import com.notificationservice.entity.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final Sinks.Many<Notification> sink;

    public Mono<Notification> receiveNotification(Mono<Notification> notificationMono) {
        return notificationMono
                .doOnNext(sink::tryEmitNext);
    }
}
