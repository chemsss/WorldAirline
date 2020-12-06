package worldairline;

import DataAcessObject.*;
import DataAcessObjectImpl.*;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import controller.*;

public class WorldAirline {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());

            /*   MainMenu menu = new MainMenu();
            
            //WorldAirlineCustomerProgram test=new WorldAirlineCustomerProgram();
            
            
            CustomerAccount customer = new CustomerAccount(7,"Child","capron2009@hotmail.fr","motdepassetitouan","Titouan","Capron","32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
                    new Date(109,03,04),"+33 6 89024763");
            
pa            
            CustomerAccount cm=null;
            CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch(customer);
             */
            //   CustomerAccount customer = new CustomerAccount(7, "Child", "capron2009@hotmail.fr", "motdepassetitouan", "Titouan", "Capron", "32, rue Louise Michel, 92300, LEVALLOIS-PERRET",
            //           new Date(109, 03, 04), "+33 6 89024763");
            CustomerAccount customer = new CustomerAccountDAOImpl().find(7);
            CustomerHomeFlightSearch prgm = new CustomerHomeFlightSearch(customer);
            //Flight flight;
            // System.out.println(flight);

            // Ticket ticket = new TicketDAOImpl().getTicket(8);
            //    new TicketDAOImpl().inserImg(6);
            //(int ticketNo, FlightSeat seat, Flight flight)*/
            ArrayList<Flight> flights = new ArrayList<Flight>();
            flights.add(new FlightDAOImpl().find(5));
            flights.add(new FlightDAOImpl().find(5));

           PassengersInfosFrame pv = new PassengersInfosFrame(flights,  1);
        //    MainMenu menu = new MainMenu();


        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WorldAirline.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
