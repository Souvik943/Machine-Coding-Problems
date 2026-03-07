package questions.Design_Parking_Lot.strategies.FeeCalculation;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;

public interface FeeCalculator {
    public double calculateParkingFee(Ticket ticket);
}
