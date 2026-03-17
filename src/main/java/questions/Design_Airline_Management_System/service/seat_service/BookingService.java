package questions.Design_Airline_Management_System.service.seat_service;

import questions.Design_Airline_Management_System.entity.*;
import questions.Design_Airline_Management_System.entity.enums.BookingStatus;
import questions.Design_Airline_Management_System.entity.enums.PaymentStatus;
import questions.Design_Airline_Management_System.entity.enums.Ticket;
import questions.Design_Parking_Lot.entity.enums.PaymentMode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private InMemoryDB inMemoryDB;

    public BookingService(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    double totalAmount = 0;
    List<String> lockedSeats = new ArrayList<>();

    public String reserve(List<String> userIdList, List<String> seatIdList, String flightInstanceId) {
        FlightInstance flightInstance = inMemoryDB.flightInstances.get(flightInstanceId);
        Flight flight = inMemoryDB.flights.get(flightInstance.getFlightId());
        String bookingId = "";

        try {
            for(String seatId : seatIdList) {
                Seat seat = inMemoryDB.seats.get(seatId);
                boolean isSeatLocked = inMemoryDB.lockSeat(seatId, seat.getVersion());
                if(!isSeatLocked) {
                    throw new RuntimeException("Error while locking seats");
                }

                lockedSeats.add(seatId);

                totalAmount += seat.getSeatPrice();
            }

            totalAmount += flight.getBasePrice() * seatIdList.size();

            Booking booking = new Booking(flightInstanceId, seatIdList, userIdList, totalAmount);
            inMemoryDB.bookings.put(booking.getBookingId(), booking);

            bookingId = booking.getBookingId();

        } catch (Exception e) {
            for(String seatId : seatIdList) {
                inMemoryDB.unlockSeat(seatId);
            }
        }

        return bookingId;
    }

    public String payAndBook(String bookingId, PaymentMode paymentMode) {
        Booking booking = inMemoryDB.bookings.get(bookingId);

        if(LocalDateTime.now().isAfter(booking.getExpiryAt())) {
            booking.setBookingStatus(BookingStatus.FAILED);
            for(String seatId : booking.getSeatList()) {
                inMemoryDB.unlockSeat(seatId);
            }
        }

        Payment payment = new Payment(bookingId);
        payment.setPaymentStatus(PaymentStatus.COMPLETED);

        for(String seatId : booking.getSeatList()) {
            inMemoryDB.confirmSeat(seatId);
        }

        Ticket ticket = new Ticket(payment.getPaymentId(), bookingId);

        return ticket.getTicketId();
    }
}
