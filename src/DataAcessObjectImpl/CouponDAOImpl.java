package DataAcessObjectImpl;

import DataAcessObject.CouponDAO;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Coupon;

public class CouponDAOImpl implements CouponDAO {

    @Override
    public Coupon find(int idCoupon) {

        Coupon coupon = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where idcoupon=" + idCoupon + ";");

            if (myRs.first()) {

                coupon = new Coupon(idCoupon, myRs.getString("couponCode"), myRs.getBigDecimal("discount"));

                return coupon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<Coupon> findAllCoupons() {

        ArrayList<Coupon> coupons = new ArrayList();

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM coupon;");

            while (myRs.next()) {
                coupons.add(new Coupon(myRs.getInt("idcoupon"), myRs.getString("couponCode"), myRs.getBigDecimal("discount")));
            }
            return coupons;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return coupons;
        }
    }

    @Override
    public boolean delete(String code) {

        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM coupon WHERE couponCode='" + code + "';");
            myStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public Coupon findByDiscount(BigDecimal discount) {

        Coupon coupon = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where discount=" + discount + ";");

            if (myRs.first()) {
                coupon = new Coupon(myRs.getInt("idcoupon"), myRs.getString("couponCode"), discount);
                return coupon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public boolean checkCode(String code) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where couponCode='" + code + "';");

            if (myRs.first()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Coupon findByCode(String code) {

        Coupon coupon = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where couponCode='" + code + "';");

            if (myRs.first()) {
                coupon = new Coupon(myRs.getInt("idcoupon"), code, myRs.getBigDecimal("discount"));
                return coupon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;

    }

    @Override
    public boolean add(String code, BigDecimal discount) {

        try {
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `coupon` (`couponCode`, `discount`) VALUES (?, ?);");
            myPrepStmt.setString(1, code);
            myPrepStmt.setBigDecimal(2, discount);

            myPrepStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
