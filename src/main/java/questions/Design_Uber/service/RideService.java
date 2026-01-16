package questions.Design_Uber.service;

import questions.Design_Uber.entity.*;
import questions.Design_Uber.entity.Products.Product;

import java.util.List;
import java.util.Map;

public interface RideService {
    Map<String, Double> estimateFare(Location source, Location Destination);
    String createFare(Location source, Location Destination, Product product);
    Ride requestRide(Location source, Location Destination, List<Driver> drivers, Rider rider, String fareId, Product productType);
}
