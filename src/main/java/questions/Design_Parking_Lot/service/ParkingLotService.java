package questions.Design_Parking_Lot.service;

import questions.Design_Parking_Lot.entity.ConcreteClass.ParkingLevel;
import questions.Design_Parking_Lot.entity.ConcreteClass.ParkingSpot;
import questions.Design_Parking_Lot.entity.ConcreteClass.Payment;
import questions.Design_Parking_Lot.entity.ConcreteClass.Ticket;
import questions.Design_Parking_Lot.entity.Vehicle;
import questions.Design_Parking_Lot.entity.enums.PaymentMode;
import questions.Design_Parking_Lot.strategies.FeeCalculation.FeeCalculator;
import questions.Design_Parking_Lot.strategies.FeeCalculation.FestivalTimeFeeCalculationStrategy;
import questions.Design_Parking_Lot.strategies.Payment.FeePaymentMode;
import questions.Design_Parking_Lot.strategies.Payment.PaymentModeCashStrategy;
import questions.Design_Parking_Lot.strategies.SpotMatcher.FindFirstAvailableSpotStrategy;
import questions.Design_Parking_Lot.strategies.SpotMatcher.SpotMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotService {
    private static ParkingLotService parkingLotInstance = null;
    private List<Ticket> listOfTickets;
    private List<ParkingLevel> parkingLevels;
    private FeeCalculator feeCalculator;
    private FeePaymentMode feePaymentMode;
    private SpotMatcher spotMatcher;

    private ParkingLotService() {
        listOfTickets = new ArrayList<>();
        parkingLevels = new ArrayList<>();
        feeCalculator = new FestivalTimeFeeCalculationStrategy();
        feePaymentMode = new PaymentModeCashStrategy();
        spotMatcher = new FindFirstAvailableSpotStrategy();
    }

    public static synchronized ParkingLotService getParkingLotServiceInstance() {
        if(parkingLotInstance == null) {
            parkingLotInstance = new ParkingLotService();
        }

        return parkingLotInstance;
    }

    public String generateTicket(Vehicle vehicle) {
        ParkingSpot parkingSpot = null;
        for(ParkingLevel level : parkingLevels) {
            System.out.println("Finding a spot for your vehicle in floor : " + level.getLevelNumber());
            Optional<ParkingSpot> parkingSpotOptional = spotMatcher.findMatchingParkingSpot(level.getParkingSpots(), vehicle);

            if(parkingSpotOptional.isPresent()) {
                parkingSpot = parkingSpotOptional.get();
                System.out.println("Found a parking spot for the vehicle .");
            } else {
                System.out.println("Not able to find a parking spot for the vehicle .");
                return "";
            }
        }


        Ticket ticket = new Ticket(parkingSpot, vehicle);
        parkingSpot.parkVehicle(vehicle);
        listOfTickets.add(ticket);

        return String.valueOf(ticket.getTicketId());
    }

    public String calculateParkingFee(Ticket ticket) {
        if(!listOfTickets.contains(ticket)) {
            System.out.println("Ticket : " + ticket.getTicketId() + " not found");
            return "";
        }

        double parkingFee = feeCalculator.calculateParkingFee(ticket);
        System.out.println("Total amount to be paid is : " + parkingFee);

        return String.valueOf(parkingFee);
    }

    public void payParkingFee(Ticket ticket, double amount) {
        System.out.println("Paying parking fees by : Cash");

        Payment payment = new Payment(ticket, amount, PaymentMode.CASH);
        System.out.println("Payment Receipt : " + payment.getPaymentId());
        feePaymentMode.pay(ticket, amount);
    }
}
