package DataAcessObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import model.FlightSeat;

public interface FlightSeatDAO {

    public ArrayList<FlightSeat> findByIdFlight(int flight_idFlight);

    public boolean add(int seatNumber, int idFlight, String className, BigDecimal seatPrice, boolean isAvailable);

    public boolean delete(FlightSeat seat);

    public FlightSeat[] getAvailableSeats(int flight_idflight, String className);

    public boolean setSeatTaken(int idFlight, int idFlightSeat);
}
