package controller;
import DataAcessObjectImpl.FlightDAOImpl;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Airport;
import model.Flight;
import Exceptions.EmptyFields;
import java.util.Date;


public class FlightController {
    
    public FlightController(){
        
    }
    
    public static Flight getFlight(int idFlight) {
        
        return new FlightDAOImpl().find(idFlight);
        
    }
    
    public static void updateFlight(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {
        
        if(new FlightDAOImpl().update(idFlight, idAirplane, airlineName, idDepartureAirport, idArrivalAirport, departureDate, arrivalDate)==false) 
        {
            JOptionPane.showMessageDialog(null, "unable to update flight");
        }
        
    }
    
    public static void addFlight( int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {
        
        if(new FlightDAOImpl().add( idAirplane, airlineName, idDepartureAirport, idArrivalAirport, departureDate, arrivalDate)==false) 
        {
            JOptionPane.showMessageDialog(null, "unable to add flight");
        }
        
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
         catch(Exception e)
         {
             System.out.println(e.getMessage());
         }
       
               
         
        return false;
     }
    
}
