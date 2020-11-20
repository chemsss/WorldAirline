package model;

import java.sql.Date;

public class EmployeeAccount extends Account {

    public EmployeeAccount(int idAccount, String email, String password, String firstName, String lastName, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, birthDate, telephoneNumber);
    }
    
    
}
