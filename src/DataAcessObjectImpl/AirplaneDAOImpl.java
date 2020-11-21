package DataAcessObjectImpl;

import DataAcessObject.AirplaneDAO;
import DataAcessObject.DatabaseConnection;
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
                String model = myRs.getString("model");
                int seatCapacity = myRs.getInt("seatCapacity");

                airplane = new Airplane(idAirplane, model, seatCapacity);

            }
        } catch (SQLException e) {

        }
        return airplane;
    }

}
