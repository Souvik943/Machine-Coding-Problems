package questions.Design_Parking_Lot.entity.ConcreteClass;

import questions.Design_Parking_Lot.entity.Vehicle;
import questions.Design_Parking_Lot.entity.enums.SpotType;
import questions.Design_Parking_Lot.entity.enums.VehicleType;

import java.util.UUID;

public class ParkingSpot {
    private long spotId;
    private Vehicle vehicle;
    private SpotType spotType;
    private boolean isAvailable;

    public ParkingSpot(SpotType spotType) {
        this.spotId = Integer.parseInt(UUID.randomUUID().toString());
        this.spotType = spotType;
        this.isAvailable = false;
    }

    public boolean isParkingSpotAvailable() {
        return isAvailable;
    }

    public boolean canVehicleFit(Vehicle v) {
        if(v.getVehicleType() == VehicleType.BUS) {
            return spotType == SpotType.LARGE;
        } else if(v.getVehicleType() == VehicleType.CAR) {
            return spotType == SpotType.LARGE || spotType == SpotType.MEDIUM;
        }
        return true;
    }

    public synchronized void parkVehicle(Vehicle v) {
        if(isParkingSpotAvailable() && canVehicleFit(v)) {
            this.isAvailable = false;
            this.vehicle = v;
        }
    }

    public synchronized void unParkVehicle(Vehicle v) {
        this.isAvailable = true;
        this.vehicle = null;
    }

    public long getSpotId() {
        return spotId;
    }

    public void setSpotId(long spotId) {
        this.spotId = spotId;
    }

    public Vehicle getVehicleId() {
        return vehicle;
    }

    public void setVehicleId(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
}
