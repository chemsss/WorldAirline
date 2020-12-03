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
        
         
       // MainMenu menu = new MainMenu();
        
       //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
       
      
      CustomerAccount customer = new CustomerAccount("Child","capron2009@hotmail.fr","motdepassetitouan","Titouan","Capron","32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
               new Date(109,03,04),"+33 6 89024763");

      
       CustomerAccount cm=null;
        CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch(customer);
        
        //Flight flight;
        // System.out.println(flight);
                
    }
    
}
