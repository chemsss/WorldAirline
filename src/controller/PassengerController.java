package controller;

import DataAcessObjectImpl.PassengerDAOImpl;

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
