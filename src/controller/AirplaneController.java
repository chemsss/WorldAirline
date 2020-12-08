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
 * @author Unknow
 */
public class AirplaneController {
    
        public static Airplane[] getAllAirports() {
        return new AirplaneDAOImpl().findAllAirplanes();
    }
}
