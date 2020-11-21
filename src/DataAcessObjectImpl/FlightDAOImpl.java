package DataAcessObjectImpl;

import DataAcessObject.FlightDAO;
import java.sql.*;
import model.Flight;

/**
 *
 * @author Chems
 */
public class FlightDAOImpl implements FlightDAO {
    
  

    @Override
    public Flight find(int id) {

        Flight flight = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flight where idFlight=" + id + ";");

            if (myRs.first()) {

                
                int airplane_idAirplane = myRs.getInt("airplane_idAirplane");
                AirplaneDAOImpl airplaneDAO = new AirplaneDAOImpl();
                String airlineName = myRs.getString("airlineName");

                String departureAirport_idAiport = myRs.getString("departureAirport_idAirport");
                String arrivalAirport_idAiport = myRs.getString("arrivalAirport_idAirport");

                AirportDAOImpl departureAirportDAO = new AirportDAOImpl();
                AirportDAOImpl arrivalAirportDAO = new AirportDAOImpl();

                // Timestamp departureDate = myRs.getTimestamp("departureDate");
                //Timestamp arrivalDate = myRs.getTimestamp("arrivalDate");
                FlightSeatDAOImpl flightSeatDAO = new FlightSeatDAOImpl();

                flight = new Flight(id, airlineName, myRs.getTimestamp("departureDate"), myRs.getTimestamp("arrivalDate"), airplaneDAO.find(airplane_idAirplane), departureAirportDAO.find(departureAirport_idAiport), arrivalAirportDAO.find(arrivalAirport_idAiport), flightSeatDAO.findByIdFlight(id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flight;
    }

}
