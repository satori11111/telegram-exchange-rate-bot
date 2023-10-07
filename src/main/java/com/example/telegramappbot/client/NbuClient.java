package com.example.telegramappbot.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NbuClient {
    private final OkHttpClient httpClient;
    @Value("${nbu.currency.json.url}")
    private String url;

    public String  getCurrenciesJson() {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response execute = httpClient.newCall(request).execute()) {
            ResponseBody body = execute.body();
            return body == null ? null : body.string();
        } catch (IOException e) {
            throw new RuntimeException("Can't execute response", e);
        }

    }
}
