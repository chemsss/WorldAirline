/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author Chems
 */
public class AirportException extends Exception{
    
    public AirportException() {
        super("You can't the same arrival and departure airport.");
        JOptionPane.showMessageDialog(null , "Please choose an arrival airport different than the departure airport.", "", 0);
    } 
    
    
    
}
