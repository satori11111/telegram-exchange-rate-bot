package com.example.telegramappbot.service;

public interface NotificationService {
    void sendMessage(Long chatId, String message);
}
