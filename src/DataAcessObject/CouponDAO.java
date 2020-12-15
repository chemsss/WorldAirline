package DataAcessObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import model.Coupon;

public interface CouponDAO {

    public Coupon find(int idCoupon);

    public ArrayList<Coupon> findAllCoupons();

    public boolean delete(String code);

    public Coupon findByDiscount(BigDecimal discount);

    public boolean checkCode(String code);

    public Coupon findByCode(String code);

    public boolean add(String code, BigDecimal discount);

}
