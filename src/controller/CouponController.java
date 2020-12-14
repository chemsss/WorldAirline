package controller;

import DataAcessObjectImpl.CouponDAOImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Coupon;

public class CouponController {

    public CouponController() {
    }

    public static void addCoupon(String code, float discount) {
        new CouponDAOImpl().add(code, discount);

        JOptionPane.showMessageDialog(null, "The Coupon has been added");
    }

    public static ArrayList<Coupon> findAllCoupons() {

        return new CouponDAOImpl().findAllCoupons();

    }

    public static void deleteCoupon(String Code) {
        new CouponDAOImpl().delete(Code);
    }

    public static boolean checkCoupon(String idCoupon) {
        try {

            int intIdCoupon = Integer.parseInt(idCoupon);
            if (new CouponDAOImpl().find(intIdCoupon) == null) {
                JOptionPane.showMessageDialog(null, "There is no Coupon with this Id");

                return false;
            }
            else{
                return true;
            }
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static Coupon getCoupon(int idCoupon) {
        return new CouponDAOImpl().find(idCoupon);
    }
    
    public static boolean checkCouponAmount(String CouponAmount) {
        try {

            BigDecimal bigDecimalCouponAmount = new BigDecimal(CouponAmount);
            return true;
          
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
