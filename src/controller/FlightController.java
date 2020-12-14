package controller;

import DataAcessObjectImpl.FlightDAOImpl;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.Flight;
import Exceptions.EmptyFields;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class FlightController {

    public FlightController() {

    }

    public static Flight getFlight(int idFlight) {

        return new FlightDAOImpl().find(idFlight);

    }

    public static void updateFlight(int idFlight, int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {

        if (new FlightDAOImpl().update(idFlight, idAirplane, airlineName, idDepartureAirport, idArrivalAirport, departureDate, arrivalDate) == false) {
            JOptionPane.showMessageDialog(null, "unable to update flight");
        }

    }

    public static void addFlight(int idAirplane, String airlineName, String idDepartureAirport, String idArrivalAirport, Timestamp departureDate, Timestamp arrivalDate) {

        if (new FlightDAOImpl().add(idAirplane, airlineName, idDepartureAirport, idArrivalAirport, departureDate, arrivalDate) == false) {
            JOptionPane.showMessageDialog(null, "unable to add flight");
        }

    }

    public static boolean CheckFlightInfo(Date dateDeparture, Date dateArrival, String airline) {
        try {
            if ((dateDeparture == null) && (dateArrival == null) || (dateDeparture == null) && (dateArrival != null) || (dateArrival == null) && (dateDeparture != null) || (airline.isEmpty())) {

                throw new EmptyFields();

            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static void deleteFlight(int idFlight) {
        new FlightDAOImpl().delete(idFlight);
        JOptionPane.showMessageDialog(null, "The seat has been deleted");
    }

    public static boolean checkFlight(String idFlight) {

        try {

            int intIdFlight = Integer.parseInt(idFlight);

            if (new FlightDAOImpl().find(intIdFlight) == null) {
                JOptionPane.showMessageDialog(null, "There is no flight with this Id");
                return false;

            } else {
                return true;

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static ArrayList<Flight> getAllFlights() {

        return new FlightDAOImpl().findAllFlights();

    }

    public static boolean checkFlightSeat(String numberSeats, String seatPrice) {
        try {

            int intNumberSeats = Integer.parseInt(numberSeats);
            BigDecimal bigDecimalSeatPrice = new BigDecimal(seatPrice);

            return true;

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

}
