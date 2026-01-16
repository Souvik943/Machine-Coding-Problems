package questions.Design_Uber.entity.Products;

import questions.Design_Uber.entity.ProductType;

public interface Product {
    ProductType getProductType();
    double getBaseFare();
    double getPerKmPrice();
    double getPerMinPrice();
}
