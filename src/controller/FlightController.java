package controller;
import DataAcessObjectImpl.FlightDAOImpl;
import model.Flight;


public class FlightController {
    
    public FlightController(){
        
    }
    
    public static Flight getFlight(int idFlight) {
        
        return new FlightDAOImpl().find(idFlight);
        
    }
    
            
    
}
