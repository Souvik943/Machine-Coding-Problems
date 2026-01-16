package questions.Design_Uber.service;

import questions.Design_Uber.entity.*;
import questions.Design_Uber.entity.Products.*;
import questions.Design_Uber.strategy.DriverMatching.FirstAvailableDriverMatchingStrategy;
import questions.Design_Uber.strategy.DriverMatching.MatchDriver;
import questions.Design_Uber.strategy.FareCalculation.FareCalculator;
import questions.Design_Uber.strategy.FareCalculation.NightTimeStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RideServiceImpl implements RideService{
    private final List<Product> availableProducts;
    private final Map<String, Fare> fareRepository;
    private final FareCalculator fareCalculator;
    private double ttl = 5;
    private final MatchDriver driverMatcher;

    public RideServiceImpl() {
        this.availableProducts = List.of(new UberBike(), new UberAuto(), new UberGo(), new UberSedan(), new UberXL());
        this.fareRepository = new ConcurrentHashMap<>();
        this.fareCalculator = new NightTimeStrategy();
        this.driverMatcher = new FirstAvailableDriverMatchingStrategy();
    }

    @Override
    public Map<String, Double> estimateFare(Location source, Location Destination) {
        Map<String, Double> fareEstimates = new HashMap<>();
        double distance = source.distanceTo(Destination);
        double time = distance*2;

        for(Product product : availableProducts) {
            double baseFare = product.getBaseFare() + product.getPerKmPrice() * distance + product.getPerMinPrice() * time;
            double surgeFare = fareCalculator.calculateSurge(baseFare);
            fareEstimates.put(product.getProductType().toString(), baseFare + surgeFare);
        }
        return fareEstimates;
    }

    @Override
    public String createFare(Location source, Location Destination, Product product) {
        double distance = source.distanceTo(Destination);
        double time = distance*2;

        double baseFare = product.getBaseFare() + product.getPerKmPrice() * distance + product.getPerMinPrice() * time;
        double surgeFare = fareCalculator.calculateSurge(baseFare);

        Fare fare = new Fare(baseFare + surgeFare, ttl);
        fareRepository.put(fare.getFareId(), fare);
        return fare.getFareId();
    }

    @Override
    public Ride requestRide(Location source, Location Destination, List<Driver> drivers, Rider rider, String fareId, Product selectedProduct) {
        Fare oldFare = fareRepository.get(fareId);
        if(oldFare == null || !oldFare.isFareValid()) {
            throw new RuntimeException("Fare is not valid . Pls go back and try again .");
        }
        Optional<Driver> finalisedDriverOptional = driverMatcher.matchDriver(drivers, null, selectedProduct);
        if(finalisedDriverOptional.isEmpty()) {
            throw new RuntimeException("No Drivers were found . Pls try again");
        }
        Driver finalisedDriver = finalisedDriverOptional.get();
        if (!finalisedDriver.reserveDriver()) {
            throw new RuntimeException("Driver " + finalisedDriver.getDriverName() + " was just taken by another rider!");
        }

        System.out.println("Driver is finalised . Name : " + finalisedDriver.getDriverName() + " Vehicle Number : " + finalisedDriver.getVehicle().getPlateNumber());
        Ride ride = new Ride(source, Destination, rider, finalisedDriver, oldFare);
        System.out.println("Ride is created , Amount : Rs." + oldFare.getAmount());
        fareRepository.remove(fareId);
        return ride;
    }
}
