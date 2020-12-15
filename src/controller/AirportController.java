package controller;
import model.Airport;
import DataAcessObjectImpl.AirportDAOImpl;
import java.util.ArrayList;


public class AirportController {
    
    public static Airport[] getAllAirports() {
        return new AirportDAOImpl().findAllAirports();
    }
    
    public static ArrayList<Double> findPercentageAllAirports() {
        
        return new AirportDAOImpl().findPercentageAllAirpots();
        
    }
    
    public static ArrayList<String> findAllAirportNames() {
        
        return new AirportDAOImpl().findAllAirportNames();
        
    }
}
