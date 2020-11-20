package model;


public class Ticket {
    
    private int ticketNo; // numero of ticket
    private Passenger passengerInfos; //passenger
    private FlightSeat seat;// seat
    private Flight flight;//flight
    

    public Ticket(int ticketNo, Passenger passengerInfos, FlightSeat seat, Flight flight) {
        this.ticketNo = ticketNo;
        this.passengerInfos = passengerInfos;
        this.seat = seat;
        this.flight = flight;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Passenger getPassengerInfos() {
        return passengerInfos;
    }

    public void setPassengerInfos(Passenger passengerInfos) {
        this.passengerInfos = passengerInfos;
    }

    public FlightSeat getSeat() {
        return seat;
    }

    public void setSeat(FlightSeat seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
