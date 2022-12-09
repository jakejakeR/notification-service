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

    public Flux<NotificationDto> getAllNotificationsByRecipientId(String id) {
        return repository.findAllByRecipientId(id)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<NotificationDto> markNotificationAsRead(String id) {
        return repository.findById(id)
                .doOnNext(notification -> notification.setIsRead(true))
                .flatMap(repository::save)
                .map(EntityDtoUtil::toDto);
    }
}
