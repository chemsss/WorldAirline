/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Passenger;

/**
 *
 * @author Chems
 */
public class PassengerDAOImpl {
    
    public Passenger find(int idPassenger) {

        Passenger passenger = null; // in case of airport doesn't exist

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from passenger where idPassenger=" + idPassenger + ";");

            if (myRs.first()) {
                passenger = new Passenger(idPassenger, myRs.getString("email"), myRs.getString("firstName"), 
                        myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"), 
                        myRs.getString("nationality"), myRs.getString("passportNo"), new TicketDAOImpl().findByIdPassenger(idPassenger));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return passenger;
    }
    
    public Passenger findByTicketNo(int ticketNo) {

        Passenger passenger = null; // in case of airport doesn't exist

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select idPassenger, email, firstName, lastName, address, birthDate, telephoneNumber, nationality, passportNo \n" +
                                                 "from ticket,passenger where ticketNo=" +ticketNo +" AND idPassenger=passenger_idPassenger;");

            if (myRs.first()) {
                passenger = new Passenger(myRs.getInt("idPassenger"), myRs.getString("email"), myRs.getString("firstName"), 
                        myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"), 
                        myRs.getString("nationality"), myRs.getString("passportNo"), new TicketDAOImpl().findByIdPassenger(myRs.getInt("idPassenger")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return passenger;
    }
    
    
    public int add(Passenger passenger) {
        
        try {
            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt2.executeQuery("SELECT * FROM passenger WHERE email='"+passenger.getEmail()+"' AND firstName='"+passenger.getFirstName() +"' AND lastName='"
                                                 +passenger.getLastName() +"' AND address='"+passenger.getAddress() +"' AND birthDate='"
                                                 +passenger.getBirthDayYearToString() +"-"+passenger.getBirthDateMonthToString()+"-"+passenger.getBirthDateDayToString()
                                                 +"' AND telephoneNumber='" +passenger.getTelephoneNumber() +"' AND passportNo='" +passenger.getPassportNo() +"';");
            
            if(myRs.first()) {
                return myRs.getInt("idPassenger");
            }
            else {
                PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO passenger (`email`, `firstName`, `lastName`, `address`, `birthDate`, `telephoneNumber`, `nationality`, `passportNo`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
                myStmt.setString(1, passenger.getEmail());
                myStmt.setString(2, passenger.getFirstName());
                myStmt.setString(3, passenger.getLastName());
                myStmt.setString(4, passenger.getAddress());
                myStmt.setDate(5, passenger.getBirthDate());
                myStmt.setString(6, passenger.getTelephoneNumber());
                myStmt.setString(7, passenger.getNationality());
                myStmt.setString(8, passenger.getPassportNo());
                
                myStmt.executeUpdate();
                
                
                ResultSet myRs2 = myStmt2.executeQuery("SELECT * FROM passenger WHERE email='"+passenger.getEmail()+"' AND firstName='"+passenger.getFirstName() +"' AND lastName='"
                                                 +passenger.getLastName() +"' AND address='"+passenger.getAddress() +"' AND birthDate='"
                                                 +passenger.getBirthDayYearToString() +"-"+passenger.getBirthDateMonthToString()+"-"+passenger.getBirthDateDayToString()
                                                 +"' AND telephoneNumber='" +passenger.getTelephoneNumber() +"' AND passportNo='" +passenger.getPassportNo() +"';");
                if(myRs2.first())
                {
                    return myRs2.getInt("idPassenger");
                }
                else {
                    System.out.println("Couldn't find just created passenger " +passenger.getFirstName() +" " +passenger.getLastName());
                    return 0;
                }
                                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        
    }
    
}
