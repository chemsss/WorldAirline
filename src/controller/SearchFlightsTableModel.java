package controller;

import model.Flight;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import DataAcessObjectImpl.FlightDAOImpl;

public class SearchFlightsTableModel extends AbstractTableModel {

    private final String[] Titles = {"Airline", "Flight Number", "From", "Departure", "To", "Arrival"};

    private final ArrayList<Flight> flights;

    public SearchFlightsTableModel(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    public SearchFlightsTableModel(String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className) {
        flights = new FlightDAOImpl().searchFlights(DepartureAirportId, arrivalAirportId, departureDate, nbOfSeats, className);
    }
    
    public SearchFlightsTableModel() {
        flights = new ArrayList<>();
    } 

    @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public int getRowCount() {
        return flights.size();
    }

    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return flights.get(row).getAirlineName();
            case 1:
                return flights.get(row).getIdFlight();
            case 2:
                return flights.get(row).getDepartureAirport();
            case 3:
                return flights.get(row).getDepartureDateTimeToString();
            case 4:
                return flights.get(row).getArrivalAirport();
            case 5:
                return flights.get(row).getArrivalDateTimeToString();
            default:
                return "";
        }
    }

}
