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
    
    public static boolean SignUpCustomerAccount(String email, String password, String lastName, String firstName, String telephoneNumber, Date birthDate, String address) {
        
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
                        new CustomerAccountDAOImpl().create(new CustomerAccount( "Regular", email,  FieldsController.getMD5Hash(password),  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                        return true;
                    }
                    else {
                        System.out.println("child <0");
                        System.out.println("child");
                        new CustomerAccountDAOImpl().create(new CustomerAccount( "Child", email,  FieldsController.getMD5Hash(password),  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                        return true;
                    }
                }
            else {
                System.out.println("senior");
                new CustomerAccountDAOImpl().create(new CustomerAccount( "Senior", email,  FieldsController.getMD5Hash(password),  firstName,  lastName,  address,  birthDate,  telephoneNumber ));
                return true;
            }
        }
        
        return false;
    }
    
            
    
}
