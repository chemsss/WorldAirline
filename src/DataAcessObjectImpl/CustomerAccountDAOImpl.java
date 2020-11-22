/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;
import DataAcessObject.CustomerAccountDAO;
import java.sql.*;
import model.Booking;
import model.CustomerAccount;

/**
 *
 * @author Chems
 */
public class CustomerAccountDAOImpl {
    
    public CustomerAccount find(int idCustomerAccount) {
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from customeraccount where idCustomerAccount=" + idCustomerAccount + ";");
            
            if(myRs.first()) {
                //(String ageCategory, ArrayList<Booking> bookings, int idAccount, String email, String password, String firstName, String lastName, Date birthDate, String telephoneNumber)
                //super(idAccount, email, password, firstName, lastName, birthDate, telephoneNumber);
                return new CustomerAccount(myRs.getString("ageCategory"), new BookingDAOImpl().findByIdCustomerAccount(idCustomerAccount), idCustomerAccount, myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
                //bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
}
