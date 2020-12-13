/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.FlightSeatDAOImpl;
import DataAcessObjectImpl.TicketDAOImpl;
import javax.swing.JOptionPane;
import model.Airport;
import model.CustomerAccount;
import model.Passenger;
import model.Ticket;

/**
 *
 * @author Unknow
 */
public class TicketController {

    public static Ticket getTicket(int ticketNo) {
        
        return new TicketDAOImpl().getTicket(ticketNo);
    }

    public static void addTicketToBooking(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight) {
        
        if (new TicketDAOImpl().add(bookingNo, passenger, flightSeatNo, idFlight) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't add ticket into the booking n°" +bookingNo +"." , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static float getTicketPriceNotLogged(int idFlight, int seatNo) {
        return new TicketDAOImpl().getPriceNotLogged(idFlight, seatNo);
    }
    
    public static float getTicketPriceLogged(int idFlight, int seatNo, CustomerAccount customer) {
        switch (customer.getAgeCategory()) {
                        case "Regular":
                            System.out.println("REGULAR");
                            return new FlightSeatDAOImpl().getPrice(idFlight, seatNo);
                        case "Senior":
                            System.out.println("SENIOR");
                            return (float) (0.8 * (new FlightSeatDAOImpl().getPrice(idFlight, seatNo)));
                        case "Child":
                            System.out.println("CHILD");
                            return (float) (0.9 * (new FlightSeatDAOImpl().getPrice(idFlight, seatNo)));
        }
        System.out.println("Neither age categories.");
        return new FlightSeatDAOImpl().getPrice(idFlight, seatNo);
    }
    
    /*
    public static Airport getDepartureAirport(int ticketNo) {

        return new TicketDAOImpl().getDepartureAirport(ticketNo);
    }

    public static Airport getArrivalAirport(int ticketNo) {

        return new TicketDAOImpl().getArrivalAirport(ticketNo);
    }
    
    public static void getImage(int ticketNo )
    {
        new TicketDAOImpl().getImg(ticketNo);
    }
        
*/  

      public static void deleteFlight (int idFlight)
    {
        new TicketDAOImpl().delete(idFlight);
        JOptionPane.showMessageDialog(null, "The ticket has been deleted");
    }
      
}