package DataAcessObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import model.Flight;


public interface FlightDAO {

    Flight find(int flight_idFlight);
    ArrayList<Flight> searchFlights(String DepartureAirportId, String arrivalAirportId, Date departureDate, int nbOfSeats, String className);
    boolean update(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate);
    boolean add(int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate);
    boolean delete(int idFlight);
    ArrayList<Flight> findAllFlights();
     
     
}
