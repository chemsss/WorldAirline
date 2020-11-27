/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import model.Airport;

/**
 *
 * @author Chems
 */

public interface AirportDAO {
    
    Airport find(String idAirport);
    Airport[] findAllAirports();
    boolean create(Airport airport);
}
