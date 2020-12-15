package controller;

import DataAcessObjectImpl.PassengerDAOImpl;
import DataAcessObjectImpl.TicketDAOImpl;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Ticket;

public class SearchTicketsTableModel extends AbstractTableModel {

    private final String[] Titles = {"Ticket Number", "Flight Number", "Last Name", "First Name"};

    private final ArrayList<Ticket> tickets;
 
    public SearchTicketsTableModel(int bookingNumber) {
        tickets = new TicketDAOImpl().findByBookingNo(bookingNumber);
    }
    
    public SearchTicketsTableModel() {
        tickets = new ArrayList<>();
    } 

    @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public int getRowCount() {
        return tickets.size();
    }

    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return tickets.get(row).getTicketNo();
            case 1:
                return tickets.get(row).getFlight().getIdFlight();
            case 2:
                return new PassengerDAOImpl().findByTicketNo(tickets.get(row).getTicketNo()).getLastName();
            case 3:
                return new PassengerDAOImpl().findByTicketNo(tickets.get(row).getTicketNo()).getFirstName();
            default:
                return "";
        }
    }

}
