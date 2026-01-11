package com.example.trendsstore;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendsstore.R;
import com.example.trendsstore.Product;
import com.example.trendsstore.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrendsFragment extends Fragment {

    public TrendsFragment() {
        super(R.layout.fragment_trends);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = view.findViewById(R.id.rvTrending);
        rv.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<Product> trending = new ArrayList<>();
        trending.add(new Product("Trendy Hoodie", "Rs 5,351", "https://picsum.photos/400/400?11"));
        trending.add(new Product("New Sneakers", "Rs 6,416", "https://picsum.photos/400/400?12"));
        trending.add(new Product("Elegant Dress", "Rs 10,394", "https://picsum.photos/400/400?13"));
        trending.add(new Product("Kids Outfit", "Rs 1,569", "https://picsum.photos/400/400?14"));

        rv.setAdapter(new ProductAdapter(trending));
    }
}
