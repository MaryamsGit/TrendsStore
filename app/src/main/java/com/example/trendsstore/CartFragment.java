package com.example.trendsstore;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.trendsstore.R;
import com.example.trendsstore.AuthActivity;

public class CartFragment extends Fragment {
    public CartFragment() { super(R.layout.fragment_cart); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShopByCategory = view.findViewById(R.id.btnShopByCategory);
        Button btnGoLogin = view.findViewById(R.id.btnGoLogin);

        btnShopByCategory.setOnClickListener(v -> {
            // just move user to Category tab: keep it simple (tell them)
            // In real app: communicate with MainActivity to switch tab.
        });

        btnGoLogin.setOnClickListener(v -> startActivity(new Intent(requireContext(), AuthActivity.class)));
    }
}

