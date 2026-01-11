package com.example.trendsstore;

public class Product {
    public final String name;
    public final String price;
    public final String imageUrl; // can be URL or "android.resource://..."

    public Product(String name, String price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}

