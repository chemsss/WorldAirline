/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

import DataAcessObject.TicketDAO;
import model.Ticket;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Unknow
 */
public class TicketDAOImpl implements TicketDAO {

    @Override
    public ArrayList<Ticket> findByBookingNo(int booking_bookingNo) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where booking_bookingNo=" + booking_bookingNo + ";");

            while (myRs.next()) {

                /*FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
                Flight flight = flightDAOImpl.find(myRs.getInt("flight_idFlight"));

                FlightSeatDAO flightSeatDAOImpl = new FlightSeatDAOImpl();
                ArrayList<FlightSeat> seats = flightSeatDAOImpl.findByIdFlight(myRs.getInt("flight_idFlight"));*/

                tickets.add(new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;

    }
    
    public ArrayList<Ticket> findByIdPassenger(int passenger_idPassenger) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where passenger_idPassenger=" + passenger_idPassenger + ";");

            while (myRs.next()) {

                /*FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
                Flight flight = flightDAOImpl.find(myRs.getInt("flight_idFlight"));

                FlightSeatDAO flightSeatDAOImpl = new FlightSeatDAOImpl();
                ArrayList<FlightSeat> seats = flightSeatDAOImpl.findByIdFlight(myRs.getInt("flight_idFlight"));*/

                tickets.add(new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;

    }
    
    public Ticket findByFlightSeat(int idFlight, int seatNo) {

        Ticket ticket = null;
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where flight_idFlight=" + idFlight + " AND flightSeat_seatNo= " +seatNo +";");

            if(myRs.first()) {
                
                ticket = new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(idFlight).get(seatNo - 1), new FlightDAOImpl().find(idFlight));
                return ticket;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;

    }
    
    
    public boolean add(int bookingNo, int idPassenger, int flightSeatNo, int idFlight) {
                
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ticket WHERE flight_idFlight=" + idFlight + " AND flightSeat_seatNo=" +flightSeatNo + ";");
            if(myRs.first()) {
                System.out.println("Ticket for the seat n°" +flightSeatNo +" in the flight n°" +idFlight +" already exists.");
                return false;
            }
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `ticket` (`booking_bookingNo`, `passenger_idPassenger`, `flightSeat_seatNo`, `flight_idFlight`) VALUES (?, ?, ?, ?);");
            myPrepStmt.setInt(1, bookingNo);
            myPrepStmt.setInt(2, idPassenger);
            myPrepStmt.setInt(3, flightSeatNo);
            myPrepStmt.setInt(4, idFlight);

            myPrepStmt.executeUpdate();
            
            return true;
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public float getPrice(int ticketNo) {
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ticket,flightseat,booking,customeraccount,passenger WHERE ticketNo=" + ticketNo + " AND "
                    + "ticket.flight_idFlight=flightseat.flight_idFlight AND flightSeat_seatNo=seatNo;");

            if (myRs.first()) {
                return myRs.getBigDecimal("seatPrice").floatValue();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 0;
        
    }

    
    public Ticket getTicket(int ticketNo) {
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where ticketNo=" +ticketNo +";");

            if(myRs.first()) {
                
                Ticket ticket = new Ticket(ticketNo, new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight")));
                
                return ticket;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;        
        
    }

}
