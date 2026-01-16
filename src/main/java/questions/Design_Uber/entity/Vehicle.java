package questions.Design_Uber.entity;

import java.util.List;

public class Vehicle {
    private String plateNumber;
    private List<ProductType> productTypeList;

    public Vehicle(String plateNumber, List<ProductType> productTypeList) {
        this.plateNumber = plateNumber;
        this.productTypeList = productTypeList;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }
}
