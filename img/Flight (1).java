package model;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Flight {
    
    private int idFlight; //flight id
    
    private String airlineName; // airline name
    private Timestamp departureDate; //flight date/H departure
    private Timestamp arrivalDate; //flight date/H arrival
    
    private Airplane airplane; // airplane model
    private Airport departureAirport; // airport departure
    private Airport arrivalAirport; // arrival airport
    private ArrayList<FlightSeat> seats;  //array of flight seat
    
    public Flight(int idFlight, String airlineName, Timestamp departureDate, Timestamp arrivalDate, Airplane airplane, Airport departureAirport, Airport arrivalAirport, ArrayList<FlightSeat> seats) {
        
        this.idFlight = idFlight;
        this.airlineName = airlineName;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.seats = (ArrayList) seats.clone();
    }
    
    @Override
    public String toString() {
        return "Flight{" + "idFlight=" + idFlight + ", airlineName=" + airlineName + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", airplane=" + airplane + ", departureAirport=" + departureAirport + ", arrivalAirport=" + arrivalAirport + ", seats=" + seats + '}';
    }

    public Flight() {
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public ArrayList<FlightSeat> getSeat() {
        return seats;
    }

    public void setSeat(ArrayList<FlightSeat> seat) {
        this.seats = seat;
    }
    
    public String getDepartureDateTimeToString()
    {
        String timeStamp = new SimpleDateFormat("dd/mm/yy hh:mm").format(departureDate);
        
        return timeStamp;
    }
    
     public String getArrivalDateTimeToString()
    {
        String timeStamp = new SimpleDateFormat("dd/mm/yy hh:mm").format(arrivalDate);
        
        return timeStamp;
    }
     
     public FlightSeat getseatFromClass(String className) {
         for(int i=0; i<seats.size(); ++i) {
             if(seats.get(i).getClassName().equals(className) && seats.get(i).getIsAvailable()==true) {
                 return seats.get(i);
             }
         }
         return null;
     }
}
