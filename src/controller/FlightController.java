package controller;
import DataAcessObjectImpl.AirplaneDAOImpl;
import DataAcessObjectImpl.AirportDAOImpl;
import DataAcessObjectImpl.FlightDAOImpl;
import DataAcessObjectImpl.FlightSeatDAOImpl;
import Exceptions.EmptyFields;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Flight;
import model.FlightSeat;


public class FlightController {

    public FlightController() {

    }
    
    public static void addFlight(int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate, int nbSeatsFirstClass, int nbSeatsBusinessClass, int nbSeatsEconomyClass, BigDecimal priceFirst, BigDecimal priceBusiness, BigDecimal priceEconomy) {

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
    
    public static void updateFlight(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {
        
        if(new FlightDAOImpl().update(idFlight, idAirplane, airlineName, idDepartureAirport, idArrivalAirport, departureDate, arrivalDate)==false) 
        {
            JOptionPane.showMessageDialog(null, "unable to update flight");
        }
        
    }
    
    public static boolean CheckFlightInfo( Date dateDeparture  ,Date dateArrival, String airlineField)
     {
         try
         {
             if ((dateDeparture==null)&&(dateArrival==null)||(dateDeparture==null)&&(dateArrival!=null)||(dateArrival==null)&&(dateDeparture!=null) ||airlineField==null)
         {
             
             throw new EmptyFields();
              
         }
             return true;
         }
         catch(EmptyFields e)
         {
             System.out.println(e.getMessage());
         }
       
               
         
        return false;
     }
    
    public static boolean CheckFlightInfo( Date dateDeparture  ,Date dateArrival)
     {
         try
         {
             if ((dateDeparture==null)&&(dateArrival==null)||(dateDeparture==null)&&(dateArrival!=null)||(dateArrival==null)&&(dateDeparture!=null))
         {
             
             throw new EmptyFields();
              
         }
             return true;
         }
         catch(EmptyFields e)
         {
             System.out.println(e.getMessage());
         }
       
               
         
        return false;
     }
    
    
    public static void deleteFlight (int idFlight)
    {
        new FlightDAOImpl().delete(idFlight);
        JOptionPane.showMessageDialog(null, "The seat has been deleted");
    }
    
    
    public static int getCountMonth(int month) {
        return new FlightDAOImpl().getCountMonth(month);
        
    }
    
    
    public static boolean checkFlight(String idFlight) {

        try {

            int intIdFlight = Integer.parseInt(idFlight);

            if (new FlightDAOImpl().find(intIdFlight) == null) {
                JOptionPane.showMessageDialog(null, "There is no flight with this Id");
                return false;

            } else {
                return true;

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static ArrayList<Flight> getAllFlights() {

        return new FlightDAOImpl().findAllFlights();

    }

    public static boolean checkFlightSeat(String numberSeats, String seatPrice) {
        try {

            int intNumberSeats = Integer.parseInt(numberSeats);
            BigDecimal bigDecimalSeatPrice = new BigDecimal(seatPrice);

            return true;

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Please, enter valid datas");
            return false;
        }
    }
    
}
