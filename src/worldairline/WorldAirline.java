package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import controller.BookingController;
import controller.FieldsController;
import controller.FlightController;
import java.awt.Frame;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import view.*;

import org.jfree.chart.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import view.Employee.EmployeeHome;
import view.MainMenu;

public class WorldAirline {


    public static void main(String[] args) {
        
        
         
       //MainMenu menu = new MainMenu();
       
       //EmployeeHome home = new EmployeeHome();
        
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
                
        /*
        float f = (float) 10.2323;
        System.out.println(Float.toString(12.2f));
        Flight flight = new Flight(0 , "EcoAirline", new Timestamp(120, 02,9,13,40,07,0), new Timestamp(120, 02,05,15,40,03,0),
                new Airplane(9, "Zoeing A013", 200), new Airport("CHH", "GARGES-LES-GONNESSES Sud", "Garges-Les-Gonnesses", "France"), new Airport("CCC", "Roubaix Nord", "Roubaix", "France"), new ArrayList<FlightSeat>());
        //int idFlight, String airlineName, Timestamp departureDate, Timestamp arrivalDate, Airplane airplane, Airport departureAirport, Airport arrivalAirport, ArrayList<FlightSeat> seats
        if((new FlightDAOImpl().add(flight , 25, 75, 100, (float)500.99, (float)200.99, (float)99.99)) == false) {
        


        //int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate, 
        //int nbSeatsFirstClass, int nbSeatsBusinessClass, int nbSeatsEconomyClass, float priceFirst, float priceBusiness, float priceEconomy
            System.out.println("add flight failed");
            Timestamp time = new Timestamp( 120 , 11 , 05 , 13 , 40 , 0 , 0);
            System.out.println(time.toString());
        }
        float price = (float) 50.9999;
        String priceS = String.format("%.2f", price);
        
        System.out.println(priceS.replace(",", "."));
        */
        
        //FlightController.addFlight(9, "EcoAirline", "CHH", "CCC", new Timestamp(120, 02,9,13,40,07,0), new Timestamp(120, 02,05,15,40,03,0), 10, 90, 100, (float)1000.98, (float)700.50, (float)200.12);
        /*DefaultCategoryDataset datasett = new DefaultCategoryDataset();  
  
        // Population in 2005  
        
        
        
        datasett.addValue(new FlightDAOImpl().getCountMonth(1), "Full flights", "January");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(2), "Full flights", "February");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(3), "Full flights", "Mars");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(4), "Full flights", "April");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(5), "Full flights", "May");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(6), "Full flights", "June"); 
        datasett.addValue(new FlightDAOImpl().getCountMonth(7), "Full flights", "July");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(8), "Full flights", "August");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(9), "Full flights", "September"); 
        datasett.addValue(new FlightDAOImpl().getCountMonth(10), "Full flights", "October");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(11), "Full flights", "November");  
        datasett.addValue(new FlightDAOImpl().getCountMonth(12), "Full flights", "December");
        
        
        CategoryDataset dataset = datasett;
        JFreeChart chart = ChartFactory.createBarChart("Number of flights according through the year", "Month", "Number of flights", dataset);
        
        ChartPanel panel = new ChartPanel(chart);
        JPanel panel1 = new JPanel();
        panel1.add(panel);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel1);*/
        
        //System.out.println(new AirportDAOImpl().findAirportPourcentage("CDG"));
        try {


        new MainMenu();
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

}
