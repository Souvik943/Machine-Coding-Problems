package questions.Design_Uber.strategy.DriverMatching;

import questions.Design_Uber.entity.Driver;
import questions.Design_Uber.entity.Products.Product;

import java.util.List;
import java.util.Optional;

public interface MatchDriver {
    Optional<Driver> matchDriver(List<Driver> driverList, String ratingRequired, Product product);
}
