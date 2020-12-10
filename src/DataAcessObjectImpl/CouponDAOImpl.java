/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Coupon;

/**
 *
 * @author Chems
 */
public class CouponDAOImpl {
    
    
    public Coupon find(int idCoupon) {
        
        Coupon coupon = null; 

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where idcoupon=" + idCoupon + ";");

            if (myRs.first()) {
                coupon = new Coupon(idCoupon, myRs.getString("couponCode"), myRs.getInt("discount"));
                return coupon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
        
    }
    
    
    public Coupon findByDiscount(float discount) {
        
        Coupon coupon = null; 

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where discount=" + new BigDecimal(discount) + ";");

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
    
    public boolean checkCode(String code) {
        
        Coupon coupon = null; 

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where couponCode='" + code + "';");

            if (myRs.first()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }
    
    
    public Coupon findByCode(String code) {
        
        Coupon coupon = null; 

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from coupon where couponCode='" + code + "';");

            if (myRs.first()) {
                coupon = new Coupon(myRs.getInt("idcoupon"), code, myRs.getBigDecimal("discount").floatValue());
                return coupon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
        
    }
    
    
    public boolean add(String code, int idAccount) {
        
        try {
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `coupon` (`couponCode`, `discount`) VALUES (?, ?);");
            myPrepStmt.setString(1, code);
            myPrepStmt.setInt(2, idAccount);
            
            myPrepStmt.executeUpdate();
            
            return true;
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}
