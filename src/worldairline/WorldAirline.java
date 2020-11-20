/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldairline;
import java.sql.*;

/**
 *
 * @author Unknow
 */
public class WorldAirline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("worldAirline");  
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/worldairline?useSSL=false", "root", "root");  // /?user=root  //jdbc:mysql://127.0.0.1:3306/?useSSL=false
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM worldairline.passenger WHERE idPassenger=1;");
            rs.next();
            System.out.println(rs.getString("email"));
            
            
            con.close();
            
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("worldAirline");  
        
        
    }
    
}
