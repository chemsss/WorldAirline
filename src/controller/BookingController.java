/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.BookingDAOImpl;
import java.util.ArrayList;
import model.Booking;

/**
 *
 * @author Unknow
 */
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
