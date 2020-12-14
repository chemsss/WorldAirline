package DataAcessObject;

import model.Passenger;

public interface PassengerDAO {

    public Passenger find(int idPassenger);

    public Passenger findByTicketNo(int ticketNo);

    public int add(Passenger passenger);
}
