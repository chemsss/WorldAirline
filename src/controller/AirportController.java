package controller;
import model.Airport;
import DataAcessObjectImpl.AirportDAOImpl;


public class AirportController {

    public static Airport[] getAllAirports() {
        return new AirportDAOImpl().findAllAirports();
    }

}