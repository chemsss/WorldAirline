
package DataAcessObjectImpl;

import DataAcessObject.AirplaneDAO;
import java.sql.*;
import java.util.ArrayList;
import model.Airplane;

/**
 *
 * @author Chems
 */
public class AirplaneDAOImpl implements AirplaneDAO {

    @Override
    public Airplane find(int idAirplane) {

        Airplane airplane = null; // in case of airplane doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from airplane where idAirplane=" + idAirplane + ";");

            if (myRs.first()) {

                airplane = new Airplane(idAirplane, myRs.getString("model"), myRs.getInt("seatCapacity"));

            }
        } catch (SQLException e) {
            System.out.println("e.getMessage()");
        }
        return airplane;
    }
    
    
    @Override
    public boolean create(Airplane airplane) {
        
        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO airplane (`model`, `seatCapacity`) VALUES (?, ?);");
            myStmt.setString(1, airplane.getModel());
            myStmt.setInt(2, airplane.getSeatCapacity());
            myStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    
    
@Override
    public Airplane[] findAllAirplanes() {

        ArrayList<Airplane> airplanes = new ArrayList<>();

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM airplane;");

            while(myRs.next()) {
                airplanes.add(new Airplane(myRs.getInt("idAirplane"), myRs.getString("model"), myRs.getInt("seatCapacity")));
            }

            Airplane[] airplanesFound = new Airplane[airplanes.size()];
            for(int i = 0 ; i < airplanes.size() ; ++i) {
              airplanesFound[i] = airplanes.get(i);
            }
            return airplanesFound;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
