package questions.Design_Parking_Lot.entity;

import questions.Design_Parking_Lot.entity.enums.VehicleType;

import java.util.UUID;

public abstract class Vehicle {
    private long vehicleId;
    private String vehiclePlateNumber;
    private VehicleType vehicleType;

    public Vehicle(String vehiclePlateNumber, VehicleType vehicleType) {
        this.vehicleId = Integer.parseInt(UUID.randomUUID().toString());
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleType = vehicleType;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
