package questions.Design_Parking_Lot.strategies.SpotMatcher;

import questions.Design_Parking_Lot.entity.ConcreteClass.ParkingSpot;
import questions.Design_Parking_Lot.entity.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindFarthestAvailableSpotStrategy implements SpotMatcher{
    @Override
    public Optional<ParkingSpot> findMatchingParkingSpot(List<ParkingSpot> parkingSpots, Vehicle vehicle) {
        return parkingSpots.stream()
                .sorted(Comparator.comparing(ParkingSpot::getSpotId).reversed())
                .filter(spot -> spot.canVehicleFit(vehicle))
                .filter(spot -> spot.isParkingSpotAvailable())
                .findFirst();
    }
}
