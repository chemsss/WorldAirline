package model;

public class Airplane {

    private int idAirplane;// airplane id
    private String model; // airplane model
    private int seatCapacity;//airplane seat

    public Airplane(int idAirplane, String model, int seatCapacity) {
        this.idAirplane = idAirplane;
        this.model = model;
        this.seatCapacity = seatCapacity;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

}