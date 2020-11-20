package model;
import java.sql.*;


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

    public Passenger(int idPassenger, String email, String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String nationality, String passportNo) {
        this.idPassenger = idPassenger;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.nationality = nationality;
        this.passportNo = passportNo;
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
    
    
    
}
