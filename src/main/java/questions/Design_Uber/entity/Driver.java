package questions.Design_Uber.entity;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class Driver {
    private String driverId;
    private String driverName;
    private Vehicle vehicle;
    private Location currentLocation;
    private int driverRatings;
    private AtomicBoolean driverAvailable;

    public Driver(String driverName, Vehicle vehicle, Location currentLocation, int driverRatings) {
        this.driverId = UUID.randomUUID().toString();
        this.driverName = driverName;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.driverRatings = driverRatings;
        this.driverAvailable = new AtomicBoolean(true);
    }

    public String getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public AtomicBoolean getDriverAvailable() {
        return driverAvailable;
    }

    public int getDriverRatings() {
        return driverRatings;
    }

    public boolean reserveDriver() {
        return this.driverAvailable.compareAndSet(true, false);
    }
}
