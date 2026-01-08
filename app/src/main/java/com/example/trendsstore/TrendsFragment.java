package com.example.trendsstore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.trendsstore.R;

public class TrendsFragment extends Fragment {

    public TrendsFragment() {
        super(R.layout.fragment_trends); // Linking the fragment layout
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Example: Modify TextView or any other UI components here
        TextView tvTrends = view.findViewById(R.id.tvTrends);
        tvTrends.setText("Latest Trending Products");

        // You can later add RecyclerView or other UI components here to display dynamic data
    }
}
