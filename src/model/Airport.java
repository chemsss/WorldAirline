package model;

public class Airport {

    private char[] idAirport; //id airport 
    private String nameAirport;//airport name
    private String city; //city airport
    private String country; //country

    public Airport(char[] idAirport, String nameAirport, String city, String country) {
        this.idAirport = idAirport;
        this.nameAirport = nameAirport;
        this.city = city;
        this.country = country;
    }

    public char[] getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(char[] idAirport) {
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
