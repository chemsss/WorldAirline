/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import model.*;

/**
 *
 * @author Unknow
 */
public interface BookingDAO {
    
      public Booking find(int bookingNo);
}