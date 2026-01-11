package com.example.trendsstore;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trendsstore.GeminiClient;

public class GeminiChatActivity extends AppCompatActivity {

    private TextView tvChat;
    private EditText etMsg;
    private GeminiClient geminiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemini_chat);

        tvChat = findViewById(R.id.tvChat);
        etMsg = findViewById(R.id.etMsg);
        Button btnSend = findViewById(R.id.btnSend);

        // ✅ Initialize Gemini client with API key
        geminiClient = new GeminiClient(BuildConfig.GEMINI_API_KEY);

        btnSend.setOnClickListener(v -> {
            String msg = etMsg.getText().toString().trim();
            if (msg.isEmpty()) return;

            tvChat.append("\nYou: " + msg + "\n");
            etMsg.setText("");

            String prompt = "You are an app assistant. Answer briefly.\nUser: " + msg;

            // ✅ network call on background thread
            new Thread(() -> {
                try {
                    String reply = geminiClient.askGemini(prompt);
                    runOnUiThread(() -> tvChat.append("Bot: " + reply + "\n"));
                } catch (Exception e) {
                    runOnUiThread(() -> tvChat.append("Bot: Error - " + e.getMessage() + "\n"));
                }
            }).start();
        });
    }
}


