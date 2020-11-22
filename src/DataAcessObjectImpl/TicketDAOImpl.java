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

        ArrayList<Ticket> tickets = null;
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where booking_bookingNo=" + booking_bookingNo + ";");

            boolean ticketInit = false;

            while (myRs.next()) {

                if (ticketInit == false) { //seats exists
                    tickets = new ArrayList<>();
                    ticketInit = true;
                }
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

}
