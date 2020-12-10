/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chems
 */
public class Coupon {
    
    private int idCoupon;
    private String couponCode;
    private float discount;

    public Coupon(int idCoupon, String couponCode, float discount) {
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Coupon{" + "idCoupon=" + idCoupon + ", couponCode=" + couponCode + ", discount=" + discount + "€}'";
    }
    
    
    
}
