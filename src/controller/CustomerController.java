package controller;

import model.*;
import DataAcessObjectImpl.CustomerAccountDAOImpl;
import java.sql.Date;
import java.util.Calendar;

public class CustomerController {

    
    public boolean CustomerLoginConnection(String mail, String password) {
        if (new CustomerAccountDAOImpl().find(mail, password) != null) {
            return true;
        } else {

            return false;

        }
    }

    public CustomerAccount getCustomerAccount(String mail, String password) {
        return new CustomerAccountDAOImpl().find(mail, password);
    }
    
    public static void SignUpCustomerAccount(String email, String password, String lastName, String firstName, String telephoneNumber, Date birthDate, String address) {
        
        if( FieldsController.checkSignUp(email, password, lastName, firstName, telephoneNumber) == true) {
            int childAgeLimit = 12; //age has to bo <ageLimit for the person to be in the ageCategory
            int regularAgeLimit = 63; //age has to bo <ageLimit for the person to be in the ageCategory
            java.util.Date todaysDate = Calendar.getInstance().getTime();
            
            java.sql.Date todaysDateSql = new java.sql.Date(todaysDate.getTime());
            
            java.sql.Date todaysDateSqlTestRegular = (java.sql.Date) todaysDateSql.clone();
            todaysDateSqlTestRegular.setYear(todaysDateSql.getYear()-regularAgeLimit);
            
            java.sql.Date todaysDateSqlTestChild = (java.sql.Date) todaysDateSql.clone();
            todaysDateSqlTestChild.setYear(todaysDateSql.getYear()-childAgeLimit);
                    
                    
            System.out.println(todaysDateSqlTestRegular);
            System.out.println(birthDate);
            System.out.println(birthDate.compareTo(todaysDateSqlTestRegular));
            System.out.println(todaysDateSql);
            
            System.out.println(todaysDateSqlTestChild);
            System.out.println(birthDate);
            System.out.println(birthDate.compareTo(todaysDateSqlTestChild));
            System.out.println(todaysDateSql);
                    
            if(birthDate.compareTo(todaysDateSqlTestRegular) > 0) {                    
                    
                    if(birthDate.compareTo(todaysDateSqlTestChild) < 0) {
                        System.out.println("regular");
                        new CustomerAccountDAOImpl().create(new CustomerAccount( "Regular", email,  password,  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                    }
                    else {
                        System.out.println("child <0");
                        System.out.println("child");
                        new CustomerAccountDAOImpl().create(new CustomerAccount( "Child", email,  password,  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                    }
                }
            else {
                System.out.println("senior");
                new CustomerAccountDAOImpl().create(new CustomerAccount( "Senior", email,  password,  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
            }
            
            
            /*java.sql.Date todaysDateSqlTestChild = (java.sql.Date) todaysDateSql.clone();
            todaysDateSqlTestChild.setYear(todaysDateSql.getYear()-childAgeLimit); //for testing if the person is aged bellow the age limit or but taking in account if his birthday is past or not
            
            System.out.println(todaysDateSqlTestChild);
            System.out.println(birthDate);
            System.out.println(birthDate.compareTo(todaysDateSqlTestChild));
            System.out.println(todaysDateSql);
            if(birthDate.compareTo(todaysDateSqlTestChild) < 0) {
                System.out.println("child <0");
                
                java.sql.Date todaysDateSqlTestRegular = (java.sql.Date) todaysDateSql.clone();
                todaysDateSqlTestRegular.setYear(todaysDateSql.getYear()-regularAgeLimit);
                
                if(birthDate.compareTo(todaysDateSqlTestChild) < 0) {
                    System.out.println("regular <0");
                    //new CustomerAccountDAOImpl().create(new CustomerAccount( "Child", email,  password,  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                }
            }*/
                
                
            /*
            if(todaysDateSql.getYear() - birthDate.getYear() < childAgeLimit) {
                System.out.println(todaysDateSql.getYear() +" - " +birthDate.getYear() +" = " +(todaysDateSql.getYear() - birthDate.getYear()));
                //new CustomerAccountDAOImpl().create(new CustomerAccount( "Child", email,  password,  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
            }*/
            //(String ageCategory, String email, String password, String firstName, String lastName, String address, Date birthDate, String telephoneNumber)
        }
        
    }
    
            
    
}
