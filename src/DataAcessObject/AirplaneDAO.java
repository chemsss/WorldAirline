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
        
        /*try {
            Connection con = DriverManager.getConnection( getUrl(), getUser(), getPassword());  // /?user=root  //jdbc:mysql://127.0.0.1:3306/?useSSL=false
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM worldairline.passenger WHERE registrationNumber=" +id +";");
            
            for(int i=1 ; rs.next() ; ++i) {
                rs.next();
                System.out.println(rs.getString(i));
            }
            
            
            
            con.close();
            
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        
        
        
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
