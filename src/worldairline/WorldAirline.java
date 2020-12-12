package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import controller.BookingController;
import controller.FieldsController;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.swing.JOptionPane;
import view.*;

public class WorldAirline {


    public static void main(String[] args) throws SQLException {
        
         
       MainMenu menu = new MainMenu();
        
       //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
       
      
       //CustomerAccount customer = new CustomerAccount("Child", 7, "capron2009@hotmail.fr","motdepassetitouan","Titouan","Capron","32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
              //new Date(109,03,04),"+33 6 89024763");
//String ageCategory, int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber
      
       //CustomerAccount cm=null;
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
       
       //String test = "CACA-CA234A_@ACACC.A";
       //boolean test123 = FieldsController.checkSignUp(test, "Hello123", "Chems", "Bkh", "+33 423423");
       //System.out.println(test.split("@")[1].split("\\.").length);
        //System.out.println(test);
        
        //System.out.println(new TicketDAOImpl().getPrice(2));
        //System.out.println(new TicketDAOImpl().findByFlightSeat(1, 120));
        //System.out.println(BookingController.getTicketPrice(1, 120));
        
        
        //new FlightDAOImpl().add( 21, 5, "test2324", "MIA", "BOD", new Timestamp(120,11,30, 15, 34, 50, 0), new Timestamp(120,11,30, 17, 34, 50, 0));
        //String email, String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String nationality, String passportNo, ArrayList<Ticket> tickets
        //Passenger passenger = new Passenger("AbbasJiar@gmail.com", "Abbas", "Jiar", "Avenue de Victor Hugo, 75016, Paris", new Date(100, 00, 21), "+33 6 32945094", "France", "756473856", new ArrayList<Ticket>());
            
        //System.out.println("' AND birthDate='"+passenger.getBirthDateYearToString() +"-"+passenger.getBirthDateMonthToString()+"-"+passenger.getBirthDateDateToString()+"' AND");
        //System.out.println(new PassengerDAOImpl().add(passenger));
        
        //(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight)
        /*ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(0, new FlightSeat(153, "Test", new BigDecimal(99.99), false), new FlightDAOImpl().find(4) ));
        tickets.add(new Ticket(0, new FlightSeat(153, "Test", new BigDecimal(99.99), false), new FlightDAOImpl().find(5) ));
        Booking booking = new Booking(new Date(120, 10, 23), tickets);
        //Date bookingDate, ArrayList<Ticket> tickets
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Abbiar@gmail.com", "Abbaaaassss", "Jiaarrrrrrr", "Avenue Hugo, 16, Aris", new Date(100, 00, 21), "+33 6 32945094", "France", "756473856"));
        passengers.add(new Passenger("Assbbiar@gmail.com", "Sabba", "Riaj", "Avenue Gohu, 124, Boris", new Date(100, 00, 21), "+33 6 32945094", "France", "756473856"));
        if(new BookingDAOImpl().add(booking, 0, 0, passengers)==false) {
            System.out.println("noooooooooon");
        }
        else {
            System.out.println("yes !!!!!!!");
        }*/
        /*Booking booking = new Booking(new Date(120, 10, 23), new ArrayList<Ticket>());
        String idAccountString=" is NULL";
        String idCouponString=" is NULL";
        System.out.println("SELECT * FROM booking WHERE bookingDate='" +booking.getBookingDateYearToString() 
                                                +"-" +booking.getBookingDateMonthToString() +"-"
                                                +booking.getBookingDateDayToString() +"' AND customerAccount_idaccount" +idAccountString +" AND coupon_idcoupon"  +idCouponString +";");*/
        //FlightSeat[] availableSeats = new FlightSeatDAOImpl().getAvailableSeats(5, "Economy Class");
        
        //System.out.println(new TicketDAOImpl().getPriceLoggedCustomer(5, 25) +"€");
        //new BookingDAOImpl().delete(42);
        /*String nationality = "Fra4nce";
        
        String str3 = "";
        for(int i=0 ; i < nationality.length() ; ++i) {
            if( Character.isDigit( nationality.charAt(i)) ) {
                str3 = "Your nationality can't contain digits.";
                System.out.println(nationality.charAt(i));
            }
        }
        if(!str3.equals("")) {
            str3 += "Your phone number can't contain letters.";
        }
                
        if(!str3.equals("")) {
            JOptionPane.showMessageDialog(null , str3, "", 0);
        }*/
        
        /*ArrayList<String> arrayTest = new ArrayList();
        System.out.println(arrayTest.size());*/
                
        
        float f = (float) 10.2323;
        System.out.println(Float.toString(12.2f));
    }
    
}
