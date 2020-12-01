package view;

import Exceptions.DateException;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import view.CustomerHomeFlightSearch;
import model.*;
import controller.SearchFlightsTableModel;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class CustomerFlightSearchChoice implements ActionListener {

    private CustomerHomeFlightSearch frame;

    public CustomerFlightSearchChoice(CustomerHomeFlightSearch f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Search": {
                
                try {
                    if(frame.getOneWay().isSelected()) {
                        if(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport())) {
                            JOptionPane.showMessageDialog(null , "Please choose an arrival airport different from the departure airport", "Departure and arrival airports are the same", 0);
                            //String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className
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

                }catch(Exception exception) {
                    System.out.println(exception.getMessage());
                }
                
                
                
            }
            break;
                
                
                
            
            case "Next":
                // new signUp();
                frame.dispose(); // on ferme la fenetre actuelle
                break;

        }

    }
    
}

