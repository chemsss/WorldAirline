package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FlightSeat;


public class SearchFlightSeatsTableModel extends AbstractTableModel {
    
     private final String[] Titles = {"SeatNo", "Classe Name", "Seat Price", "isAvailable"};
     
     private  ArrayList<FlightSeat> FlightSeats;

    public SearchFlightSeatsTableModel(ArrayList<FlightSeat> FlightSeats) {
        this.FlightSeats = FlightSeats;
    }
     
      @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public int getRowCount() {
        return FlightSeats.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return FlightSeats.get(row).getSeatNo();
            case 1:
                return FlightSeats.get(row).getClassName();
            case 2:
                return FlightSeats.get(row).getSeatPrice();
            case 3:
                return FlightSeats.get(row).getIsAvailable();
          
            default:
                return "";
        }
    }
    
}
