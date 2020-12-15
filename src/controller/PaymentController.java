/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.BookingDAOImpl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Booking;
import model.Passenger;
import model.Ticket;

/**
 *
 * @author Chems
 */
public class PaymentController {

    public static void addReservation(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers) {
        if (new BookingDAOImpl().add((booking), idAccount, idCoupon, passengers) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't create booking.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            System.out.println("ok");
        }

    }

    public static void addReservation(Booking booking, int idAccount, int idCoupon, ArrayList<Passenger> passengers, ArrayList<Ticket> returnTickets) {
        if (new BookingDAOImpl().add((booking), idAccount, idCoupon, passengers, returnTickets) == false) {
            JOptionPane.showMessageDialog(null, "Couldn't create booking.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            System.out.println("ok");
        }

    }
    
}
