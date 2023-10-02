package com.trendyol.shipment;
import java.util.List;
public class DefaultShipmentStrategy implements IShipmentStrategy {

    @Override
    public ShipmentSize determineShipmentSize(List<Product> products) {
        ShipmentSizeCounter counter = new ShipmentSizeCounter();
        for (Product product : products) {
            counter.addProduct(product);
        }

        if (counter.getCount(ShipmentSize.X_LARGE) >= 3) return ShipmentSize.X_LARGE;
        if (counter.getCount(ShipmentSize.LARGE) >= 3) return ShipmentSize.X_LARGE;
        if (counter.getCount(ShipmentSize.MEDIUM) >= 3) return ShipmentSize.LARGE;
        if (counter.getCount(ShipmentSize.SMALL) >= 3) return ShipmentSize.MEDIUM;

        return findLargestShipmentSize(products);
    }

    private ShipmentSize findLargestShipmentSize(List<Product> products) {
        ShipmentSize largestSize = ShipmentSize.SMALL;
        for (Product product : products) {
            if (product.getSize().ordinal() > largestSize.ordinal()) {
                largestSize = product.getSize();
            }
        }
        return largestSize;
    }
}
