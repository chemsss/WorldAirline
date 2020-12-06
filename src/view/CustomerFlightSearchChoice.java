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

            case "Next": {

                if (frame.getOneWay().isSelected()) {
                    String stringIdFlight = frame.getSearchDepartureFlights().getValueAt(frame.getSearchDepartureFlights().getSelectedRow(), 1).toString();
                    int idFlight = Integer.parseInt(stringIdFlight);
                    Flight selectedFlight = FlightController.getFlight(idFlight);

                    ArrayList<Flight> flights = new ArrayList<>();
                    flights.add(selectedFlight);

                    if (frame.getLoggedInCustomer() == null) {
                        new PassengersInfosFrame(flights, frame.getSelectPassenger());
                    } else {

                        String[] options = {"yes", "no"};

                        int x = JOptionPane.showOptionDialog(null, "Are you taking a ticket for you ?",
                                "Customer Account",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        if (x == 0) {                           
                          new PassengersInfosFrame(flights, frame.getSelectPassenger(),frame.getLoggedInCustomer());
                        } else if (x == 1) {
                            new PassengersInfosFrame(flights, frame.getSelectPassenger());
                        }

                    }

                }
                if (frame.getRoundTrip().isSelected()) {
                    String stringIdFlight = frame.getSearchDepartureFlightsRoundTrip().getValueAt(frame.getSearchDepartureFlightsRoundTrip().getSelectedRow(), 1).toString();
                    int idDepartureFlight = Integer.parseInt(stringIdFlight);
                    stringIdFlight = frame.getSearchArrivalFlightsRoundTrip().getValueAt(frame.getSearchArrivalFlightsRoundTrip().getSelectedRow(), 1).toString();
                    int idArrivalFlight = Integer.parseInt(stringIdFlight);
                    System.out.println("FLIGHT ID : " + idDepartureFlight + " ARRIVAL FLIGHT ID : " + idArrivalFlight);
                    Flight selectedDepFlight = FlightController.getFlight(idDepartureFlight);
                    Flight selectedArrFlight = FlightController.getFlight(idArrivalFlight);

                    ArrayList<Flight> flights = new ArrayList<>();
                    flights.add(selectedDepFlight);
                    flights.add(selectedArrFlight);
                    new PassengersInfosFrame(flights, frame.getSelectPassenger());
                }

            }

            break;

            case "Logged": {
                new MyAccount(frame.getLoggedInCustomer());
            }

            break;

            case "Unlogged": {
                new CustomerLoginSignUp();
            }

            break;

        }

    }

}
