package com.example.telegramappbot.strategy;

import com.example.telegramappbot.service.ExchangeRateService;
import com.example.telegramappbot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EurHandler implements CommandHandler {
    private final String EUR = "/eur";
    private final ExchangeRateService exchangeRateService;
    private final NotificationService notificationService;
    @Override
    public void sendMessage(Long chatId) {
        notificationService.sendMessage(chatId, exchangeRateService.getEuroExchangeRate().toString());
    }

    @Override
    public boolean isApplicable(String message) {
        return message.contains(EUR);
    }
}
