package model.TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Coupon;

public class SearchCouponsTableModel extends AbstractTableModel{
    private final String[] Titles = {"IdCoupon", "CouponCode", "Discount"};
     
     private  ArrayList<Coupon> Coupons;

    public SearchCouponsTableModel(ArrayList<Coupon> Coupons) {
        this.Coupons = Coupons;
    }
     
    @Override
    public int getColumnCount() {
        return Titles.length;
    }

    @Override
    public int getRowCount() {
        return Coupons.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return Titles[column];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return Coupons.get(row).getIdCoupon();
            case 1:
                return Coupons.get(row).getCouponCode();
            case 2:
                return Coupons.get(row).getDiscount();
           
            default:
                return "";
        }
    }
    
}
