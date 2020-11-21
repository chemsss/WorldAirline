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

          ArrayList<Ticket> tickets;
          
          
                
      //booking = new Booking(bookingNo,myRs.getDate("bookingDate"), ArrayList<Ticket> tickets, CustomerAccount customerAccount) {

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return booking;
    }

}
