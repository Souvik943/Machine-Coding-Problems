package questions.Design_Airline_Management_System.entity;

import questions.Design_Airline_Management_System.entity.enums.SeatStatus;

public class Seat {
    private String seatId;
    private String flightInstanceId;
    private double seatPrice;
    private SeatStatus seatStatus;
    private int version;

    public Seat(String seatId, String flightInstanceId, double seatPrice) {
        this.seatId = seatId;
        this.flightInstanceId = flightInstanceId;
        this.seatPrice = seatPrice;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.version = 1;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getFlightInstanceId() {
        return flightInstanceId;
    }

    public void setFlightInstanceId(String flightInstanceId) {
        this.flightInstanceId = flightInstanceId;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
