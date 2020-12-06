/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObject.TicketDAO;
import DataAcessObjectImpl.BookingDAOImpl;
import DataAcessObjectImpl.CouponDAOImpl;
import DataAcessObjectImpl.TicketDAOImpl;
import javax.swing.JLabel;
import model.Coupon;
import model.CustomerAccount;
import model.Ticket;

import java.util.ArrayList;
import model.Booking;

/**
 *
 * @author Chems
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
        
    public static float getTicketPrice(int idFlight, int seatNo) {
        
        return new TicketDAOImpl().getPrice(new TicketDAOImpl().findByFlightSeat( idFlight, seatNo).getTicketNo());
        
    }
    
    public static Coupon getCoupon(String code) {
        
        return new CouponDAOImpl().findByCode(code);
                
    }
    
}
    
    
