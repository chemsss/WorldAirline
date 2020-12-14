package model;

import java.math.BigDecimal;

public class Coupon {
    
    private int idCoupon;
    private String couponCode;
     private BigDecimal discount;

    public Coupon(int idCoupon, String couponCode, BigDecimal discount) {
        this.idCoupon = idCoupon;
        this.couponCode = couponCode;
        this.discount = discount;
    }

    public int getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Coupon{" + "idCoupon=" + idCoupon + ", couponCode=" + couponCode + ", discount=" + discount + "€}'";
    }
    
    
    
}
