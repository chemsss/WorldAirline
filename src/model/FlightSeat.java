package model;
import java.math.BigDecimal;


public class FlightSeat {
    
    private int seatNo; // seat number
    private String className;//name class
    private BigDecimal seatPrice;// seat price
    private boolean isAvailable; // availability of the seat

    public FlightSeat(int seatNo, String className, BigDecimal seatPrice,boolean isAvailable) {
        this.seatNo = seatNo;
        this.className = className;
        this.seatPrice = seatPrice;
        this.isAvailable=isAvailable;
        
    }
    public FlightSeat()
    {
        
    }

    
    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BigDecimal getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(BigDecimal seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
}
