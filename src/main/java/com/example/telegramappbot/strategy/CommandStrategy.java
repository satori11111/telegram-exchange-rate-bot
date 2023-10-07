package com.example.telegramappbot.strategy;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommandStrategy {
    private final List<CommandHandler> commandHandlers;

    public CommandHandler getHandler(String message) {
        return commandHandlers.stream().filter(h -> h.isApplicable(message))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Unsupported message: " + message));
    }
}
