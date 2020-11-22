/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;
import DataAcessObject.EmployeeAccountDAO;
import java.sql.*;
import model.EmployeeAccount;

/**
 *
 * @author Chems
 */
public class EmployeeAccountDAOImpl implements EmployeeAccountDAO {
    
    public EmployeeAccount find(int idEmployeeAccount) {
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from employeeaccount where idEmployeeAccount=" + idEmployeeAccount + ";");
            
            if(myRs.first()) {
                //(String ageCategory, ArrayList<Booking> bookings, int idAccount, String email, String password, String firstName, String lastName, Date birthDate, String telephoneNumber)
                //super(idAccount, email, password, firstName, lastName, birthDate, telephoneNumber);
                return new EmployeeAccount(idEmployeeAccount, myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
                //bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
    
}
