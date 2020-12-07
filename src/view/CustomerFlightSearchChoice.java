package view;

import controller.CustomerFlightSearchController;
import controller.FlightController;
import java.awt.event.*;
import javax.swing.JOptionPane;
import model.*;

import java.util.ArrayList;

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
                System.out.println("ertt");

                if (frame.getOneWay().isSelected()) //If one Way is selected
                {
                    System.out.println("tete");
                    if (!frame.getSearchDepartureFlights().getSelectionModel().isSelectionEmpty()) { //If we select a flight
                        
                        System.out.println("etetet");
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
                                new PassengersInfosFrame(flights, frame.getSelectPassenger(), frame.getLoggedInCustomer());
                            } else if (x == 1) {
                                new PassengersInfosFrame(flights, frame.getSelectPassenger());
                            }

                        }
                    }
                }
                if (frame.getRoundTrip().isSelected()) {

                   if ( (!frame.getSearchDepartureFlightsRoundTrip().getSelectionModel().isSelectionEmpty()) && (!frame.getSearchReturnFlightsRoundTrip().getSelectionModel().isSelectionEmpty()))
                   { //If we select a flight
                    String stringIdFlight = frame.getSearchDepartureFlightsRoundTrip().getValueAt(frame.getSearchDepartureFlightsRoundTrip().getSelectedRow(), 1).toString();
                    int idDepartureFlight = Integer.parseInt(stringIdFlight);
                    stringIdFlight = frame.getSearchReturnFlightsRoundTrip().getValueAt(frame.getSearchReturnFlightsRoundTrip().getSelectedRow(), 1).toString();
                    int idArrivalFlight = Integer.parseInt(stringIdFlight);

                    Flight selectedDepFlight = FlightController.getFlight(idDepartureFlight);
                    Flight selectedArrFlight = FlightController.getFlight(idArrivalFlight);

                    ArrayList<Flight> flights = new ArrayList<>();
                    flights.add(selectedDepFlight);
                    flights.add(selectedArrFlight);
                    new PassengersInfosFrame(flights, frame.getSelectPassenger());
                   }
                }

            }
            
            break;

            case "Logged": {
                new MyAccountFrame(frame.getLoggedInCustomer());
            }

            break;

            case "Unlogged": {
                new LogInFrame();
            }

            break;

        }

    }

}
