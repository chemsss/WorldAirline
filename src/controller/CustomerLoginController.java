package controller;

import model.*;
import DataAcessObjectImpl.CustomerAccountDAOImpl;

public class CustomerLoginController {

    public boolean CustomerLoginConnection(String mail, String password) {
        if (new CustomerAccountDAOImpl().find(mail, password) != null) {
            return true;
        } else {

            return false;

        }
    }
}
