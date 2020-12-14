package DataAcessObject;

import model.Airplane;

public interface AirplaneDAO {
    
    Airplane find(int idAirplane);
    
    boolean create(Airplane airplane);
    
    Airplane[] findAllAirplanes();

}
