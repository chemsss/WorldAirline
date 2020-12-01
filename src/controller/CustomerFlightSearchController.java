/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Exceptions.DateException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Airport;
import view.CustomerHomeFlightSearch;

/**
 *
 * @author Chems
 */
public class CustomerFlightSearchController {
    
    String getActionCommand;
    CustomerHomeFlightSearch frame;
    
    
    public CustomerFlightSearchController(CustomerHomeFlightSearch frame) {
        this.frame = frame;
    }
    
    public void flightSearchResult() {
        
        try {
            if(frame.getOneWay().isSelected()) {
                if(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport())) {
                    throw new Exceptions.AirportException();
                }
                ChronoLocalDate today = LocalDate.now();
                SimpleDateFormat  formatter = new SimpleDateFormat("dd//mm//yyyy");  
                //LocalDateTime now = LocalDateTime.now();  
                if(formatter.format(today).compareTo(formatter.format(frame.getDepartureDate())) > 0){
                    throw new DateException("You can't get a flight before today's date.");
                }
                
                        /*if((frame.getArrivalDate()).compareTo(frame.getDepartureDate()) < 0) {
                            throw new DateException("Departure date is after arrival date.");
                        }*/
                else {
                    frame.setSearchDeapartureFlightsModel( new SearchFlightsTableModel(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                    ((Airport)frame.getToArrival().getSelectedItem()).getIdAirport(),
                    frame.getDepartureDate(),
                    frame.getSelectPassenger(),
                    frame.getFirstClass() ));
                            

                    System.out.println(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport());
                    System.out.println(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport());
                    System.out.println(frame.getDepartureDate().toString());
                    System.out.println(frame.getSelectPassenger());
                            //System.out.println(((JRadioButton) frame.getFirstClass()).getText());
                    } 
                        
                }
                else if(frame.getRoundTrip().isSelected()) {
                    if(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport())) {
                            JOptionPane.showMessageDialog(null , "Please choose an arrival airport different from the departure airport", "Departure and arrival airports are the same", 0);
                            //String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className
                    }
                    else{
                            frame.setSearchArrivalFlightsARModel( new SearchFlightsTableModel(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                            ((Airport)frame.getToArrival().getSelectedItem()).getIdAirport(),
                            frame.getDepartureDate(),
                            frame.getSelectPassenger(),
                            frame.getFirstClass() ));
                            
                            frame.setSearchDepartureFlightsARModel( new SearchFlightsTableModel(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport(),
                            ((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport(),
                            frame.getDepartureDate(),
                            frame.getSelectPassenger(),
                            frame.getFirstClass() ));
                    }
                }
        }catch(Exceptions.AirportException | Exceptions.DateException exception) {
            System.out.println(exception.getMessage());
        }
}    
    
    
}
