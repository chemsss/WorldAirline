package controller;

import model.Booking;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import DataAcessObjectImpl.FlightDAOImpl;
import java.util.Date;
import model.Ticket;

public class SearchBookingsTableModel extends AbstractTableModel {

    private final String[] Titles = {"Booking No", "Booking Date", "Tickets Numbers"};

    private ArrayList<Booking> bookings;
    
    /*
    private int bookingNo;//booking no
    private Date bookingDate;// booking date
    private ArrayList<Ticket> tickets; //tickets
    */
    
    public SearchBookingsTableModel(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public SearchBookingsTableModel(int bookingNo, Date bookingDate, ArrayList<Ticket> tickets) {
        //bookings = new FlightDAOImpl().searchFlights(DepartureAirportId, arrivalAirportId, departureDate, nbOfSeats, className);
    }
    
    public SearchBookingsTableModel() {
        bookings = new ArrayList<>();
    } 

    @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public int getRowCount() {
        return bookings.size();
    }

    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return bookings.get(row).getBookingNo();
            case 1:
                return bookings.get(row).getBookingDate();
            case 2:
            {
                int size=0;
                if(bookings.get(row).getTickets()==null)
                    size=0;
                else
                    size=bookings.get(row).getTickets().size();
                return size;
            }
            default:
                return "";
        }
    }

}
