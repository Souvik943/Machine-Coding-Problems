package questions.Design_Uber.entity.Products;

import questions.Design_Uber.entity.ProductType;

public class UberBike implements Product {
    @Override
    public ProductType getProductType() {
        return ProductType.UberBike;
    }

    @Override
    public double getBaseFare() {
        return 5;
    }

    @Override
    public double getPerKmPrice() {
        return 2;
    }

    @Override
    public double getPerMinPrice() {
        return 2;
    }
}
