/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import java.util.ArrayList;
import model.Airport;



public interface AirportDAO {
    
    Airport find(String idAirport);
    Airport[] findAllAirports();
    boolean create(Airport airport);
    double findAirportPourcentage(String idAirport);
    ArrayList<String> findAllAirportNames();
    ArrayList<Double> findPercentageAllAirpots();
    
}
