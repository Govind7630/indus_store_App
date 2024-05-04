package com.example.indusstore;
public class Product {
    private int imageResourceId;
    private String name;
    private String price;
    public Product(int imageResourceId, String name, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.price = price;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
}
