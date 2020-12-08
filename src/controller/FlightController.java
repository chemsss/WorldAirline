package controller;
import DataAcessObjectImpl.FlightDAOImpl;
import DataAcessObjectImpl.FlightSeatDAOImpl;
import model.Flight;
import model.FlightSeat;


public class FlightController {
    
    public FlightController(){
        
    }
    
    public static Flight getFlight(int idFlight) {
        
        return new FlightDAOImpl().find(idFlight);
        
    }
    
    public static FlightSeat[] getAvailableSeats(int idFlight, String className) {
        
        return new FlightSeatDAOImpl().getAvailableSeats(idFlight, className);
        
    }
    
            
    
}
