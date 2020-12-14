package DataAcessObject;
import model.CustomerAccount;


public interface CustomerAccountDAO {
    
    CustomerAccount find(int idCustomerAccount);
    CustomerAccount find(String email, String password);
    boolean create(CustomerAccount account);
    CustomerAccount findByBookingNo(int bookingNo);
    
}
