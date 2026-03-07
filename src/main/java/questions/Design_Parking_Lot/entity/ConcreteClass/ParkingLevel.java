package questions.Design_Parking_Lot.entity.ConcreteClass;

import java.util.List;
import java.util.UUID;

public class ParkingLevel {
    private long levelId;
    private int levelNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingLevel(int levelNumber, List<ParkingSpot> parkingSpots) {
        this.levelId = Integer.parseInt(UUID.randomUUID().toString());
        this.levelNumber = levelNumber;
        this.parkingSpots = parkingSpots;
    }

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
