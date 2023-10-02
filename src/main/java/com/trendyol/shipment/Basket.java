package com.trendyol.shipment;

import java.util.List;

public class Basket {
    private List<Product> products;
    private final IShipmentStrategy shipmentStrategy = new DefaultShipmentStrategy();

    public ShipmentSize getShipmentSize() {
        return shipmentStrategy.determineShipmentSize(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
