package DataAcessObjectImpl;

import DataAcessObject.FlightDAO;
import model.Flight;
import java.sql.*;
import java.util.ArrayList;

public class FlightDAOImpl implements FlightDAO {

    @Override
    public Flight find(int id) {

        Flight flight = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flight where idFlight=" + id + ";");

            if (myRs.first()) {
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

    @Override
    public Flight findAllFlights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Flight> searchFlights(String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className) {

        ArrayList<Flight> flights = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM flight WHERE departureAirport_idAirport='" + DepartureAirportId + "' AND arrivalAirport_idAirport='" + arrivalAirportId + "';");

            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            while (myRs.next()) {
                ResultSet myRs2 = myStmt2.executeQuery("SELECT COUNT(*) FROM flightseat WHERE flight_idFlight=" + myRs.getInt("idFlight") + " AND className='" + className + "' AND isAvailable=1;");
                if (myRs2.first()) {
                    if (myRs2.getInt("COUNT(*)") >= nbOfSeats) {

                        if (myRs.getTimestamp("departureDate").compareTo(departureDate) > 0) {
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

    @Override
    public boolean update(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement(/*"SELECT * FROM customeraccount WHERE idCustomerAccount=" +account.getIdAccount() +"; "
                                                                                            + */"UPDATE flight "
                    + "SET airplane_idAirplane=?, "
                    + "airlineName=?,"
                    + "departureAirport_idAirport=?, "
                    + "arrivalAirport_idAirport=?, "
                    + "departureDate=?, "
                    + "arrivalDate=? "
                    + "WHERE flight.idFlight=?");

            myStmt.setInt(1, idAirplane);
            myStmt.setString(2, airlineName);
            myStmt.setString(3, idDepartureAirport);
            myStmt.setString(4, idArrivalAirport);
            myStmt.setTimestamp(5, departureDate);
            myStmt.setTimestamp(6, arrivalDate);
            myStmt.setInt(7, idFlight);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean add(int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO flight "
                    + "( `airplane_idAirplane`, `airlineName`, `departureAirport_idAirport`, `arrivalAirport_idAirport`, `departureDate`, `arrivalDate`) "
                    + "VALUES (?, ?, ?, ?, ?, ?);");

            myStmt.setInt(1, idAirplane);
            myStmt.setString(2, airlineName);
            myStmt.setString(3, idDepartureAirport);
            myStmt.setString(4, idArrivalAirport);
            myStmt.setTimestamp(5, departureDate);
            myStmt.setTimestamp(6, arrivalDate);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
    
    @Override
    public boolean delete(int idFlight) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM flight WHERE idFlight=?" + ";");

            myStmt.setInt(1, idFlight);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
