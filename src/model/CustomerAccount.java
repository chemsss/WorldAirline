package model;

import java.sql.Date;
import java.util.ArrayList;

public class CustomerAccount extends Account {

    private String ageCategory; //age category
    private ArrayList<Booking> bookings;

    public CustomerAccount(String ageCategory, ArrayList<Booking> bookings, int idAccount, String email, String password, String firstName, String lastName, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
        this.bookings = (ArrayList)bookings.clone();
    }

 
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

}
