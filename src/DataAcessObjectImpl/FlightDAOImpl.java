package DataAcessObjectImpl;

import DataAcessObject.FlightDAO;
import model.Flight;
import java.sql.*;
import java.util.ArrayList;


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

    @Override
    public Flight findAllFlights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param DepartureAirportId
     * @param arrivalAirportId
     * @param departureDate
     * @param nbOfSeats
     * @param className
     * @return
     */
    @Override
    public ArrayList<Flight> searchFlights(String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className) {
        
        ArrayList<Flight> flights = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM flight WHERE departureAirport_idAirport='"+DepartureAirportId +"' AND arrivalAirport_idAirport='"+arrivalAirportId +"';");
            
            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            while (myRs.next()) {
                ResultSet myRs2 = myStmt2.executeQuery("SELECT COUNT(*) FROM flightseat WHERE flight_idFlight=" +myRs.getInt("idFlight") +" AND className='" +className +"' AND isAvailable=1;" );
                if(myRs2.first()) {
                    if(myRs2.getInt("COUNT(*)") >= nbOfSeats) {
                        
                        if(myRs.getTimestamp("departureDate").compareTo(departureDate) > 0) {
                            flights.add(new Flight(myRs.getInt("idFlight"), myRs.getString("airlineName"), 
                                myRs.getTimestamp("departureDate"), 
                                myRs.getTimestamp("arrivalDate"), 
                                new AirplaneDAOImpl().find(myRs.getInt("airplane_idAirplane")), 
                                new AirportDAOImpl().find(myRs.getString("departureAirport_idAirport")), 
                                new AirportDAOImpl().find(myRs.getString("arrivalAirport_idAirport")), 
                                new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("idFlight"))));
                        }
                    }
                }
                
                
                
            }
            return flights;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return flights;
        }
    }
}
