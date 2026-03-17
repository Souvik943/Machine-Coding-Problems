package questions.Design_Airline_Management_System.entity.enums;

import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String paymentId;
    private String bookingId;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(String paymentId, String bookingId) {
        this.ticketId = UUID.randomUUID().toString();
        this.paymentId = paymentId;
        this.bookingId = bookingId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
