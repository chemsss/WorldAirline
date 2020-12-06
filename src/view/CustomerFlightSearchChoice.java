package view;

import Exceptions.DateException;
import com.toedter.calendar.JDateChooser;
import controller.CustomerFlightSearchController;
import controller.FlightController;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import view.CustomerHomeFlightSearch;
import model.*;
import controller.SearchFlightsTableModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class CustomerFlightSearchChoice implements ActionListener {

    private CustomerHomeFlightSearch frame;

    public CustomerFlightSearchChoice(CustomerHomeFlightSearch f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Search": {
                new CustomerFlightSearchController(frame);
            }
            break;
                
                
                
            
            case "Next":
                // new signUp();

                if(frame.getOneWay().isSelected()) {
                    String stringIdFlight = frame.getSearchDepartureFlights().getValueAt(frame.getSearchDepartureFlights().getSelectedRow(), 1).toString();
                    int idFlight = Integer.parseInt(stringIdFlight);

                    //Flight selectedFlight = FlightController.getFlight(frame.getSearchDepartureFlights().getValueAt(frame.getSearchDepartureFlights().getSelectedRow(), 1))
                    Flight selectedFlight = FlightController.getFlight(idFlight);
                    ArrayList<Flight> flights = new ArrayList<>();
                    flights.add(selectedFlight);
                    new PassengersInfosFrame(flights, frame.getSelectPassenger(), frame.getLoggedInCustomer());
                }
                if(frame.getRoundTrip().isSelected()) {

                    String stringIdFlight = frame.getSearchDepartureFlightsAR().getValueAt(frame.getSearchDepartureFlightsAR().getSelectedRow(), 1).toString();
                    int idDepartureFlight = Integer.parseInt(stringIdFlight);
                    stringIdFlight = frame.getSearchArrivalFlightsAR().getValueAt(frame.getSearchArrivalFlightsAR().getSelectedRow(), 1).toString();
                    int idArrivalFlight = Integer.parseInt(stringIdFlight);

                    Flight selectedDepFlight = FlightController.getFlight(idDepartureFlight);
                    Flight selectedArrFlight = FlightController.getFlight(idArrivalFlight);
                   
                    ArrayList<Flight> flights = new ArrayList<>();
                    flights.add(selectedArrFlight);
                    flights.add(selectedDepFlight);
                    new PassengersInfosFrame(flights, frame.getSelectPassenger(), frame.getLoggedInCustomer());
                }
                
                
                break;
                
                case "My account": 
                    if(frame.getMyAccount().getText().equals(" My account")) {
                        new MyAccount(frame.getLoggedInCustomer());
                    }
                    else if(frame.getMyAccount().getText().equals(" Log in")){
                        new CustomerLoginSignUp();
                    }
                
                    break;

        }

    }
    
}

