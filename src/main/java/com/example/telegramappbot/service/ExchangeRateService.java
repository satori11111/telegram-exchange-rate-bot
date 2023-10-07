package com.example.telegramappbot.service;

import com.example.telegramappbot.currency.Currency;

public interface ExchangeRateService {

    public Currency getUsdExchangeRate();
    public Currency getEuroExchangeRate();
}
