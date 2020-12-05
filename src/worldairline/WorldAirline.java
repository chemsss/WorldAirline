package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import java.util.Arrays;
import view.*;

public class WorldAirline {


    public static void main(String[] args) throws SQLException {
        
         
       //MainMenu menu = new MainMenu();
        
       //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
       
      
       /*CustomerAccount customer = new CustomerAccount("Child","capron2009@hotmail.fr","motdepassetitouan","Titouan","Capron","32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
               new Date(109,03,04),"+33 6 89024763");

      
       CustomerAccount cm=null;
        CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch(customer);*/
        
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
       
       String test = "CACACAA@ACA.CCA";
       System.out.println(test.split("@")[1].split("\\.").length);
       
                
    }
    
}
