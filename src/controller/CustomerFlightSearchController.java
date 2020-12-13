package controller;

import Exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                throw new Exceptions.AirportException();
            } 
            if(frame.getDepartureDate()==null)
            {
                throw new EmptyFields();
            }
            else {
                frame.setSearchDepartureFlightsModel(new SearchFlightsTableModel(((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getFirstClass()));

              
            }

        } catch (Exceptions.AirportException exception) {
            System.out.println(exception.getMessage());
        } catch (EmptyFields ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void roundTripSearchController() {

        try {
            if (((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport())) {
                throw new Exceptions.AirportException();
            } 
           if((frame.getDepartureDate()==null && frame.getReturnDate()==null) || (frame.getDepartureDate()==null || frame.getReturnDate()==null) )
            {
                throw new EmptyFields();
            }
            
            
            else {
                frame.setSearchReturnFlightsRoundTripModel(new SearchFlightsTableModel(((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getFirstClass()));

                frame.setSearchDepartureFlightsRoundTripModel(new SearchFlightsTableModel(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport(),
                        ((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                        frame.getDepartureDate(),
                        frame.getSelectPassenger(),
                        frame.getFirstClass()));

            }
        } catch (Exceptions.AirportException  exception) {
            System.out.println(exception.getMessage());
        
        } catch (EmptyFields ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
