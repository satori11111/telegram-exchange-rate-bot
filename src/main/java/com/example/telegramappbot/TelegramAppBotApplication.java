package com.example.telegramappbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramAppBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramAppBotApplication.class, args);
    }

}
