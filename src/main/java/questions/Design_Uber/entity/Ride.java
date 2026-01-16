package questions.Design_Uber.entity;

import java.util.UUID;

public class Ride {
    private String rideId;
    private Location source;
    private Location destination;
    private Rider rider;
    private Driver driver;
    private Fare fare;

    public Ride(Location source, Location destination, Rider rider, Driver driver, Fare fare) {
        this.rideId = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.rider = rider;
        this.driver = driver;
        this.fare = fare;
    }

    public String getRideId() {
        return rideId;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Fare getFare() {
        return fare;
    }
}
