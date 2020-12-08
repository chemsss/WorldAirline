package model;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Booking {
    
    private int bookingNo;//booking no
    private Date bookingDate;// booking date
    private ArrayList<Ticket> tickets; //tickets
    private Coupon coupon;
    

    public Booking(Date bookingDate, ArrayList<Ticket> tickets) {
        this.bookingNo = 0;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
        this.coupon = null;
    }
    public Booking(int bookingNo, Date bookingDate, ArrayList<Ticket> tickets) {
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
        this.coupon = null;
    }
    
    public Booking(Date bookingDate, ArrayList<Ticket> tickets, Coupon coupon) {
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
        this.coupon = coupon;
    }
    public Booking(int bookingNo, Date bookingDate, ArrayList<Ticket> tickets, Coupon coupon) {
        this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
        this.tickets = tickets;
        this.coupon = coupon;
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

    public Coupon getCoupon() {
        return coupon;
    }
    
        public String getBookingDateDayToString()
    {
        System.out.println(bookingDate);
        String timeStamp = new SimpleDateFormat("dd").format(bookingDate);

        return timeStamp;
    }
    
    public String getBookingDateMonthToString()
    {
        System.out.println(bookingDate);
        String timeStamp = new SimpleDateFormat("MM").format(bookingDate);

        return timeStamp;
    }
    public String getBookingDateYearToString()
    {
        System.out.println(bookingDate);
        String timeStamp = new SimpleDateFormat("yyyy").format(bookingDate);

        return timeStamp;
    }

    
}