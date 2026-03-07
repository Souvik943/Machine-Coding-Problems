package questions.Design_Parking_Lot.entity.ConcreteClass;

import questions.Design_Parking_Lot.entity.Vehicle;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private long ticketId;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Timestamp entryTime;
    private Timestamp exitTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = Long.parseLong(UUID.randomUUID().toString());
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;

        //Get current time
        Instant now = Instant.now();
        this.entryTime = Timestamp.from(now);

        this.exitTime = null;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }
}
