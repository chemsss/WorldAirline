package DataAcessObjectImpl;
import DataAcessObject.BookingDAO;
import model.Booking;
import java.sql.*;
import java.util.ArrayList;


public class BookingDAOImpl implements BookingDAO {

    @Override
    public Booking find(int bookingNo) {

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
   
    @Override
    public ArrayList<Booking> findByIdCustomerAccount(int idCustomerAccount) {
        
        ArrayList<Booking> bookings = new ArrayList();
        
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from booking where customerAccount_idaccount=" + idCustomerAccount + ";");
                        
            while(myRs.next()) {
                
                bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(bookings);
        return bookings;
    }
    
    @Override
    public boolean add(Date bookingDate, int idAccount, int idCoupon) {

        try {
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO booking (bookingDate, customerAccount_idaccount, coupon_idcoupon) VALUES (?, ?, ?);");
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
   
    @Override
    public boolean update(int bookingNo, Date bookingDate, int idAccount, int idCoupon, int newBookingNo) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement(/*"SELECT * FROM customeraccount WHERE idCustomerAccount=" +account.getIdAccount() +"; "
                                                                                            + */"UPDATE booking " +
                                                                                            "SET bookingNo=?, " +
                                                                                            "bookingDate=?, " +
                                                                                            "customerAccount_idaccount=?," +
                                                                                            "coupon_idcoupon=? " +
                                                                                            "WHERE booking.bookingNo=?");
            if(newBookingNo!=0) {
                myStmt.setInt(1, newBookingNo);
            }
            else {
                myStmt.setInt(1, bookingNo);
            }
            myStmt.setDate(2, bookingDate);
            if(idAccount==0) {
                myStmt.setNull(3, 0);
            }
            else {
                myStmt.setInt(3, idAccount);
            }
            if(idCoupon==0) {
                myStmt.setNull(4, 0);
            }
            else {
                myStmt.setInt(4, idCoupon);
            }
            myStmt.setInt(5, bookingNo);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }
   
    @Override
    public boolean delete(int bookingNo) {

        Booking booking = null;

        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM booking WHERE bookingNo=" + bookingNo + ";");
            myStmt.executeUpdate();

            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
            
        }

        
    }

}
