package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import view.*;

public class WorldAirline {


    public static void main(String[] args) {
        
         
        //MainMenu menu = new MainMenu();
       // WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
        CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch();
        
        Date date = new Date(121, 03, 02);
        System.out.println(new FlightDAOImpl().searchFlights( "CDG", "MIA", date, 20, "First Class").size());
        
        for(int i=0; i < new FlightDAOImpl().searchFlights( "CDG" , "MIA", date, 20, "First Class").size() ;++i) {
            System.out.println(new FlightDAOImpl().searchFlights( "CDG" , "MIA", date, 20, "First Class").get(i).toString());
        }
        
        System.out.println(date.toString());
                
    }
    
}
