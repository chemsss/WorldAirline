package DataAcessObjectImpl;

import DataAcessObject.FlightSeatDAO;
import java.math.BigDecimal;
import model.FlightSeat;
import java.sql.*;
import java.util.ArrayList;

public class FlightSeatDAOImpl implements FlightSeatDAO { //A FINIR

    @Override
    public ArrayList<FlightSeat> findByIdFlight(int flight_idFlight) {

        ArrayList<FlightSeat> flightSeats = null; // in case of flightSeat doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flightseat where flight_idFlight=" + flight_idFlight);
            boolean flightSeatsInit = false;

            while (myRs.next()) {

                if (flightSeatsInit == false) { //seats exists
                    flightSeats = new ArrayList<>();
                    flightSeatsInit = true;
                }
                flightSeats.add(new FlightSeat(myRs.getInt("seatNo"), myRs.getString("className"), myRs.getBigDecimal("seatPrice"), myRs.getBoolean("isAvailable")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return flightSeats;
    }

    @Override
    public boolean add(int seatNumber, int idFlight, String className, BigDecimal seatPrice, boolean isAvailable) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO flightSeat "
                    + "( `seatNo`, `flight_idFlight`, `className`, `seatPrice`, `isAvailable`) "
                    + "VALUES (?, ?, ?, ?, ?);");

            myStmt.setInt(1, seatNumber);
            myStmt.setInt(2, idFlight);
            myStmt.setString(3, className);
            myStmt.setBigDecimal(4, seatPrice);
            myStmt.setBoolean(5, isAvailable);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

   
    @Override
    public boolean delete(FlightSeat seat) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM flightSeat WHERE seatNo=?" + ";");

            myStmt.setInt(1, seat.getSeatNo());

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public FlightSeat[] getAvailableSeats(int flight_idflight, String className) {

        ArrayList<FlightSeat> flightSeats = new ArrayList<>(); // in case of flightSeat doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flightseat where flight_idFlight=" + flight_idflight + " AND className='" + className + "' AND isAvailable=1;");

            while (myRs.next()) {

                flightSeats.add(new FlightSeat(myRs.getInt("seatNo"), myRs.getString("className"), myRs.getBigDecimal("seatPrice"), myRs.getBoolean("isAvailable")));

            }
            FlightSeat[] flightSeatsFound = new FlightSeat[flightSeats.size()];
            for (int i = 0; i < flightSeats.size(); ++i) {
                flightSeatsFound[i] = flightSeats.get(i);
            }
            return flightSeatsFound;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return (FlightSeat[]) flightSeats.toArray();
    }
      
    @Override
    public boolean setSeatTaken(int idFlight, int idFlightSeat) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("UPDATE flightseat SET isAvailable=? WHERE flight_idFlight=? AND seatNo=?");
            myStmt.setInt(1, 0);
            myStmt.setInt(2, idFlight);
            myStmt.setInt(3, idFlightSeat);

            myStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    @Override
    public boolean addIntoFlight(int seatNo, int idFlight, String className, BigDecimal seatPrice) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO flightseat "
                    + "(seatNo, flight_idFlight, className, seatPrice, isAvailable) "
                    + "VALUES (?, ?, ?, ?, ?);");

            String price = String.format("%.2f", seatPrice);

            myStmt.setInt(1, seatNo);
            myStmt.setInt(2, idFlight);
            myStmt.setString(3, className);
            myStmt.setBigDecimal(4, new BigDecimal( price.replace(',', '.') ) );
            myStmt.setInt(5, 1);

            myStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
