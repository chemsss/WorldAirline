package DataAcessObjectImpl;
import DataAcessObject.BookingDAO;
import model.Booking;
import java.sql.*;
import java.util.ArrayList;
import model.Passenger;
import model.Ticket;

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
                else {
                    bookings.add(new Booking(myRs.getInt("bookingNo"), myRs.getDate("bookingDate"), new TicketDAOImpl().findByBookingNo(myRs.getInt("bookingNo"))));
                }
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
    
    public boolean add(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers) {
                
        try {
            
            String idAccountString;
            String idCouponString;
            
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `booking` (`bookingDate`, `customerAccount_idaccount`, `coupon_idcoupon`) VALUES (?, ?, ?);");
            myPrepStmt.setDate(1, booking.getBookingDate());
            if(idAccount==0) {
                myPrepStmt.setNull(2, Types.INTEGER);
                idAccountString = " is NULL";
            }
            else {
                myPrepStmt.setInt(2, idAccount);
                idAccountString= "="+String.valueOf(idAccount);
            }
            if(idCoupon==0) {
                myPrepStmt.setNull(3, Types.INTEGER);
                idCouponString = " is NULL";
            } else {
                myPrepStmt.setInt(3, idCoupon);
                idCouponString = "="+String.valueOf(idCoupon);
            }
            myPrepStmt.executeUpdate();
            
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM booking WHERE bookingDate='" +booking.getBookingDateYearToString() 
                                                +"-" +booking.getBookingDateMonthToString() +"-"
                                                +booking.getBookingDateDayToString() +"' AND customerAccount_idaccount" +idAccountString +" AND coupon_idcoupon"  +idCouponString +";");
            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            while(myRs.next())
            {
                ResultSet myRs2 = myStmt2.executeQuery("SELECT * FROM ticket WHERE booking_bookingNo=" +myRs.getInt("bookingNo") +";");
                if(!myRs2.first()) {
                    for(int i = 0 ; i < booking.getTickets().size() ; ++i) {
                        if(new TicketDAOImpl().add(myRs.getInt("bookingNo"), passengers.get(i), booking.getTickets().get(i).getSeat().getSeatNo(),  booking.getTickets().get(i).getFlight().getIdFlight())==false) {
                            System.out.println("Couldn't add a ticket to the booking, add booking aborted.");
                            return false;
                        }
                    }
                    return true;
                }
            }
                                                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Add booking returned false (reached and of method).");
        return false;
        
    }
    
    public boolean add(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers, ArrayList<Ticket> returnTickets) {
                
        try {
            
            String idAccountString;
            String idCouponString;
            
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `booking` (`bookingDate`, `customerAccount_idaccount`, `coupon_idcoupon`) VALUES (?, ?, ?);");
            myPrepStmt.setDate(1, booking.getBookingDate());
            if(idAccount==0) {
                myPrepStmt.setNull(2, Types.INTEGER);
                idAccountString = " is NULL";
            }
            else {
                myPrepStmt.setInt(2, idAccount);
                idAccountString= "="+String.valueOf(idAccount);
            }
            if(idCoupon==0) {
                myPrepStmt.setNull(3, Types.INTEGER);
                idCouponString = " is NULL";
            } else {
                myPrepStmt.setInt(3, idCoupon);
                idCouponString = "="+String.valueOf(idCoupon);
            }
            myPrepStmt.executeUpdate();
            
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM booking WHERE bookingDate='" +booking.getBookingDateYearToString() 
                                                +"-" +booking.getBookingDateMonthToString() +"-"
                                                +booking.getBookingDateDayToString() +"' AND customerAccount_idaccount" +idAccountString +" AND coupon_idcoupon"  +idCouponString +";");
            Statement myStmt2 = DatabaseConnection.getInstance().createStatement();
            while(myRs.next())
            {
                ResultSet myRs2 = myStmt2.executeQuery("SELECT * FROM ticket WHERE booking_bookingNo=" +myRs.getInt("bookingNo") +";");
                if(!myRs2.first()) {
                    for(int i = 0 ; i < booking.getTickets().size() ; ++i) {
                        if(new TicketDAOImpl().add(myRs.getInt("bookingNo"), passengers.get(i), booking.getTickets().get(i).getSeat().getSeatNo(),  booking.getTickets().get(i).getFlight().getIdFlight())==false) {
                            System.out.println("Couldn't add a ticket to the booking, add booking aborted.");
                            return false;
                        }
                        else {
                            new TicketDAOImpl().add(myRs.getInt("bookingNo"), passengers.get(i), returnTickets.get(i).getSeat().getSeatNo(),  returnTickets.get(i).getFlight().getIdFlight());
                        }
                    }
                    return true;
                }
            }
                                                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Add booking returned false (reached end of add method).");
        return false;
        
    }
    
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
                myStmt.setNull(3, Types.INTEGER);
            }
            else {
                myStmt.setInt(3, idAccount);
            }
            if(idCoupon==0) {
                myStmt.setNull(4, Types.INTEGER);
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
    
    
    public void delete(int bookingNo) {
        
        Booking booking = null;

        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM booking WHERE bookingNo=" + bookingNo + ";");
            myStmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
    }
    
    

}
