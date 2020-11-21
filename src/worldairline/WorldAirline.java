package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import model.*;


public class WorldAirline {


    public static void main(String[] args) {
        
         
        FlightDAOImpl  flightDaoImpl = new FlightDAOImpl();
        Flight flight =flightDaoImpl.find(3);
        
        
        
    }
    
}
