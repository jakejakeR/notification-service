package com.notificationservice.controller;

import com.notificationservice.dto.NotificationDto;
import com.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("https://localhost:3000")
@RequestMapping("/notification-service")
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public Mono<NotificationDto> receiveNotification(@RequestBody Mono<NotificationDto> notificationDtoMono) {
        log.info("Received notification: {}", notificationDtoMono.toString());
        return service.receiveNotification(notificationDtoMono);
    }

    @GetMapping("all")
    public Flux<NotificationDto> getAllNotificationsByRecipientId(@RequestParam("userId") String id) {
        return service.getAllNotificationsByRecipientId(id);
    }

    @PutMapping("{id")
    public Mono<ResponseEntity<NotificationDto>> markNotificationAsRead(@PathVariable String id) {
        return service.markNotificationAsRead(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
