/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAcessObjectImpl.PassengerDAOImpl;

/**
 *
 * @author Unknow
 */
public class PassengerController {

      public static String getLastNamePassengerByTicketNo(int TicketNo)
      {
            
          String lastName = new PassengerDAOImpl().findByTicketNo(TicketNo).getLastName();
          return lastName;
      }
      
      public static String getFirstNamePassengerByTicketNo(int TicketNo)
      {
            
          String firstName = new PassengerDAOImpl().findByTicketNo(TicketNo).getFirstName();
          return firstName;
      }
      
            
      
      
}
