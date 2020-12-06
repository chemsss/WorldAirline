package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import controller.BookingController;
import controller.SignUpController;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.swing.JOptionPane;
import view.*;

public class WorldAirline {


    public static void main(String[] args) throws SQLException {
        
         
       //MainMenu menu = new MainMenu();
        
       //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
       
      
       CustomerAccount customer = new CustomerAccount("Child","capron2009@hotmail.fr","motdepassetitouan","Titouan","Capron","32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
               new Date(109,03,04),"+33 6 89024763");

      
       CustomerAccount cm=null;
        //CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch(customer);
        
        /*
        if(new BookingDAOImpl().add(new Date(120,3,21), 5, 3)==false) {
            System.out.println("nn");
        }
        
        if(new CouponDAOImpl().add("GLSTKF", 10)==false) {
            System.out.println("nnn");
            
        }*/
        //CustomerAccount customer = new CustomerAccount("Child", 8, "test1234@hotmail.fr", "password", "FirstName", "LastName", "address nulle", new Date(120, 10, 29), "+33 6 12325894");
        //(String ageCategory, int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber)
        /*if(new EmployeeAccountDAOImpl().update(new EmployeeAccount(11, "test1234@hotmail.fr", "password", "FirstName", "LastName", "address nulle", new Date(120, 10, 29), "+33 6 12325894"))==false) {
            System.out.println("noon");
        }*/
        
        //Flight flight;
        // System.out.println(flight);
        
       // System.out.println(new PassengerDAOImpl().find(9).toString());
        //System.out.println(new PassengerDAOImpl().findByTicketNo(1).toString());
        
        
       /*int ticketNo = 123;
        System.out.println(Integer.toString(ticketNo).length());
        String toString = Integer.toString(ticketNo);
        for(int i=0 ; i < 12-Integer.toString(ticketNo).length(); ++i) {
            toString = "0"+toString;
        }
        System.out.println(toString);
        System.out.println(toString.length());*/
       
       String test = "CACA-CA234A_@ACACC.A";
       boolean test123 = SignUpController.checkFields(test, "Hello123", "Chems", "Bkh", "+33 423423");
       System.out.println(test.split("@")[1].split("\\.").length);
        System.out.println(test);
        
        System.out.println(new TicketDAOImpl().getPrice(2));
        //System.out.println(new TicketDAOImpl().findByFlightSeat(1, 120));
        System.out.println(BookingController.getTicketPrice(1, 120));
        
        new FlightDAOImpl().add( 20, 5, "test2324", "MIA", "BOD", new Timestamp(120,11,30, 10, 34, 50, 0), new Timestamp(120,11,30, 10, 34, 50, 0));
    }
    
}
