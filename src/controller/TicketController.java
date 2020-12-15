package controller;

import DataAcessObjectImpl.FlightSeatDAOImpl;
import DataAcessObjectImpl.TicketDAOImpl;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import model.CustomerAccount;
import model.Passenger;
import model.Ticket;

public class TicketController {

    public static Ticket getTicket(int ticketNo) {
        
        return new TicketDAOImpl().getTicket(ticketNo);
    }

    public static void addTicketToBooking(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight) {
        
        if (new TicketDAOImpl().add(bookingNo, passenger, flightSeatNo, idFlight) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't add ticket into the booking n°" +bookingNo +"." , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static BigDecimal getTicketPriceNotLogged(int idFlight, int seatNo) {
        return new TicketDAOImpl().getPriceNotLogged(idFlight, seatNo);
    }
    
    public static BigDecimal getTicketPriceLogged(int idFlight, int seatNo, CustomerAccount customer) {
        switch (customer.getAgeCategory()) {
                        case "Regular":
                            System.out.println("REGULAR");
                            return new FlightSeatDAOImpl().getPrice(idFlight, seatNo);
                        case "Senior":
                            System.out.println("SENIOR");
                            return new BigDecimal(0.8).multiply((new FlightSeatDAOImpl().getPrice(idFlight, seatNo)));
                        case "Child":
                            System.out.println("CHILD");
                            return new BigDecimal(0.9).multiply((new FlightSeatDAOImpl().getPrice(idFlight, seatNo)));
        }
        System.out.println("Neither age categories.");
        return new FlightSeatDAOImpl().getPrice(idFlight, seatNo);
    }

      public static void deleteTicket (int ticketNo)
    {
        new TicketDAOImpl().delete(ticketNo);
        JOptionPane.showMessageDialog(null, "The ticket has been deleted");
    }
      
}
