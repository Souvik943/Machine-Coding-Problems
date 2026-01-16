package questions.Design_Uber.entity.Products;

import questions.Design_Uber.entity.ProductType;

public class UberGo implements Product {
    @Override
    public ProductType getProductType() {
        return ProductType.UberGo;
    }

    @Override
    public double getBaseFare() {
        return 10;
    }

    @Override
    public double getPerKmPrice() {
        return 5;
    }

    @Override
    public double getPerMinPrice() {
        return 5;
    }
}
