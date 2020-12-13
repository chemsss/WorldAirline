package model;
import java.util.ArrayList;
import java.sql.*;

public class Booking {
    
    private int bookingNo;//booking no
    private Date bookingDate;// booking date
    private ArrayList<Ticket> tickets; //tickets

    public Booking(Date bookingDate, ArrayList<Ticket> tickets) {
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
    }
    public Booking(int bookingNo, Date bookingDate, ArrayList<Ticket> tickets) {
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
    }

    public Booking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingNo=" + bookingNo + ", bookingDate=" + bookingDate + ", tickets=" + tickets + '}';
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }    
}