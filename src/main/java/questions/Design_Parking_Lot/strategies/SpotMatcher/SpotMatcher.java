package questions.Design_Parking_Lot.strategies.SpotMatcher;

import questions.Design_Parking_Lot.entity.ConcreteClass.ParkingSpot;
import questions.Design_Parking_Lot.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface SpotMatcher {
    public Optional<ParkingSpot> findMatchingParkingSpot(List<ParkingSpot> parkingSpots, Vehicle vehicle);
}
