package DataAcessObject;

import java.util.ArrayList;
import model.FlightSeat;


public interface FlightSeatDAO {
    
     public ArrayList<FlightSeat> findByIdFlight(int flight_idFlight);
         
    
    
}
