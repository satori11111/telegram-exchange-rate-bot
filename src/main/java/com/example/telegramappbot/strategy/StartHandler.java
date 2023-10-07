package com.example.telegramappbot.strategy;

import com.example.telegramappbot.service.ExchangeRateService;
import com.example.telegramappbot.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StartHandler implements CommandHandler {
    private final String START = "/start";
    private final ExchangeRateService exchangeRateService;
    private final NotificationService notificationService;

    @Override
    public void sendMessage(Long chatId) {
        var formattedText = """
                Welcome to the bot!
                  Here you can find out the exchange rate and set the hrivna.
                   Use the following commands:
                    /usd - dollar exchange rate
                    /eur - euro exchange rate
                  """;
        notificationService.sendMessage(chatId, formattedText);
    }

    @Override
    public boolean isApplicable(String message) {
        return message.contains(START);
    }
}
