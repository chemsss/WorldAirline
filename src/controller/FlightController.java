/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DataAcessObjectImpl.FlightDAOImpl;
import model.Flight;

/**
 *
 * @author Chems
 */
public class FlightController {
    
    public FlightController(){
        
    }
    
    public static Flight getFlight(int idFlight) {
        
        return new FlightDAOImpl().find(idFlight);
        
    }
    
            
    
}
