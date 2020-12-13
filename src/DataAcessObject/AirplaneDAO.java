/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import model.Airplane;

/**
 *
 * @author Unknow
 */
public interface AirplaneDAO {
    
    Airplane find(int idAirplane);
    
    boolean create(Airplane airplane);
    Airplane[] findAllAirplanes();
}
