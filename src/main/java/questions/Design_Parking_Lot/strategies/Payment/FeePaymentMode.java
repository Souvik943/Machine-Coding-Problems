package questions.Design_Parking_Lot.strategies.Payment;

import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;

public interface FeePaymentMode {
    public void pay(Ticket ticket, double amount);
}
