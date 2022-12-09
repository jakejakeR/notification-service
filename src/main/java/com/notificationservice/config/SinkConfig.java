package com.notificationservice.config;

import com.notificationservice.dto.NotificationDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class SinkConfig {

    @Bean
    public Sinks.Many<NotificationDto> sink() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    Flux<NotificationDto> notificationBroadcast(Sinks.Many<NotificationDto> sink) {
        return sink.asFlux();
    }
}
