package questions.Design_Airline_Management_System.entity;

import questions.Design_Airline_Management_System.entity.enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private String bookingId;
    private PaymentStatus paymentStatus;

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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Payment(String bookingId) {
        this.paymentId = UUID.randomUUID().toString();
        this.bookingId = bookingId;
        this.paymentStatus = PaymentStatus.PENDING;
    }
}
