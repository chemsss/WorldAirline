/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.TicketDAOImpl;
import javax.swing.JOptionPane;
import model.Airport;
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
      public static void addTicketToBooking(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight) {

        if (new TicketDAOImpl().add(bookingNo, passenger, flightSeatNo, idFlight) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't add ticket into the booking n°" +bookingNo +"." , "Error", JOptionPane.ERROR_MESSAGE);
        }

    }  

      
      public static void deleteFlight (int idFlight)
    {
        new TicketDAOImpl().delete(idFlight);
        JOptionPane.showMessageDialog(null, "The ticket has been deleted");
    }
}