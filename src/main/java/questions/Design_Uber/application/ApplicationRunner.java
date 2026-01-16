package questions.Design_Uber.application;

import questions.Design_Uber.entity.*;
import questions.Design_Uber.entity.Products.Product;
import questions.Design_Uber.entity.Products.UberGo;
import questions.Design_Uber.service.RideService;
import questions.Design_Uber.service.RideServiceImpl;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class ApplicationRunner {
    public static void main(String[] args) throws InterruptedException {

        RideService rideService = new RideServiceImpl();

        Vehicle v1 = new Vehicle("HR51CB5678", List.of(ProductType.UberSedan));
        Vehicle v2 = new Vehicle("HR51CB5692", List.of(ProductType.UberSedan));
        Vehicle v3 = new Vehicle("HR91CB8678", List.of(ProductType.UberGo));
        Vehicle v4 = new Vehicle("HR29CB7778", List.of(ProductType.UberBike));
        Vehicle v5 = new Vehicle("HR51CB5238", List.of(ProductType.UberXL));
        Vehicle v6 = new Vehicle("HR29CB7978", List.of(ProductType.UberBike));

        List<Driver> listOfDrivers = new ArrayList<>();

        Driver driverA = new Driver("Diver_A", v1, new Location(4.3245, 4.9068), 3);
        listOfDrivers.add(driverA);
        Driver driverB = new Driver("Diver_B", v2, new Location(4.1245, 4.190068), 5);
        listOfDrivers.add(driverB);
        Driver driverC = new Driver("Diver_C", v3, new Location(4.300095, 4.968), 7);
        listOfDrivers.add(driverC);
        Driver driverD = new Driver("Diver_D", v4, new Location(4.3173, 4.87668), 8);
        listOfDrivers.add(driverD);
        Driver driverE = new Driver("Diver_E", v5, new Location(4.1095, 4.228), 9);
        listOfDrivers.add(driverE);
        Driver driverF = new Driver("Diver_F", v6, new Location(4.77735, 4.09068), 7);
        listOfDrivers.add(driverF);

        Rider souvik = new Rider("Souvik");
        Location riderSourceLocation = new Location(2.9087, 1.2564);
        Location riderDestinationLocation = new Location(8.987, 8.2564);

        System.out.println("Please choose which test case to run : ");
        System.out.println("1. Happy Path ");
        System.out.println("2. Fare Expires because of TTL");
        System.out.println("3. Concurrency Check");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1) {
            Map<String, Double> fareEstimates = new HashMap<>();
            fareEstimates = rideService.estimateFare(riderSourceLocation, riderDestinationLocation);
            fareEstimates.forEach((product, price) -> System.out.println("Product : " + product + " | Estimated Fare : Rs." + price));
            Product selectedProduct = new UberGo();
            String fareId = rideService.createFare(riderSourceLocation, riderDestinationLocation, selectedProduct);
            Ride ride = rideService.requestRide(riderSourceLocation, riderDestinationLocation, listOfDrivers, souvik, fareId, selectedProduct);
        } else if (choice == 2) {
            Product selectedProduct = new UberGo();
            String fareId2 = rideService.createFare(riderSourceLocation, riderDestinationLocation, selectedProduct);
            Thread.sleep(6000);
            try {
                rideService.requestRide(riderSourceLocation, riderDestinationLocation, listOfDrivers, souvik, fareId2, selectedProduct);
            } catch (RuntimeException e) {
                System.out.println("Caught Expected Error: " + e.getMessage());
            }
        } else if (choice == 3) {
            Product selectedProduct = new UberGo();
            String fareId3 = rideService.createFare(riderSourceLocation, riderDestinationLocation, selectedProduct);
            Rider riderX = new Rider("Rider_X");
            Rider riderY = new Rider("Rider_Y");

            CompletableFuture<Void> requestByX = CompletableFuture.runAsync(() -> {
                try {
                    Ride r = rideService.requestRide(riderSourceLocation, riderDestinationLocation, listOfDrivers, riderX, fareId3, selectedProduct);
                    System.out.println("Rider X successfully booked ride: " + r.getRideId());
                } catch (Exception e) {
                    System.out.println("Rider X failed: " + e.getMessage());
                }
            });

            CompletableFuture<Void> requestByY = CompletableFuture.runAsync(() -> {
                try {
                    Ride r = rideService.requestRide(riderSourceLocation, riderDestinationLocation, listOfDrivers, riderY, fareId3, selectedProduct);
                    System.out.println("Rider Y successfully booked ride: " + r.getRideId());
                } catch (Exception e) {
                    System.out.println("Rider Y failed: " + e.getMessage());
                }
            });

            // Wait for both threads to finish
            CompletableFuture.allOf(requestByX, requestByY).join();
        } else {
            System.out.println("Please enter a correct choice");
        }
    }
}
