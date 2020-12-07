/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Airport;
import view.CustomerHomeFlightSearch;

/**
 *
 * @author Chems
 */
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
                        frame.getSelectedClass()));

                System.out.println(((Airport) frame.getFromDeparture().getSelectedItem()).getIdAirport());
                System.out.println(((Airport) frame.getToArrival().getSelectedItem()).getIdAirport());
                System.out.println(frame.getDepartureDate().toString());
                System.out.println(frame.getSelectPassenger());
                //System.out.println(((JRadioButton) frame.getFirstClass()).getText());

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
                throw new AirportException();
            } 
           if((frame.getDepartureDate()==null && frame.getReturnDate()==null) || (frame.getDepartureDate()==null || frame.getReturnDate()==null) )
            {
                throw new EmptyFields();
            }
            if(frame.getDepartureDate().compareTo(frame.getReturnDate()) > 0)
            {
                throw new DateException("You can't have the return date before the depart date.");
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
