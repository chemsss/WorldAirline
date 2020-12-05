package model;
import java.sql.*;
import java.util.ArrayList;


public class Passenger {
    
    private int idPassenger;//id passenger
    private String email; //email passenger
    private String firstName; //first name
    private String lastName; //last name
    private String address;//address 
    private Date birthDate;//dateOfBirth
    private String telephoneNumber;// tel no
    private String nationality;//nationality
    private String passportNo; // passport no
    
    ArrayList<Ticket> tickets;

    public Passenger(int idPassenger, String email, String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String nationality, String passportNo, ArrayList<Ticket> tickets) {
        this.idPassenger = idPassenger;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.nationality = nationality;
        this.passportNo = passportNo;
        this.tickets=(ArrayList)tickets.clone();
    }
    public Passenger(String email, String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String nationality, String passportNo, ArrayList<Ticket> tickets) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.nationality = nationality;
        this.passportNo = passportNo;
        this.tickets=(ArrayList)tickets.clone();
    }
    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return birthDate;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Override
    public String toString() {
        return "Passenger{" + "idPassenger=" + idPassenger + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", birthDate=" + birthDate + ", telephoneNumber=" + telephoneNumber + ", nationality=" + nationality + ", passportNo=" + passportNo + ", tickets=" + tickets + '}';
    }
        
}
