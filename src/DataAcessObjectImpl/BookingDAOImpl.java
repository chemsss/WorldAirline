package DataAcessObjectImpl;
import DataAcessObject.BookingDAO;
import model.Booking;
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

            if (myRs.first() ) {
                if(myRs.getInt("coupon_idcoupon")==0) {
                    booking = new Booking(bookingNo, myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(bookingNo));
                }
                else {
                    booking = new Booking(bookingNo, myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(bookingNo), new CouponDAOImpl().find(myRs.getInt("coupon_idcoupon")));
                }
                
            }
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return booking;
    }
    
    
    public ArrayList<Booking> findByIdCustomerAccount(int idCustomerAccount) {
        
        ArrayList<Booking> bookings = new ArrayList<>();
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from booking where customerAccount_idaccount=" + idCustomerAccount + ";");
                        
            while(myRs.next()) {
                if(myRs.getInt("coupon_idcoupon")==0) {
                    bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo")), new CouponDAOImpl().find(myRs.getInt("coupon_idcoupon"))));
                }
                bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return bookings;
    }
    

    public boolean add(Date bookingDate, int idAccount) {
                
        try {
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `booking` (`bookingDate`, `customerAccount_idaccount`, `coupon_idcoupon`) VALUES (?, ?, NULL);");
            myPrepStmt.setDate(1, bookingDate);
            myPrepStmt.setInt(2, idAccount);
            
            myPrepStmt.executeUpdate();
            
            return true;
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public boolean add(Date bookingDate, int idAccount, int idCoupon) {
                
        try {
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `booking` (`bookingDate`, `customerAccount_idaccount`, `coupon_idcoupon`) VALUES (?, ?, ?);");
            myPrepStmt.setDate(1, bookingDate);
            myPrepStmt.setInt(2, idAccount);
            if(idCoupon==0) {
                myPrepStmt.setNull(3, Types.INTEGER);
            } else {
                myPrepStmt.setInt(3, idCoupon);
            }
            
            
            myPrepStmt.executeUpdate();
            
            return true;
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    

}
