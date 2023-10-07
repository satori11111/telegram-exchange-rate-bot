package com.example.telegramappbot.service;

import com.example.telegramappbot.client.NbuClient;
import com.example.telegramappbot.currency.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final NbuClient nbuClient;
    private final ObjectMapper objectMapper;
    @Override
    public Currency getUsdExchangeRate() {
       return getCurrency("USD");
    }

    @Override
    public Currency getEuroExchangeRate() {
        return getCurrency("EUR");
    }

    private Currency getCurrency(String currency) {
        JsonNode jsonArray = null;
        try {
            jsonArray = objectMapper.readTree(nbuClient.getCurrenciesJson());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Can't read json", e);
        }

        for (JsonNode jsonNode : jsonArray) {
            if (jsonNode.has("cc") && jsonNode.get("cc").asText().equals(currency)) {
                try {
                    return objectMapper.readValue(jsonNode.toString(), Currency.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException("Can't read json",e);
                }
            }
        }
        throw new RuntimeException("Error finding currency");
    }
}
