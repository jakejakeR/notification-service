package com.notificationservice.service;

import com.notificationservice.dto.NotificationDto;
import com.notificationservice.repository.NotificationRepository;
import com.notificationservice.util.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final Sinks.Many<NotificationDto> sink;
    private final NotificationRepository repository;

    public Mono<NotificationDto> receiveNotification(Mono<NotificationDto> notificationMono) {
        return notificationMono
                .map(EntityDtoUtil::toEntity)
                .flatMap(repository::insert)
                .map(EntityDtoUtil::toDto)
                .doOnNext(sink::tryEmitNext);
    }

    public Flux<NotificationDto> getAllNotifications() {
        return Flux.just();
    }
}
