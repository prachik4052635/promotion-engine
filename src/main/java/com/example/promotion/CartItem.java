package com.example.promotion;

public class CartItem {
    SKU sku;
    int quantity;

    public CartItem(SKU sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public SKU getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
