package DataAcessObjectImpl;

import DataAcessObject.FlightDAO;
import java.math.BigDecimal;
import model.Flight;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Chems
 */
public class FlightDAOImpl implements FlightDAO {

    /**
     *
     * @param id
     * @return
     */
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

                return flight;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flight;

    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Flight> findAllFlights() {

        ArrayList<Flight> flights = new ArrayList();

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flight;");

            while (myRs.next()) {
                flights.add(new Flight(myRs.getInt("idFlight"), myRs.getString("airlineName"),
                        myRs.getTimestamp("departureDate"),
                        myRs.getTimestamp("arrivalDate"),
                        new AirplaneDAOImpl().find(myRs.getInt("airplane_idAirplane")),
                        new AirportDAOImpl().find(myRs.getString("departureAirport_idAirport")),
                        new AirportDAOImpl().find(myRs.getString("arrivalAirport_idAirport")),
                        new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("idFlight"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flights;

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

    /**
     *
     * @param idFlight
     * @param idAirplane
     * @param airlineName
     * @param idDepartureAirport
     * @param idArrivalAirport
     * @param departureDate
     * @param arrivalDate
     * @return
     */
    @Override
    public boolean update(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("UPDATE flight "
                    + "SET idFlight=?, "
                    + "airplane_idAirplane=?, "
                    + "airlineName=?,"
                    + "departureAirport_idAirport=?, "
                    + "arrivalAirport_idAirport=?, "
                    + "departureDate=?, "
                    + "arrivalDate=? "
                    + "WHERE flight.idFlight=?");
            myStmt.setInt(1, idFlight);
            myStmt.setInt(2, idAirplane);
            myStmt.setString(3, airlineName);
            myStmt.setString(4, idDepartureAirport);
            myStmt.setString(5, idArrivalAirport);
            myStmt.setTimestamp(6, departureDate);
            myStmt.setTimestamp(7, arrivalDate);
            myStmt.setInt(8, idFlight);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     *
     * @param flight
     * @param nbSeatsFirstClass
     * @param nbSeatsBusinessClass
     * @param nbSeatsEconomyClass
     * @param priceFirst
     * @param priceBusiness
     * @param priceEconomy
     * @return
     */
    @Override
    public boolean add(Flight flight, int nbSeatsFirstClass, int nbSeatsBusinessClass, int nbSeatsEconomyClass, BigDecimal priceFirst, BigDecimal priceBusiness, BigDecimal priceEconomy) {
        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO flight "
                    + "(`airplane_idAirplane`, `airlineName`, `departureAirport_idAirport`, `arrivalAirport_idAirport`, `departureDate`, `arrivalDate`) "
                    + "VALUES (?, ?, ?, ?, ?, ?);");

            myStmt.setInt(1, flight.getAirplane().getIdAirplane());
            myStmt.setString(2, flight.getAirlineName());
            myStmt.setString(3, flight.getDepartureAirport().getIdAirport());
            myStmt.setString(4, flight.getArrivalAirport().getIdAirport());
            myStmt.setString(5, "" + flight.getDepartureDateTimeSQLToString());
            myStmt.setString(6, "" + flight.getArrivalDateTimeSQLToString());

            myStmt.executeUpdate();

            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM flight WHERE "
                    + "airplane_idAirplane =" + flight.getAirplane().getIdAirplane() + " AND airlineName='" + flight.getAirlineName() + "' AND departureAirport_idAirport='"
                    + flight.getDepartureAirport().getIdAirport() + "' AND arrivalAirport_idAirport='" + flight.getArrivalAirport().getIdAirport()
                    + "' AND departureDate='" + flight.getDepartureDateTimeSQLToString() + "'"
                    + " AND arrivalDate='" + flight.getArrivalDateTimeSQLToString() + "' ;");

            if (myRs.first()) {
                for (int i = 0; i < nbSeatsFirstClass; ++i) {
                    if (new FlightSeatDAOImpl().addIntoFlight(i + 1, myRs.getInt("idFlight"), "First Class", priceFirst) == false) {
                        System.out.println("Couldn't create seat in flight " + myRs.getInt("idFlight") + "First Class, nb of seats  " + nbSeatsFirstClass + " Price " + priceFirst);
                    }

                }
                for (int i = nbSeatsFirstClass; i < nbSeatsBusinessClass + nbSeatsFirstClass; ++i) {
                    if (new FlightSeatDAOImpl().addIntoFlight(i + 1, myRs.getInt("idFlight"), "Business Class", priceBusiness) == false) {
                        System.out.println("Couldn't create seat in flight " + myRs.getInt("idFlight") + " Business Class, nb of seats  " + nbSeatsBusinessClass + " Price " + priceBusiness);
                    }
                }
                for (int i = nbSeatsBusinessClass + nbSeatsFirstClass; i < nbSeatsEconomyClass + nbSeatsBusinessClass + nbSeatsFirstClass; ++i) {
                    if (new FlightSeatDAOImpl().addIntoFlight(i + 1, myRs.getInt("idFlight"), "Economy Class", priceEconomy) == false) {
                        System.out.println("Couldn't create seat in flight " + myRs.getInt("idFlight") + " Economy Class, nb of seats  " + nbSeatsEconomyClass + " Price " + priceEconomy);
                    }
                }
            } else {
                System.out.println("Couldn't find the just created flight to create the seats. " + flight.getDepartureDateTimeSQLToString() + " " + flight.getArrivalDateTimeSQLToString());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     *
     * @param month
     * @return
     */
    @Override
    public int getCountMonth(int month) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT COUNT(*) FROM flight WHERE month(departureDate)=" + month + ";");

            if (myRs.first()) {
                return myRs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        System.out.println("Reached end of method getCountflightMonth");
        return 0;
    }

    /**
     *
     * @param idFlight
     * @return
     */
    @Override
    public boolean delete(int idFlight) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM flight WHERE idFlight=?" + ";");

            myStmt.setInt(1, idFlight);

            myStmt.executeUpdate();
            
            PreparedStatement myStmt2 = DatabaseConnection.getInstance().prepareStatement("DELETE FROM flightseat WHERE flight_idFlight=?" + ";");
            myStmt2.setInt(1, idFlight);
            myStmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
