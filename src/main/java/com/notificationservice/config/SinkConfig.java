package com.notificationservice.config;

import com.notificationservice.model.Notification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class SinkConfig {

    @Bean
    public Sinks.Many<Notification> sink() {
        return Sinks.many().replay().limit(3);
    }

    @Bean
    Flux<Notification> notificationBroadcast(Sinks.Many<Notification> sink) {
        return sink.asFlux();
    }
}
