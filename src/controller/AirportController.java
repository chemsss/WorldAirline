/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Airport;
import DataAcessObjectImpl.AirportDAOImpl;


/**
 *
 * @author Chems
 */
public class AirportController {
    
    public static Airport[] getAllAirports() {
        return new AirportDAOImpl().findAllAirports();
    }
}
