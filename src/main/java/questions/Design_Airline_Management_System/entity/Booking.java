package questions.Design_Airline_Management_System.entity;

import questions.Design_Airline_Management_System.entity.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private String flightInstanceId;
    private List<String> seatList;
    private List<String> userList;
    private double amount;
    private LocalDateTime createdAt;
    private LocalDateTime expiryAt;
    private BookingStatus bookingStatus;

    public Booking(String flightInstanceId, List<String> seatList, List<String> userList, double amount) {
        this.bookingId = UUID.randomUUID().toString();
        this.flightInstanceId = flightInstanceId;
        this.seatList = seatList;
        this.userList = userList;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
        this.expiryAt = LocalDateTime.now().plusMinutes(20);;
        this.bookingStatus = BookingStatus.PENDING;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightInstanceId() {
        return flightInstanceId;
    }

    public void setFlightInstanceId(String flightInstanceId) {
        this.flightInstanceId = flightInstanceId;
    }

    public List<String> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<String> seatList) {
        this.seatList = seatList;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(LocalDateTime expiryAt) {
        this.expiryAt = expiryAt;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
