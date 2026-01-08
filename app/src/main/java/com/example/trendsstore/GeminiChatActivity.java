package com.example.trendsstore;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trendsstore.R;
import com.example.trendsstore.GeminiClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

public class GeminiChatActivity extends AppCompatActivity {

    private TextView tvChat;
    private EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemini_chat);

        tvChat = findViewById(R.id.tvChat);
        etMsg = findViewById(R.id.etMsg);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String msg = etMsg.getText().toString().trim();
            if (msg.isEmpty()) return;

            tvChat.append("\nYou: " + msg + "\n");
            etMsg.setText("");

            GeminiClient.send("You are an app assistant. Answer briefly.\nUser: " + msg, new Callback() {
                @Override public void onFailure(Call call, IOException e) {
                    runOnUiThread(() -> tvChat.append("Bot: Error - " + e.getMessage() + "\n"));
                }

                @Override public void onResponse(Call call, Response response) throws IOException {
                    String raw = response.body() != null ? response.body().string() : "";
                    // simplest: show raw JSON (works). You can later parse nicely.
                    runOnUiThread(() -> tvChat.append("Bot: " + raw + "\n"));
                }
            });
        });
    }
}

