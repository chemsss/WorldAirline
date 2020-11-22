package worldairline;
import DataAcessObject.*;
import DataAcessObjectImpl.*;
import java.util.ArrayList;
import model.*;


public class WorldAirline {


    public static void main(String[] args) {
        
         
        FlightDAOImpl  flightDaoImpl = new FlightDAOImpl();
        Flight flight =flightDaoImpl.find(3);
        System.out.println(new FlightDAOImpl().find(3).toString());
        
        System.out.println(new BookingDAOImpl().find(3).toString());
        
        ArrayList<Booking> bookings = new BookingDAOImpl().findByIdCustomerAccount(3);
        for(int i = 0 ; i < bookings.size() ; ++i) {
            System.out.println(bookings.get(i).toString());
        }
        
        System.out.println(new CustomerAccountDAOImpl().find(3).toString());
        
        System.out.println(new EmployeeAccountDAOImpl().find(1).toString());
        
    }
    
}
