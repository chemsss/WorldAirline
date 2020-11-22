package DataAcessObjectImpl;
import DataAcessObject.*;
import model.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Unknow
 */
public class BookingDAOImpl implements BookingDAO {

    @Override
    public Booking find(int bookingNo) { //A FINIR

        Booking booking = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from booking where bookingNo=" + bookingNo + ";");

            if (myRs.first()) {
                booking = new Booking(bookingNo, myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(bookingNo));
            }
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return booking;
    }
    
    
    public ArrayList<Booking> findByIdCustomerAccount(int idCustomerAccount) {
        
        ArrayList<Booking> bookings = null;
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from booking where customerAccount_idaccount=" + idCustomerAccount + ";");
            
            boolean init = false;
            
            while(myRs.next()) {
                if(init == false) {
                    bookings = new ArrayList<Booking>();
                    init = true;
                }
                bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return bookings;
    }

}
