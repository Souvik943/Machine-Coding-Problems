package questions.Design_Uber.entity.Products;

import questions.Design_Uber.entity.ProductType;

public class UberXL implements Product {
    @Override
    public ProductType getProductType() {
        return ProductType.UberXL;
    }

    @Override
    public double getBaseFare() {
        return 30;
    }

    @Override
    public double getPerKmPrice() {
        return 20;
    }

    @Override
    public double getPerMinPrice() {
        return 20;
    }
}
