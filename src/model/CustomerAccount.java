package model;

import java.sql.Date;

public class CustomerAccount extends Account {

    private String ageCategory; //age category

    public CustomerAccount(String ageCategory, int idAccount, String email, String password, String firstName, String lastName, Date birthDate, String telephoneNumber) {
        super(idAccount, email, password, firstName, lastName, birthDate, telephoneNumber);
        this.ageCategory = ageCategory;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }
}
