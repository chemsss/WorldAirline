package DataAcessObjectImpl;

import DataAcessObject.FlightSeatDAO;
import java.math.BigDecimal;
import model.FlightSeat;
import java.sql.*;
import java.util.ArrayList;

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
    
    @Override
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
    
    
    public boolean addIntoFlight(int seatNo, int idFlight, String className, BigDecimal seatPrice) {
        
        try {
            
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO flightseat "
                    + "(`seatNo`, `flight_idFlight`, `className`, `seatPrice`, `isAvailable`) "
                    + "VALUES (?, ?, ?, ?, ?);");
            
            
            myStmt.setInt(1, seatNo);
            myStmt.setInt(2, idFlight);
            myStmt.setString(3, className);
            myStmt.setBigDecimal(4, seatPrice );
            myStmt.setInt(5, 1);         

            myStmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean add(int seatNumber, int idFlight, String className, BigDecimal seatPrice, boolean isAvailable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(FlightSeat seat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
