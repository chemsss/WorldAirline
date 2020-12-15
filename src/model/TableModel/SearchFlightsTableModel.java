package model.TableModel;

import model.Flight;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import DataAcessObjectImpl.FlightDAOImpl;

public class SearchFlightsTableModel extends AbstractTableModel {

    private final String[] Titles = {"Airline", "Flight N°", "From", "To", "Departure", "Arrival", "Price"};

    private final String[] Titles2 = {"Airline", "Flight N°", "From", "To", "Departure", "Arrival"};

    private boolean employee;

    private ArrayList<Flight> flights;
    private String className;

    public SearchFlightsTableModel(ArrayList<Flight> flights) {
        this.flights = flights;
        this.employee = true;
    }

    public SearchFlightsTableModel(String DepartureAirportId, String arrivalAirportId, java.util.Date departureDate, int nbOfSeats, String className) {
        flights = new FlightDAOImpl().searchFlights(DepartureAirportId, arrivalAirportId, departureDate, nbOfSeats, className);
        this.className = className;
        this.employee =false;
    }

    public SearchFlightsTableModel() {
        flights = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        if (employee == true) {
            return Titles2.length;
        } else {
            return Titles.length;
        }
    }

    @Override
    public int getRowCount() {
        return flights.size();
    }

    @Override
    public String getColumnName(int column) {
        if (employee == true) {
            return Titles2[column];
        } else {
            return Titles[column];
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (employee==true) {
            switch (column) {
                case 0:
                    return flights.get(row).getAirlineName();
                case 1:
                    return flights.get(row).getIdFlight();
                case 2:
                    return flights.get(row).getDepartureAirport();
                case 3:
                    return flights.get(row).getArrivalAirport();
                case 4:
                    return flights.get(row).getDepartureDateTimeToString();
                case 5:
                    return flights.get(row).getArrivalDateTimeToString();

                default:
                    return "";
            }
        } else {
            switch (column) {
                case 0:
                    return flights.get(row).getAirlineName();
                case 1:
                    return flights.get(row).getIdFlight();
                case 2:
                    return flights.get(row).getDepartureAirport();
                case 3:
                    return flights.get(row).getArrivalAirport();
                case 4:
                    return flights.get(row).getDepartureDateTimeToString();
                case 5:
                    return flights.get(row).getArrivalDateTimeToString();
                case 6:
                    return flights.get(row).getseatFromClass(className).getSeatPrice() + "€";

                default:
                    return "";
            }
        }

    }

}
