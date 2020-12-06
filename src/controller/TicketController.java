/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.TicketDAOImpl;
import model.Airport;
import model.Ticket;

/**
 *
 * @author Unknow
 */
public class TicketController {

    public static Ticket getTicket(int ticketNo) {

        return new TicketDAOImpl().getTicket(ticketNo);
    }

    /*
    public static Airport getDepartureAirport(int ticketNo) {

        return new TicketDAOImpl().getDepartureAirport(ticketNo);
    }

    public static Airport getArrivalAirport(int ticketNo) {

        return new TicketDAOImpl().getArrivalAirport(ticketNo);
    }
    
    public static void getImage(int ticketNo )
    {
        new TicketDAOImpl().getImg(ticketNo);
    }
        
*/
        

}