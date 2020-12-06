/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

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
            ResultSet myRs = myStmt.executeQuery("select idPassenger, email, firstName, lastName, address, birthDate, telephoneNumber, nationality, passportNo \n"
                    + "from ticket,passenger where ticketNo=" + ticketNo + " AND idPassenger=passenger_idPassenger;");

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
}
