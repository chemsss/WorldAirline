/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.AirplaneDAOImpl;
import model.Airplane;

/**
 *
 * @author bibes
 */
public class AirplaneController {
 
    public static Airplane[] getAllAirplanes() {
        return new AirplaneDAOImpl().findAllAirplanes();
    }
    
}
