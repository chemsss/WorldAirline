package DataAcessObject;

import java.sql.Date;
import java.util.ArrayList;
import model.*;

public interface BookingDAO {

    public Booking find(int bookingNo);

    public ArrayList<Booking> findByIdCustomerAccount(int idCustomerAccount);

    public boolean add(Date bookingDate, int idAccount, int idCoupon);

    public boolean update(int bookingNo, Date bookingDate, int idAccount, int idCoupon, int newBookingNo);

    public boolean delete(int bookingNo);
   
    public ArrayList<Booking> findAllBookings();
    
    boolean add(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers, ArrayList<Ticket> returnTickets);
    
    boolean add(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers);
    
    boolean add(Date bookingDate, int idAccount);


}
