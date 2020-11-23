/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

import DataAcessObject.AirportDAO;
import java.sql.*;
import model.Airport;

/**
 *
 * @author Unknow
 */
public class AirportDAOImpl implements AirportDAO {

    public Airport find(String idAirport) {

        Airport airport = null; // in case of airport doesn't exist

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from airport where idAirport='" + idAirport + "';");

            if (myRs.first()) {
                airport = new Airport(idAirport, myRs.getString("name"), myRs.getString("city"), myRs.getString("country"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return airport;
    }
    
    @Override
    public boolean create(Airport airport) {
        
        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO airport (`idAirport`, `name`, `city`, `country`) VALUES (?, ?, ?, ?);");
            myStmt.setString(1, airport.getIdAirport());
            myStmt.setString(2, airport.getNameAirport());
            myStmt.setString(3, airport.getCity());
            myStmt.setString(4, airport.getCountry());
            myStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
}
