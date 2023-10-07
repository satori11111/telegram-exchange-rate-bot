package com.example.telegramappbot.strategy;

public interface CommandHandler {
    void sendMessage(Long chatId);

    boolean isApplicable(String message);
}
