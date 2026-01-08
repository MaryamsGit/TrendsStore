package com.example.trendsstore;



import com.example.trendsstore.BuildConfig;
import okhttp3.*;

import java.io.IOException;

public class GeminiClient {
    private static final OkHttpClient client = new OkHttpClient();

    // Simple text-only request (Gemini REST)
    public static void send(String userText, Callback callback) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
                + BuildConfig.GEMINI_API_KEY;

        String json = "{\n" +
                "  \"contents\": [{\n" +
                "    \"parts\": [{\"text\": " + toJsonString(userText) + "}]\n" +
                "  }]\n" +
                "}";

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(callback);
    }

    private static String toJsonString(String s) {
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}

