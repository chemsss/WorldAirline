/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import model.EmployeeAccount;

/**
 *
 * @author Chems
 */
public interface EmployeeAccountDAO {
    
    EmployeeAccount find(int idEmployeeAccount);
    EmployeeAccount find(String email, String password);
    boolean create(EmployeeAccount account);
}