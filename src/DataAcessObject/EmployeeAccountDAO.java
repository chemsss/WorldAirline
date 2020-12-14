package DataAcessObject;
import model.EmployeeAccount;


public interface EmployeeAccountDAO {
    
    EmployeeAccount find(int idEmployeeAccount);
    EmployeeAccount find(String email, String password);
    boolean create(EmployeeAccount account);
}
