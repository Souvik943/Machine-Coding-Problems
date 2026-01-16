package questions.Design_Uber.entity.Products;

import questions.Design_Uber.entity.ProductType;

public class UberAuto implements Product {
    @Override
    public ProductType getProductType() {
        return ProductType.UberAuto;
    }

    @Override
    public double getBaseFare() {
        return 8;
    }

    @Override
    public double getPerKmPrice() {
        return 4;
    }

    @Override
    public double getPerMinPrice() {
        return 4;
    }
}
