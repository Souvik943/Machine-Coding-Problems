package questions.Design_Airline_Management_System.service.seat_service;

import questions.Design_Airline_Management_System.entity.Booking;
import questions.Design_Airline_Management_System.entity.Flight;
import questions.Design_Airline_Management_System.entity.FlightInstance;
import questions.Design_Airline_Management_System.entity.Seat;
import questions.Design_Airline_Management_System.entity.enums.SeatStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDB {
    Map<String, Flight> flights = new ConcurrentHashMap<>();
    Map<String, FlightInstance> flightInstances = new ConcurrentHashMap<>();
    Map<String, Seat> seats = new ConcurrentHashMap<>();
    Map<String, Booking> bookings = new HashMap<>();

    public boolean lockSeat(String seatId, int prevVersion) {
        Seat seat = seats.get(seatId);
        if(seat == null) {
            return false;
        }
        synchronized (seat) {
            if(seat.getSeatStatus() == SeatStatus.AVAILABLE && seat.getVersion() == prevVersion) {
                seat.setSeatStatus(SeatStatus.LOCKED);
                seat.setVersion(seat.getVersion() + 1);
                return true;
            }
        }
        return false;
    }

    public void unlockSeat(String seatId) {
        Seat seat = seats.get(seatId);
        synchronized (seat) {
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seat.setVersion(seat.getVersion() + 1);
        }
    }

    public void confirmSeat(String seatId) {
        Seat seat = seats.get(seatId);
        synchronized (seat) {
            seat.setSeatStatus(SeatStatus.BOOKED);
            seat.setVersion(seat.getVersion() + 1);
        }
    }
}
