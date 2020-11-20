package model;


public class FlightSeat {
    
    private int seatNo; // seat number
    private String className;//name class
    private float seatPrice;// seat price
    private boolean isAvailable; // availability of the seat

    public FlightSeat(int seatNo, String className, float seatPrice) {
        this.seatNo = seatNo;
        this.className = className;
        this.seatPrice = seatPrice;
        this.isAvailable = true;
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

    public float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
}
