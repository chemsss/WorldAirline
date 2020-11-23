package DataAcessObjectImpl;

import DataAcessObject.FlightDAO;
import model.Flight;
import java.sql.*;


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
                //int airplane_idAirplane = myRs.getInt("airplane_idAirplane");
                //AirplaneDAOImpl airplaneDAO = new AirplaneDAOImpl();
                //String airlineName = myRs.getString("airlineName");

                //String departureAirport_idAiport = myRs.getString("departureAirport_idAirport");
                //String arrivalAirport_idAiport = myRs.getString("arrivalAirport_idAirport");

                //AirportDAOImpl departureAirportDAO = new AirportDAOImpl();
                //AirportDAOImpl arrivalAirportDAO = new AirportDAOImpl();

                // Timestamp departureDate = myRs.getTimestamp("departureDate");
                //Timestamp arrivalDate = myRs.getTimestamp("arrivalDate");
                //FlightSeatDAOImpl flightSeatDAO = new FlightSeatDAOImpl();

                flight = new Flight(id, myRs.getString("airlineName"), 
                        myRs.getTimestamp("departureDate"), 
                        myRs.getTimestamp("arrivalDate"), 
                        new AirplaneDAOImpl().find(myRs.getInt("airplane_idAirplane")), 
                        new AirportDAOImpl().find(myRs.getString("departureAirport_idAirport")), 
                        new AirportDAOImpl().find(myRs.getString("arrivalAirport_idAirport")), 
                        new FlightSeatDAOImpl().findByIdFlight(id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flight;
    }
    
    
    //Coder une méthode find qui renvoie une arrayList de vols selon la date saisie
}
