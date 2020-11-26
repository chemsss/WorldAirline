
package controller;

import DataAcessObjectImpl.EmployeeAccountDAOImpl;
import model.EmployeeAccount;

public class EmployeeLoginController {

    public boolean  EmployeeLoginConnection(String mail, String password) {
        if (new EmployeeAccountDAOImpl().find(mail, password) != null) {
            return true;
        } else {

            return false;

        }
    }

    public EmployeeAccount getEmployeeAccount(String mail, String password) {
        return new EmployeeAccountDAOImpl().find(mail, password);
    }
}
