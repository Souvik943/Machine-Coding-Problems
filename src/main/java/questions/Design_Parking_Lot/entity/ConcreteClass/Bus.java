package questions.Design_Parking_Lot.entity.ConcreteClass;

import questions.Design_Parking_Lot.entity.Vehicle;
import questions.Design_Parking_Lot.entity.enums.VehicleType;

public class Bus extends Vehicle {
    public Bus(String vehiclePlateNumber, VehicleType vehicleType) {
        super(vehiclePlateNumber, VehicleType.BUS);
    }
}
