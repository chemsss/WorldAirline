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
                    String stringIdFlight = frame.getSearchDeapartureFlights().getValueAt(frame.getSearchDeapartureFlights().getSelectedRow(), 1).toString();
                    int idFlight = Integer.parseInt(stringIdFlight);
                    System.out.println("FLIGHT ID : "+stringIdFlight);
                    //Flight selectedFlight = FlightController.getFlight(frame.getSearchDeapartureFlights().getValueAt(frame.getSearchDeapartureFlights().getSelectedRow(), 1))
                    ArrayList<Flight> selectedFlight = new ArrayList();
                    selectedFlight.add(FlightController.getFlight(idFlight));
                    selectedFlight.add(FlightController.getFlight(idFlight));
                   
                    new PassengerView(selectedFlight, frame.getSelectPassenger());
                }
                
                
                break;

        }

    }
    
}

