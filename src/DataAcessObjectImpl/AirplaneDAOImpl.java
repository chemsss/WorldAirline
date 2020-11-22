
package DataAcessObjectImpl;

import DataAcessObject.AirplaneDAO;
import java.sql.*;
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

        }
        return airplane;
    }

}
