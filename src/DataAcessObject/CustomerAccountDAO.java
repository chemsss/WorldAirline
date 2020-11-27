/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;
import model.CustomerAccount;

/**
 *
 * @author Chems
 */
public interface CustomerAccountDAO {
    
    CustomerAccount find(int idCustomerAccount);
    CustomerAccount find(String email, String password);
    boolean create(CustomerAccount account);
    
}
