package com.example.promotion;

public class SKU {
    String id;
    int unitPrice;

    public SKU(String id, int unitPrice) {
        this.id = id;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
