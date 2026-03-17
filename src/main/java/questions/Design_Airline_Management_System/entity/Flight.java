package questions.Design_Airline_Management_System.entity;

import java.util.UUID;

public class Flight {
    private String flightId;
    private String flightName;
    private String source;
    private String destination;
    private double basePrice;

    public Flight(String flightName, String source, String destination, double basePrice) {
        this.flightId = UUID.randomUUID().toString();
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.basePrice = basePrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
