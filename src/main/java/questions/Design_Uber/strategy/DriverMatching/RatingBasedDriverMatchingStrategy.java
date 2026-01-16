package questions.Design_Uber.strategy.DriverMatching;

import questions.Design_Uber.entity.Driver;
import questions.Design_Uber.entity.Products.Product;

import java.util.List;
import java.util.Optional;

public class RatingBasedDriverMatchingStrategy implements MatchDriver{
    @Override
    public Optional<Driver> matchDriver(List<Driver> driverList, String ratingRequired, Product product) {
        return driverList.stream()
                .filter(driver -> driver.getDriverRatings() > Integer.parseInt(ratingRequired))
                .filter(driver -> driver.getVehicle().getProductTypeList().contains(product.getProductType()))
                .findFirst();
    }
}
