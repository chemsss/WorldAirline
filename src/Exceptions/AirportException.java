package Exceptions;

import javax.swing.JOptionPane;


public class AirportException extends Exception{
    
    public AirportException() {
        super("You can't the same arrival and departure airport.");
        JOptionPane.showMessageDialog(null , "Please choose an arrival airport different than the departure airport.", "", 0);
    } 
    
    
    
}
