package controller;
import DataAcessObjectImpl.AirplaneDAOImpl;
import DataAcessObjectImpl.AirportDAOImpl;
import DataAcessObjectImpl.FlightDAOImpl;
import DataAcessObjectImpl.FlightSeatDAOImpl;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Flight;
import model.FlightSeat;


public class FlightController {
    
    public FlightController(){
        
    }
    
    public static void addFlight(int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate, int nbSeatsFirstClass, int nbSeatsBusinessClass, int nbSeatsEconomyClass, float priceFirst, float priceBusiness, float priceEconomy) {

        Flight flight = new Flight(0 , airlineName, departureDate, arrivalDate,
                new AirplaneDAOImpl().find(idAirplane), new AirportDAOImpl().find(idDepartureAirport), new AirportDAOImpl().find(idArrivalAirport), new ArrayList<FlightSeat>());
//int idFlight, String airlineName, Timestamp departureDate, Timestamp arrivalDate, Airplane airplane, Airport departureAirport, Airport arrivalAirport, ArrayList<FlightSeat> seats
        if (new FlightDAOImpl().add(flight, nbSeatsFirstClass, nbSeatsBusinessClass, nbSeatsEconomyClass, priceFirst, priceBusiness, priceEconomy) == false) {
            JOptionPane.showMessageDialog(null, "unable to add flight");
        }

    }
    
    public static Flight getFlight(int idFlight) {
        
        return new FlightDAOImpl().find(idFlight);
        
    }
    
    public static FlightSeat[] getAvailableSeats(int idFlight, String className) {
        
        return new FlightSeatDAOImpl().getAvailableSeats(idFlight, className);
        
    }
    
            
    
}
