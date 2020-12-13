package DataAcessObjectImpl;

import DataAcessObject.EmployeeAccountDAO;
import model.EmployeeAccount;
import java.sql.*;

public class EmployeeAccountDAOImpl implements EmployeeAccountDAO {

    @Override
    public EmployeeAccount find(int idEmployeeAccount) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from employeeaccount where idEmployeeAccount=" + idEmployeeAccount + ";");

            if (myRs.first()) {

                return new EmployeeAccount(idEmployeeAccount, myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    @Override
    public EmployeeAccount find(String email, String password) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM employeeaccount WHERE email='" + email + "' AND password='" + password + "';");

            if (myRs.first()) {
                return new EmployeeAccount(myRs.getInt("idEmployeeAccount"), myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean create(EmployeeAccount account) {

        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO employeeaccount (`email`, `password`, `firstName`, `lastName`, `address`, `birthDate`, `telephoneNumber`) VALUES (?, ?, ?, ?, ?, ?, ?);");
            myStmt.setString(1, account.getEmail());
            myStmt.setString(2, account.getPassword());
            myStmt.setString(3, account.getFirstName());
            myStmt.setString(4, account.getLastName());
            myStmt.setString(5, account.getAddress());
            myStmt.setDate(6, account.getBirthDate());
            myStmt.setString(7, account.getTelephoneNumber());
            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

}
