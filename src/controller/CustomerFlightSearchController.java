package controller;

import Exceptions.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import Exceptions.DateException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Airport;
import view.Customer.CustomerHomeFlightSearch;

public class CustomerFlightSearchController {

    CustomerHomeFlightSearch frame;

    public CustomerFlightSearchController(CustomerHomeFlightSearch frame) {
        this.frame = frame;

        if (frame.getOneWay().isSelected()) {
            oneWaySearchController();
            
        } else if (frame.getRoundTrip().isSelected()) {
            roundTripSearchController();
            
        }
    }

    public void oneWaySearchController() {

        try {
            if (((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport())) {
                throw new AirportException();
            } 
            if(frame.getDepartureDate()==null)
            {
                throw new EmptyFields();
            }
            java.util.Date todaysDate = Calendar.getInstance().getTime();
            java.sql.Date todaysDateSql = new java.sql.Date(todaysDate.getTime());
            if(frame.getDepartureDate().compareTo(Calendar.getInstance().getTime()) < 0 )
            {
                throw new DateException("You can't book a flight planned before today's date.");
            }
            else {
                frame.setSearchDepartureFlightsModel(new SearchFlightsTableModel(((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getSelectedClass()));

              
            }

        } catch ( AirportException | DateException exception) {
            System.out.println(exception.getMessage());
        } catch (EmptyFields ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void roundTripSearchController() {

        try {
            if (((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport())) {
                throw new AirportException();
            } 
           if((frame.getDepartureDate()==null && frame.getReturnDate()==null) || (frame.getDepartureDate()==null || frame.getReturnDate()==null) )
            {
                throw new EmptyFields();
            }
            System.out.println("pp" +frame.getDepartureDate().compareTo(frame.getReturnDate()));
            if(frame.getDepartureDate().compareTo(frame.getReturnDate()) > 0)
            {
                throw new DateException("You can't have the return date before the depart date.");
            }
            java.util.Date todaysDate = Calendar.getInstance().getTime();
            java.sql.Date todaysDateSql = new java.sql.Date(todaysDate.getTime());
            if(frame.getDepartureDate().compareTo(Calendar.getInstance().getTime()) < 0 )
            {
                throw new DateException("You can't book a flight planned before today's date.");
            }
            
            else {
                frame.setSearchReturnFlightsRoundTripModel(new SearchFlightsTableModel(((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getSelectedClass()));

                frame.setSearchDepartureFlightsRoundTripModel(new SearchFlightsTableModel(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getSelectedClass()));

            }
        } catch (AirportException | DateException | EmptyFields exception) {
            System.out.println(exception.getMessage());
        
        }

    }
    
}
