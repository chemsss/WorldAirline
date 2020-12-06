package model;

import java.sql.Date;
import java.util.ArrayList;

public class CustomerAccount extends Account {

    private String ageCategory; //age category
    private ArrayList<Booking> bookings;

    public CustomerAccount(String ageCategory, ArrayList<Booking> bookings, int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, address, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
        this.bookings = (ArrayList)bookings.clone();
    }
    
    
    public CustomerAccount(String ageCategory, ArrayList<Booking> booking, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(email, password, firstName, lastName, address, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
        this.bookings = (ArrayList)bookings.clone();
    }
    
    public CustomerAccount(String ageCategory, int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, address, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
    }
    
    public CustomerAccount(String ageCategory, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(email, password, firstName, lastName, address, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
    }

      public CustomerAccount(int id,String ageCategory, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(id,email, password, firstName, lastName, address, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
    }


    @Override
    public String toString() {
        return "CustomerAccount{" +super.toString() +"ageCategory=" + ageCategory + ", bookings=" + bookings + '}';
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
