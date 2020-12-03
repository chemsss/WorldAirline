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
       //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
        //CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch();
        if(new TicketDAOImpl().add(3, 4, 4, 3)==false) {
            System.out.println("non.");
        }
        if(new BookingDAOImpl().add(new Date(120, 11, 15), 5)==false) {
            System.out.println("nooon.");
        } 
        
                
    }
    
}
