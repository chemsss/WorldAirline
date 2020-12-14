package DataAcessObject;

import model.Passenger;

public interface PassengerDAO {

    Passenger find(int idPassenger);

    Passenger findByTicketNo(int ticketNo);

    int add(Passenger passenger);
    
}
