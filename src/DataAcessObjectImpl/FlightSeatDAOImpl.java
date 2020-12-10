package DataAcessObjectImpl;

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

        ArrayList<FlightSeat> flightSeats = new ArrayList<>(); // in case of flightSeat doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flightseat where flight_idFlight=" + flight_idFlight);

            while (myRs.next()) {
                
                flightSeats.add(new FlightSeat(myRs.getInt("seatNo"), myRs.getString("className"), myRs.getBigDecimal("seatPrice"), myRs.getBoolean("isAvailable")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return flightSeats;
    }
    
    public FlightSeat[] getAvailableSeats(int flight_idflight, String className) {
        
        ArrayList<FlightSeat> flightSeats = new ArrayList<>(); // in case of flightSeat doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from flightseat where flight_idFlight=" + flight_idflight +" AND className='" +className +"' AND isAvailable=1;");

            while (myRs.next()) {
                
                flightSeats.add(new FlightSeat(myRs.getInt("seatNo"), myRs.getString("className"), myRs.getBigDecimal("seatPrice"), myRs.getBoolean("isAvailable")));

            }
            FlightSeat[] flightSeatsFound = new FlightSeat[flightSeats.size()];
            for(int i = 0 ; i < flightSeats.size() ; ++i) {
                flightSeatsFound[i] = flightSeats.get(i);
            }  
            return flightSeatsFound;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }        
        return (FlightSeat[]) flightSeats.toArray();
    }

    
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
    
    
    public float getPrice(int idFlight, int seatNo) {
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM flightseat WHERE flight_idFlight=" +idFlight +" AND seatNo=" +seatNo +";");  

            if (myRs.first()) {
                return myRs.getBigDecimal("seatPrice").floatValue();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 0;
        
    }
    
}
