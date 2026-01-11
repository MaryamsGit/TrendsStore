package com.example.trendsstore;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GeminiClient {

    private static final String MODEL = "gemini-1.5-flash";
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();
    private final String apiKey;

    public GeminiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String askGemini(String userMessage) throws Exception {

        // 🔴 THIS IS WHERE ?key=YOUR_API_KEY IS PASSED
        String url =
                "https://generativelanguage.googleapis.com/v1beta/models/"
                        + MODEL
                        + ":generateContent"
                        + "?key="
                        + apiKey;

        // Request JSON body
        JSONObject body = new JSONObject();
        JSONArray contents = new JSONArray();
        JSONObject content = new JSONObject();
        JSONArray parts = new JSONArray();

        JSONObject textPart = new JSONObject();
        textPart.put("text", userMessage);

        parts.put(textPart);
        content.put("parts", parts);
        contents.put(content);
        body.put("contents", contents);

        RequestBody requestBody =
                RequestBody.create(body.toString(), JSON);

        Request request = new Request.Builder()
                .url(url)   // ✅ key included here
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                return "Error: " + response.code() + " " + response.message();
            }

            JSONObject json = new JSONObject(response.body().string());
            return json
                    .getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
        }
    }
}
