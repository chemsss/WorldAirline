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
        
         
        MainMenu menu = new MainMenu();
      //CustomerLogin cl =new CustomerLogin();
       // MainMenuTest menu = new MainMenuTest();
           //menu.setLocationRelativeTo(null);

        
        /*FlightDAOImpl  flightDaoImpl = new FlightDAOImpl();
        Flight flight =flightDaoImpl.find(3);
        System.out.println(new FlightDAOImpl().find(3).toString());
        
        System.out.println(new BookingDAOImpl().find(3).toString());
        
        ArrayList<Booking> bookings = new BookingDAOImpl().findByIdCustomerAccount(3);
        for(int i = 0 ; i < bookings.size() ; ++i) {
            System.out.println(bookings.get(i).toString());
        }
        
        System.out.println(new CustomerAccountDAOImpl().find(3).toString());
        
        System.out.println(new EmployeeAccountDAOImpl().find(1).toString());*/
        
        
        /*if(new FlightSeatDAOImpl().findByIdFlight(12) != null) {
            ArrayList<FlightSeat> seats = new FlightSeatDAOImpl().findByIdFlight(5);
            for(int i=0 ; i < seats.size() ; ++i) {
                System.out.println(seats.get(i).toString());
            }
        }
        else {
            System.out.println("Ce vol n'existe pas.");
        }*/
        
        /*if(new AirplaneDAOImpl().create(new Airplane(0, "Zoeing A013", 200)) ) {
            System.out.println("successfully added airplane");
        }
        else{
            System.out.println("airplane not added");
        }*/
        
        /*if(new AirportDAOImpl().create(new Airport("CHH", "GARGES-LES-GONNESSES Sud", "Garges-Les-Gonnesses", "France")) ) {
            System.out.println("successfully added airport");
        }
        else{
            System.out.println("airport not added");
        }*/
        
        /*if(new EmployeeAccountDAOImpl().create(new EmployeeAccount(0 , "test123@gmail.com", "testPassword123", "FirstName", "lastName", "address", new Date(120, 11, 24), "+33 6 82940293")) ) {
            System.out.println("successfully added employee account");
        }
        else{
            System.out.println("employee account not added");
        }*/
        
        /*if(new CustomerAccountDAOImpl().create(new CustomerAccount( "Child", new ArrayList<Booking>(), 0 , "test123@gmail.com", "testPassword123", "FirstName", "lastName", "address", new Date(120, 11, 24), "+33 6 82940293")) ) {
            System.out.println("successfully added employee account");
        }
        else{
            System.out.println("employee account not added");
        }*/
        
        if(new CustomerAccountDAOImpl().find("ChungLeGioi@armyspy.com", "c4b8532c3d6f52dd47cd1e0075c0454f") != null) {
            System.out.println(new CustomerAccountDAOImpl().find("AbbasJiar@gmail.com", "cc03e747a6afbbcbf8be7668acfebee5").toString());
        }
        else{
            System.out.println("No customer account with this email and password");
        }
        
    }
    
}
