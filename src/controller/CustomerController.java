package controller;

import model.*;
import DataAcessObjectImpl.CustomerAccountDAOImpl;

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
    
            
    
}