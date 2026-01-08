package com.example.trendsstore;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.trendsstore.R;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bottomNav);

        com.google.android.material.bottomnavigation.BottomNavigationView nav = findViewById(R.id.bottomNav);

        // default screen = Shop
        load(new ShopFragment());

        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_shop) load(new ShopFragment());
            else if (id == R.id.nav_category) load(new CategoryFragment());
            else if (id == R.id.nav_trends) load(new TrendsFragment());
            else if (id == R.id.nav_cart) load(new CartFragment());
            else if (id == R.id.nav_me) load(new MeFragment());
            return true;
        });
    }

    private void load(Fragment f) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();
    }
}
