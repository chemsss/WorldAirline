package controller;

import DataAcessObjectImpl.AirplaneDAOImpl;
import model.Airplane;


public class AirplaneController {
    
        public static Airplane[] getAllAirports() {
        return new AirplaneDAOImpl().findAllAirplanes();
    }
}
