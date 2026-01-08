package com.example.trendsstore;


import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trendsstore.R;
import com.example.trendsstore.*;
import com.google.firebase.auth.FirebaseAuth;

public class MeFragment extends Fragment {

    public MeFragment() { super(R.layout.fragment_me); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvUser = view.findViewById(R.id.tvUser);
        Button btnQR = view.findViewById(R.id.btnQR);
        Button btnGemini = view.findViewById(R.id.btnGemini);
        Button btnChat = view.findViewById(R.id.btnChat);
        Button btnLogout = view.findViewById(R.id.btnLogout);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            tvUser.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }

        btnQR.setOnClickListener(v -> startActivity(new Intent(requireContext(), QrScannerActivity.class)));
        btnGemini.setOnClickListener(v -> startActivity(new Intent(requireContext(), GeminiChatActivity.class)));
        btnChat.setOnClickListener(v -> startActivity(new Intent(requireContext(), ChatActivity.class)));

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(requireContext(), AuthActivity.class));
            requireActivity().finish();
        });
    }
}

