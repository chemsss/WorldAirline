package DataAcessObject;

import java.sql.*;
import model.Flight;
import java.util.*;

/**
 *
 * @author Chems
 */
public class FlightDAO extends DAO<Flight> {

    @Override
    public Flight find(int id) { //A FINIR
       
        Flight flight = null;
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flight where idFlight=" + id + ";");

            if (myRs.first()) {
                int idFlight = myRs.getInt("idFlight");
                int airplane_idAirplane = myRs.getInt("airplane_idAirplane");
                String airlineName = myRs.getString("airlineName");

                //java.util.Date date = new Date();
                Timestamp departureDate = myRs.getTimestamp("departureDate");
                Timestamp arrivalDate = myRs.getTimestamp("arrivalDate");

                String departureAirport = myRs.getString("departureAirport_idAiport");
                String arrivalAirport = myRs.getString("arrivalAirport_idAiport");

                myRs = myStmt.executeQuery("select * from flight where idFlight=" + id + ";");

                //Flight(int idFlight, String airlineName, Timestamp departureDate, Timestamp arrivalDate, Airplane airplane, Airport departureAirport, Airport arrivalAirport, int numberOfFlightSeats)            
            }
        } catch (SQLException e) {

        }

        return flight;
    }

    @Override
    public Flight create(Flight obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flight update(Flight obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Flight obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
