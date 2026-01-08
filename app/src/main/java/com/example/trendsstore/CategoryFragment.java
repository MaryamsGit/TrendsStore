package com.example.trendsstore;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.trendsstore.R;

public class CategoryFragment extends Fragment {
    public CategoryFragment() { super(R.layout.fragment_category); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView list = view.findViewById(R.id.listCategories);
        String[] items = {
                "New In", "Sale", "Women Clothing", "Beachwear", "Shoes",
                "Cell Phones & Accessories", "Men Clothing", "Kids", "Home & Living",
                "Beauty & Health", "Sports & Outdoors"
        };
        list.setAdapter(new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, items));
    }
}

