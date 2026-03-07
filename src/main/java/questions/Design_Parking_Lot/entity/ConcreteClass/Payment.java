package questions.Design_Parking_Lot.entity.ConcreteClass;

import questions.Design_Parking_Lot.entity.enums.PaymentMode;
import questions.Design_Parking_Lot.entity.enums.PaymentStatus;

public class Payment {
    private long paymentId;
    private Ticket ticket;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public Payment(Ticket ticket, double amount, PaymentMode paymentMode) {
        this.ticket = ticket;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
