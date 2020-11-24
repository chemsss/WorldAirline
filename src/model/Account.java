package model;

import java.sql.*;

public abstract class Account {

    private int idAccount;//id account
    private String email;//email
    private String password;//password
    private String firstName; //first name
    private String lastName; //last name
    private String address; //address
    private Date birthDate;//dateOfBirth
    private String telephoneNumber;//tel no

    public Account(int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
    }

        public Account(String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Account{" + "idAccount=" + idAccount + ", email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", birthDate=" + birthDate + ", telephoneNumber=" + telephoneNumber + '}';
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
