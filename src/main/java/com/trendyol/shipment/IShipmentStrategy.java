package com.trendyol.shipment;
import java.util.List;

public interface IShipmentStrategy {
    ShipmentSize determineShipmentSize(List<Product> products);
}
