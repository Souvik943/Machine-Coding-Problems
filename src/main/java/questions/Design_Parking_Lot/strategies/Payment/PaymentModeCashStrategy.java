package questions.Design_Parking_Lot.strategies.Payment;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;

public class PaymentModeCashStrategy implements  FeePaymentMode{
    @Override
    public void pay(Ticket ticket, double amount) {
        System.out.println("Paying : " + amount + " through Cash for ticket : " + ticket.getTicketId());
    }
}
