package com.trendyol.shipment;

import java.util.HashMap;
import java.util.Map;

public class ShipmentSizeCounter {
    private Map<ShipmentSize, Integer> counts = new HashMap<>();

    public ShipmentSizeCounter() {
        for (ShipmentSize size : ShipmentSize.values()) {
            counts.put(size, 0);
        }
    }

    public void addProduct(Product product) {
        counts.put(product.getSize(), counts.get(product.getSize()) + 1);
    }

    public int getCount(ShipmentSize size) {
        return counts.getOrDefault(size, 0);
    }
}

