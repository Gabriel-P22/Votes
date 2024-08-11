package com.test.votation.infrastructure.database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static java.lang.String.format;

@Configuration
public class MongoConfig {

    @Bean
    public Naming naming() {
        return new Naming();
    }

    public static class Naming {
        public String build(String name) {
            final String year = String.valueOf(LocalDateTime.now().getYear());
            return format("%s-%s", year, name);
        }
    }
}
