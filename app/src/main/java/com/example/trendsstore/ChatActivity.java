package com.example.trendsstore;


import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trendsstore.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.*;

import java.util.HashMap;
import java.util.Map;

public class ChatActivity extends AppCompatActivity {

    private TextView tvMsgs;
    private EditText etText;
    private FirebaseFirestore db;
    private String myUid;
    private String otherUid = "PUT_OTHER_UID_HERE"; // for demo (replace with real selection later)
    private String chatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tvMsgs = findViewById(R.id.tvMsgs);
        etText = findViewById(R.id.etText);
        Button btnSend = findViewById(R.id.btnSend);

        db = FirebaseFirestore.getInstance();
        myUid = FirebaseAuth.getInstance().getUid();

        if (myUid == null) { finish(); return; }

        chatId = (myUid.compareTo(otherUid) < 0) ? myUid + "_" + otherUid : otherUid + "_" + myUid;

        listenMessages();

        btnSend.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        String text = etText.getText().toString().trim();
        if (text.isEmpty()) return;

        Map<String, Object> msg = new HashMap<>();
        msg.put("from", myUid);
        msg.put("to", otherUid);
        msg.put("text", text);
        msg.put("ts", FieldValue.serverTimestamp());

        db.collection("chats").document(chatId)
                .collection("messages")
                .add(msg);

        etText.setText("");
    }

    private void listenMessages() {
        db.collection("chats").document(chatId)
                .collection("messages")
                .orderBy("ts", Query.Direction.ASCENDING)
                .addSnapshotListener((snap, e) -> {
                    if (snap == null) return;
                    StringBuilder sb = new StringBuilder();
                    for (DocumentSnapshot d : snap.getDocuments()) {
                        String from = d.getString("from");
                        String text = d.getString("text");
                        sb.append(from != null && from.equals(myUid) ? "Me: " : "Them: ");
                        sb.append(text).append("\n");
                    }
                    tvMsgs.setText(sb.toString());
                });
    }
}
