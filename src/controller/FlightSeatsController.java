/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.FlightDAOImpl;
import java.util.ArrayList;
import model.FlightSeat;
import DataAcessObjectImpl.FlightSeatDAOImpl;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author bibes
 */
public class FlightSeatsController {

    public FlightSeatsController() {
    }
    
    public static ArrayList<FlightSeat> getFlightSeats(int idFlight)
    {
        
        return new FlightSeatDAOImpl().findByIdFlight(idFlight);
        
    }
    
    public static void addFlightSeat(FlightSeat seat, int idFlight)
    {
        new FlightSeatDAOImpl().add(seat.getSeatNo(),idFlight , seat.getClassName(), seat.getSeatPrice(), seat.getIsAvailable());
        JOptionPane.showMessageDialog(null, "The seat has been added");
    }
    
    public static void deleteFlightSeat (FlightSeat seat)
    {
        new FlightSeatDAOImpl().delete(seat);
        JOptionPane.showMessageDialog(null, "The seat has been deleted");
    }
            
            
    public static boolean CheckFlightSeatInfo(String seatNo,String price)
    {
        try {
            Double.parseDouble(price);
            Integer.parseInt(seatNo);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }
 
        return true;
    }
    
    
}
