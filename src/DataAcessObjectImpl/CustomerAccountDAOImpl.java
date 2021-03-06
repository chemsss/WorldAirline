package DataAcessObjectImpl;

import DataAcessObject.CustomerAccountDAO;
import model.CustomerAccount;
import java.sql.*;

public class CustomerAccountDAOImpl implements CustomerAccountDAO {

    @Override
    public CustomerAccount find(int idCustomerAccount) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from customeraccount where idCustomerAccount=" + idCustomerAccount + ";");

            if (myRs.first()) {
                return new CustomerAccount(myRs.getString("ageCategory"), new BookingDAOImpl().findByIdCustomerAccount(idCustomerAccount), idCustomerAccount, myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public CustomerAccount find(String email, String password) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM customeraccount WHERE email='" + email + "' AND password='" + password + "';");

            if (myRs.first()) {
                return new CustomerAccount(myRs.getString("ageCategory"), new BookingDAOImpl().findByIdCustomerAccount(myRs.getInt("idCustomerAccount")), myRs.getInt("idCustomerAccount"), myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public CustomerAccount findByBookingNo(int bookingNo) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM booking,customeraccount WHERE bookingNo=" + bookingNo + " AND customerAccount.idaccount=idCustomerAccount ;");

            if (myRs.first()) {
                return new CustomerAccount(myRs.getString("ageCategory"), new BookingDAOImpl().findByIdCustomerAccount(myRs.getInt("idCustomerAccount")), myRs.getInt("idCustomerAccount"), myRs.getString("email"), myRs.getString("password"), myRs.getString("firstName"), myRs.getString("lastName"), myRs.getString("address"), myRs.getDate("birthDate"), myRs.getString("telephoneNumber"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    @Override
    public boolean create(CustomerAccount account) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO customeraccount (`email`, `password`, `ageCategory`, `firstName`, `lastName`, `address`, `birthDate`, `telephoneNumber`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            myStmt.setString(1, account.getEmail());
            myStmt.setString(2, account.getPassword());
            myStmt.setString(3, account.getAgeCategory());
            myStmt.setString(4, account.getFirstName());
            myStmt.setString(5, account.getLastName());
            myStmt.setString(6, account.getAddress());
            myStmt.setDate(7, account.getBirthDate());
            myStmt.setString(8, account.getTelephoneNumber());
            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

    public boolean update(CustomerAccount account) {

        try {

            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement(/*"SELECT * FROM customeraccount WHERE idCustomerAccount=" +account.getIdAccount() +"; "
                                                                                            + */"UPDATE customeraccount "
                    + "SET email=?, "
                    + "password=?, "
                    + "ageCategory=?, "
                    + "firstName=?, "
                    + "lastName=?, "
                    + "address=?, "
                    + "birthDate=?, "
                    + "telephoneNumber=? "
                    + "WHERE idCustomerAccount=?");
            myStmt.setString(1, account.getEmail());
            myStmt.setString(2, account.getPassword());
            myStmt.setString(3, account.getAgeCategory());
            myStmt.setString(4, account.getFirstName());
            myStmt.setString(5, account.getLastName());
            myStmt.setString(6, account.getAddress());
            myStmt.setDate(7, account.getBirthDate());
            myStmt.setString(8, account.getTelephoneNumber());
            myStmt.setInt(9, account.getIdAccount());
            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

}
