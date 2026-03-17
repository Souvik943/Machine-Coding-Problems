package questions.Design_Airline_Management_System.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class FlightInstance {
    private String flightInstanceId;
    private String flightId;
    private LocalDateTime date;

    public FlightInstance(String flightId, LocalDateTime date) {
        this.flightInstanceId = UUID.randomUUID().toString();
        this.flightId = flightId;
        this.date = date;
    }

    public String getFlightInstanceId() {
        return flightInstanceId;
    }

    public void setFlightInstanceId(String flightInstanceId) {
        this.flightInstanceId = flightInstanceId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
