package model;

public class Airport {

    private String idAirport; //id airport 
    private String nameAirport;//airport name
    private String city; //city airport
    private String country; //country

    public Airport(String idAirport, String nameAirport, String city, String country) {
        this.idAirport = idAirport;
        this.nameAirport = nameAirport;
        this.city = city;
        this.country = country;
    }

    public String getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }

    public String getNameAirport() {
        return nameAirport;
    }

    public void setNameAirport(String nameAirport) {
        this.nameAirport = nameAirport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
