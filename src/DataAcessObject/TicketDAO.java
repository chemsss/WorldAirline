package DataAcessObject;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Unknow
 */
public interface TicketDAO {
    
    public ArrayList<Ticket> findByBookingNo (int booking_bookingNo);
    public void inserImg(int ticketNo);
    public void getImg(int ticketNo);
    public Ticket getTicket(int ticketNo);
}
