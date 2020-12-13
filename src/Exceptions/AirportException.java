package Exceptions;

import javax.swing.JOptionPane;


public class AirportException extends Exception{
    
    public AirportException() throws AirportException {
        super("You can't the same airport for arrival and departure airport");
        JOptionPane.showMessageDialog(null , "Please choose an arrival airport different than the departure airport.", "", 0);
    } 
    
    
    
}
