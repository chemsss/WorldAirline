/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import model.Airplane;

/**
 *
 * @author Chems
 */

public class AirplaneDAO extends DAO<Airplane> {
    
    private int abbasLoser;
    
    public AirplaneDAO() {
        super();
    }

    @Override
    public void find(int id) {
        
        
        try {
            Connection con = DriverManager.getConnection( getUrl(), getUser(), getPassword());  // /?user=root  //jdbc:mysql://127.0.0.1:3306/?useSSL=false
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM airplane WHERE idAirplane=" + id + ";");
            
            Airplane airplane=null; // in case of airplane doesn't exist
            if(rs.first()) {
                int idAirplane = rs.getInt("idAirplane");
                String model = rs.getString("model");
                int seatCapacity = rs.getInt("seatCapacity");

                airplane= new Airplane(idAirplane, model, seatCapacity);
            }
            
            con.close();
            
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
       /*Airplane airplane=null; // in case of airplane doesn't exist
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
       return airplane;*/
        
        
        
        
    }
    
    /*public Airplane getAirplane(int id) {
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/worldairline?useSSL=false", "root", "root");  // /?user=root  //jdbc:mysql://127.0.0.1:3306/?useSSL=false
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM worldairline.passenger WHERE idAirplane= " +id + ";");
            rs.next();
            System.out.println(rs.getString("email"));
            
            
            con.close();
            
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("worldAirline");
        
        
    }*/
}
