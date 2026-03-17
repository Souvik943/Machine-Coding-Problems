package questions.Design_Airline_Management_System.service.seat_service;

import questions.Design_Airline_Management_System.entity.Flight;
import questions.Design_Airline_Management_System.entity.FlightInstance;

import java.time.LocalDateTime;
import java.util.List;

public class SearchService {
    private InMemoryDB inMemoryDB;

    public SearchService(InMemoryDB inMemoryDB) {
        this.inMemoryDB = inMemoryDB;
    }

    public List<FlightInstance> searchFlight(String source, String destination, LocalDateTime date) {
        return inMemoryDB.flightInstances.values().stream()
                .filter(fi -> fi.getDate().equals(date))
                .filter(fi -> {
                    Flight flight = inMemoryDB.flights.get(fi.getFlightId());
                    return flight.getSource().equals(source) && flight.getDestination().equals(destination);
                })
                .toList();
    }
}
