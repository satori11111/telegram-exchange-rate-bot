package com.example.telegramappbot.service;

import com.example.telegramappbot.bot.TelegramBot;
import com.example.telegramappbot.currency.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduledNotificationService{
    private final ExchangeRateService exchangeRateService;
    private final NotificationService notificationService;

    @Scheduled(cron = "0 0 13 * * ?")
    public void sendMessage() {
        for (Long chatId : TelegramBot.getTreeSet()) {
            String rates = "Курс валют сьогодні:" + System.lineSeparator();
            Currency euroExchangeRate = exchangeRateService.getEuroExchangeRate();
            Currency usdExchangeRate = exchangeRateService.getUsdExchangeRate();
            rates += euroExchangeRate + System.lineSeparator() + usdExchangeRate;
            notificationService.sendMessage(chatId, rates);
        }

    }
}
