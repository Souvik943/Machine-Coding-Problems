package questions.Design_Parking_Lot.strategies.FeeCalculation;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;
import questions.Design_Parking_Lot.entity.enums.VehicleType;

import java.sql.Timestamp;

public class FestivalTimeFeeCalculationStrategy implements FeeCalculator{

    private double bikeExtraFee = 20;
    private double carExtraFee = 40;
    private double busExtraFee = 50;

    @Override
    public double calculateParkingFee(Ticket ticket) {
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        Timestamp entryTime = ticket.getEntryTime();
        Timestamp exitTime = ticket.getExitTime();
        int duration = exitTime.compareTo(entryTime);
        double parkingFee = 0;
        switch (vehicleType) {
            case BIKE -> {
                parkingFee = (duration * 5) + bikeExtraFee;
            }
            case CAR -> {
                parkingFee = (duration * 20) + carExtraFee;
            }
            case BUS -> {
                parkingFee = (duration * 30) + busExtraFee;
            }
        }

        return parkingFee;
    }
}
