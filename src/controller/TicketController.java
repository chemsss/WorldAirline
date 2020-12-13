package controller;

import DataAcessObjectImpl.TicketDAOImpl;
import javax.swing.JOptionPane;
import model.Passenger;
import model.Ticket;

public class TicketController {

    public static Ticket getTicket(int ticketNo) {

        return new TicketDAOImpl().getTicket(ticketNo);
    }

    public static void addTicketToBooking(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight) {

        if (new TicketDAOImpl().add(bookingNo, passenger, flightSeatNo, idFlight) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't add ticket into the booking n°" + bookingNo + ".", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void deleteFlight(int idFlight) {
        new TicketDAOImpl().delete(idFlight);
        JOptionPane.showMessageDialog(null, "The ticket has been deleted");
    }
}
