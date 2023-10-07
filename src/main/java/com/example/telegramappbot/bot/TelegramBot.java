package com.example.telegramappbot.bot;

import com.example.telegramappbot.service.ExchangeRateService;
import com.example.telegramappbot.strategy.CommandStrategy;
import java.util.TreeSet;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private CommandStrategy commandStrategy;

    @Getter
    private static TreeSet<Long> treeSet = new TreeSet<>();

    public TelegramBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() && !update.getMessage().hasText()) {
            return;
        }
        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        treeSet.add(chatId);
        commandStrategy.getHandler(message).sendMessage(chatId);
    }

    @Override
    public String getBotUsername() {
        return "java_satori_bot";
    }

}
