/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObject.TicketDAO;
import DataAcessObjectImpl.BookingDAOImpl;
import DataAcessObjectImpl.CouponDAOImpl;
import DataAcessObjectImpl.FlightSeatDAOImpl;
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

    public static ArrayList<Booking> getBookings(int idCustomerAccount) {
        return new BookingDAOImpl().findByIdCustomerAccount(idCustomerAccount);

    }

    public static Booking getBooking(int bookingNo) {
        
        return new BookingDAOImpl().find(bookingNo);

    }

    public static float getTicketPriceLoggedCustomer(int idFlight, int seatNo) {

        return new TicketDAOImpl().getPriceLoggedCustomer(idFlight, seatNo);

    }

    public static float getTicketPriceUnloggedCustomer(int idFlight, int seatNo) {
        return new FlightSeatDAOImpl().getPrice(idFlight, seatNo);
    }

    public static Coupon getCoupon(String code) {

        return new CouponDAOImpl().findByCode(code);

    }
    
    public static float getBookingPrice(ArrayList<Ticket> departTickets, ArrayList<Ticket> returnTickets, CustomerAccount customer) {
        
        if(customer==null) {
            float price = 0;
            for(int i = 0 ; i < departTickets.size() ; ++i) {
                price += TicketController.getTicketPriceNotLogged(departTickets.get(i).getFlight().getIdFlight(), departTickets.get(i).getSeat().getSeatNo());
            }
            return price;
        }
        
        else {
            float price = TicketController.getTicketPriceLogged(departTickets.get(0).getFlight().getIdFlight(), departTickets.get(0).getSeat().getSeatNo(), customer);
            price += TicketController.getTicketPriceLogged(returnTickets.get(0).getFlight().getIdFlight(), returnTickets.get(0).getSeat().getSeatNo(), customer);
            for(int i = 1 ; i < departTickets.size() ; ++i) {
                price += TicketController.getTicketPriceNotLogged(departTickets.get(i).getFlight().getIdFlight(), departTickets.get(i).getSeat().getSeatNo());
                price += TicketController.getTicketPriceNotLogged(returnTickets.get(i).getFlight().getIdFlight(), returnTickets.get(i).getSeat().getSeatNo());
            }
            return price;
        }
        
    }
    
    public static boolean checkCode(String code) {
        
            return  new CouponDAOImpl().checkCode(code);
    }
    
    public static float getCodeDiscount(String code) {
        return new CouponDAOImpl().findByCode(code).getDiscount();
    }
    
    public static int getCouponId(String code) {
        return new CouponDAOImpl().findByCode(code).getIdCoupon();
    }
    
    public static float getBookingPrice(ArrayList<Ticket> departTickets, CustomerAccount customer) {
        
        if(customer==null) {
            float price = 0;
            for(int i = 0 ; i < departTickets.size() ; ++i) {
                price += TicketController.getTicketPriceNotLogged(departTickets.get(i).getFlight().getIdFlight(), departTickets.get(i).getSeat().getSeatNo());
            }
            return price;
        }
        
        else {
            float price = TicketController.getTicketPriceLogged(departTickets.get(0).getFlight().getIdFlight(), departTickets.get(0).getSeat().getSeatNo(), customer);
            for(int i = 1 ; i < departTickets.size() ; ++i) {
                price += TicketController.getTicketPriceNotLogged(departTickets.get(i).getFlight().getIdFlight(), departTickets.get(i).getSeat().getSeatNo());
            }
            return price;
        }
        
    }

}
