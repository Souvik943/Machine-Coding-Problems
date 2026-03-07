package questions.Design_Parking_Lot.strategies.Payment;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;

public class PaymentModeDebitCardStrategy implements  FeePaymentMode{
    @Override
    public void pay(Ticket ticket, double amount) {
        System.out.println("Paying : " + amount + " through Debit Card for ticket : " + ticket.getTicketId());
    }
}
