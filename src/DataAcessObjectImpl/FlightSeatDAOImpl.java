package DataAcessObjectImpl;

import DataAcessObject.DatabaseConnection;
import DataAcessObject.FlightSeatDAO;
import model.FlightSeat;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Unknow
 */
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

}
