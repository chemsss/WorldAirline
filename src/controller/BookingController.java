package controller;

import DataAcessObjectImpl.BookingDAOImpl;
import java.util.ArrayList;
import model.Booking;


public class BookingController {
  
    public static ArrayList<Booking> getBookings(int idCustomerAccount)
    { 
        return new BookingDAOImpl().findByIdCustomerAccount(idCustomerAccount);
        
    }
    
        public static Booking getBooking(int bookingNo)
    { 
        return new BookingDAOImpl().find(bookingNo);
        
    }
}
