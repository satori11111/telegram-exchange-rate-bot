package com.example.telegramappbot.strategy;

import com.example.telegramappbot.service.ExchangeRateService;
import com.example.telegramappbot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsdHandler implements CommandHandler {
    private final String USD = "/usd";
    private final ExchangeRateService exchangeRateService;
    private final NotificationService notificationService;

    @Override
    public void sendMessage(Long chatId) {
        notificationService.sendMessage(chatId, exchangeRateService.getUsdExchangeRate().toString());
    }

    @Override
    public boolean isApplicable(String message) {
        return message.contains(USD);
    }
}
