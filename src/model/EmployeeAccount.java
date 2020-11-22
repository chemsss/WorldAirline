package model;

import java.sql.Date;

public class EmployeeAccount extends Account {

    public EmployeeAccount(int idAccount, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, address, birthDate, telephoneNumber);
    }    

    @Override
    public String toString() {
        return "EmployeeAccount{" +super.toString() + '}';
    }
    
    
}
