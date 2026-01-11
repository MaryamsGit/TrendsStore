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

public class ShopFragment extends Fragment {

    public ShopFragment() {
        super(R.layout.fragment_shop);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = view.findViewById(R.id.rvProducts);
        rv.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        List<Product> products = new ArrayList<>();
        products.add(new Product("SHEIN Handbag", "Rs 3,068", "https://picsum.photos/400/400?1"));
        products.add(new Product("Women's Dress", "Rs 8,405", "https://picsum.photos/400/400?2"));
        products.add(new Product("Sneakers", "Rs 7,929", "https://picsum.photos/400/400?3"));
        products.add(new Product("Phone Holder", "Rs 1,250", "https://picsum.photos/400/400?4"));
        products.add(new Product("Men Jeans", "Rs 2,999", "https://picsum.photos/400/400?5"));
        products.add(new Product("Beauty Kit", "Rs 1,699", "https://picsum.photos/400/400?6"));

        rv.setAdapter(new ProductAdapter(products));
    }
}
