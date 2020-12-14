package DataAcessObject;
import java.util.ArrayList;
import model.*;

public interface TicketDAO {

    public ArrayList<Ticket> findByBookingNo(int booking_bookingNo);

    public void inserImg(int ticketNo);

    public void getImg(int ticketNo);

    public Ticket getTicket(int ticketNo);

    public ArrayList<Ticket> findByIdPassenger(int passenger_idPassenger);

    public boolean add(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight);

    public Airport getDepartureAirport(int ticketNo);

    public Airport getArrivalAirport(int ticketNo);

    public void delete(int ticketNo);
    
}
