package questions.Design_Parking_Lot.strategies.Payment;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;

public class PaymentModeUPIStrategy implements  FeePaymentMode{
    @Override
    public void pay(Ticket ticket, double amount) {
        System.out.println("Paying : " + amount + " through UPI for ticket : " + ticket.getTicketId());
    }
}
