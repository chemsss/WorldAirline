/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import java.sql.*;
import model.Airplane;
import model.Flight;

/**
 *
 * @author Chems
 */
public class AirplaneDAO extends DAO<Airplane> {

    @Override
    public Airplane find(int id) {
       
        Airplane airplane=null; // in case of airplane doesn't exist
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from airplane where idAirplane=" + id + ";");

            if (myRs.first()) {
                int idAirplane = myRs.getInt("idAirplane");
                String model = myRs.getString("model");
                int seatCapacity = myRs.getInt("seatCapacity");

                airplane= new Airplane(idAirplane, model, seatCapacity);

            }
        } catch (SQLException e) {

        }
       return airplane;
    }

    @Override
    public Airplane create(Airplane obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Airplane update(Airplane obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Airplane obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
