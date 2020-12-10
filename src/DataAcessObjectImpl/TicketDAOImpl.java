/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectImpl;

import DataAcessObject.TicketDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import model.Airport;
import model.Flight;
import model.Passenger;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.*;

/**
 *
 * @author Unknow
 */
public class TicketDAOImpl implements TicketDAO {

    @Override
    public ArrayList<Ticket> findByBookingNo(int booking_bookingNo) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where booking_bookingNo=" + booking_bookingNo + ";");

            while (myRs.next()) {

                /*FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
                Flight flight = flightDAOImpl.find(myRs.getInt("flight_idFlight"));

                FlightSeatDAO flightSeatDAOImpl = new FlightSeatDAOImpl();
                ArrayList<FlightSeat> seats = flightSeatDAOImpl.findByIdFlight(myRs.getInt("flight_idFlight"));*/
                tickets.add(new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;

    }

    public ArrayList<Ticket> findByIdPassenger(int passenger_idPassenger) {

        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where passenger_idPassenger=" + passenger_idPassenger + ";");

            while (myRs.next()) {

                /*FlightDAOImpl flightDAOImpl = new FlightDAOImpl();
                Flight flight = flightDAOImpl.find(myRs.getInt("flight_idFlight"));

                FlightSeatDAO flightSeatDAOImpl = new FlightSeatDAOImpl();
                ArrayList<FlightSeat> seats = flightSeatDAOImpl.findByIdFlight(myRs.getInt("flight_idFlight"));*/
                tickets.add(new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight"))));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;

    }

  /*  public boolean add(int bookingNo, int idPassenger, int flightSeatNo, int idFlight) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ticket WHERE flight_idFlight=" + idFlight + " AND flightSeat_seatNo=" + flightSeatNo + ";");
            if (myRs.first()) {
                System.out.println("Ticket for the seat n°" + flightSeatNo + " in the flight n°" + idFlight + " already exists.");
                return false;
            }
            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO `ticket` (`booking_bookingNo`, `passenger_idPassenger`, `flightSeat_seatNo`, `flight_idFlight`) VALUES (?, ?, ?, ?);");
            myPrepStmt.setInt(1, bookingNo);
            myPrepStmt.setInt(2, idPassenger);
            myPrepStmt.setInt(3, flightSeatNo);
            myPrepStmt.setInt(4, idFlight);

            myPrepStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }*/
    
    public boolean add(int bookingNo, Passenger passenger, int flightSeatNo, int idFlight) {

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM ticket WHERE flight_idFlight=" + idFlight + " AND flightSeat_seatNo=" +flightSeatNo + ";");
            if(myRs.first()) {
                System.out.println(myRs.getInt("ticketNo"));
                System.out.println("Ticket for the seat n°" +flightSeatNo +" in the flight n°" +idFlight +" already exists.");
                return false;
            }

            PreparedStatement myPrepStmt = DatabaseConnection.getInstance().prepareStatement("INSERT INTO ticket (booking_bookingNo, passenger_idPassenger, flightSeat_seatNo, flight_idFlight) VALUES (?, ?, ?, ?);");
            myPrepStmt.setInt(1, bookingNo);
            int idPassenger = new PassengerDAOImpl().add(passenger);
            if(idPassenger == 0){
                myPrepStmt.setNull(2, Types.INTEGER);
            }
            else {
                myPrepStmt.setInt(2, idPassenger);
            }
            myPrepStmt.setInt(3, flightSeatNo);
            myPrepStmt.setInt(4, idFlight);

            myPrepStmt.executeUpdate();

            new FlightSeatDAOImpl().setSeatTaken(idFlight, flightSeatNo);

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public void inserImg(int ticketNo) {

        try {
            //créer la chaîne de connexion à la base de données
            Connection con = DatabaseConnection.getInstance();
            //objet pour créer la requête
            Statement st = con.createStatement();
            //l'image à insérer

            int length = 12;
           // String format = String.format("%0" + length + "d", ticketNo); // result 00015

            //Barcode barcode = BarcodeFactory.createEAN13(String.format("%0" + length + "d", ticketNo));
            Barcode barcode = BarcodeFactory.	createInt2of5(String.format("%0" + length + "d", ticketNo));

            barcode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14));
            // BufferedImage image = BarcodeImageHandler.getImage(barcode);
            File file = new File("img\\Tickets Barcodes\\" + ticketNo + ".png");
           
            if (!file.exists()) {
            BarcodeImageHandler.savePNG(barcode, file);

            FileInputStream input = new FileInputStream(file);

            //creation de la requête
            PreparedStatement ps
                    = con.prepareStatement("UPDATE Ticket SET barCodeImage = ? WHERE ticketNo = " + ticketNo);

            //image
            ps.setBinaryStream(1, (InputStream) input, (int) file.length());
            //exécution de la requête
            ps.executeUpdate();
            System.out.println("Image inserted with success!");
                        //fermer le preparedStatement
            }
            else
            {
                System.out.println("image already exists");
            }

            //fermer la connexion
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void getImg(int ticketNo) {
        try {
            //créer la chaîne de connexion à la base de données
            Connection con = DatabaseConnection.getInstance();
            //objet pour créer la requête
            Statement st = con.createStatement();
            //l'image à insérer

            ResultSet rs = st.executeQuery("SELECT barcodeImage FROM Ticket WHERE ticketNo=" + ticketNo);

            int i = 0;
            while (rs.next()) {

                InputStream input = rs.getBinaryStream(1);
                File outFile = new File("img\\Tickets Barcodes\\" + ticketNo + ".png");

                if (!outFile.exists()) {
                    OutputStream output = new FileOutputStream(outFile);
                    i++;
                    int b = 0;

                    while ((b = input.read()) > -1) {
                        output.write(b);
                    }
                    //fermer le OutputStream
                    output.close();
                    //fermer le InputStream
                    input.close();
                } else {
                    System.out.println("image already exists");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Ticket getTicket(int ticketNo) {

        Ticket ticket = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ticket where ticketNo=" + ticketNo + ";");

            while (myRs.next()) {

                ticket = new Ticket(myRs.getInt("TicketNo"), new FlightSeatDAOImpl().findByIdFlight(myRs.getInt("flight_idFlight")).get(myRs.getInt("flightSeat_seatNo") - 1), new FlightDAOImpl().find(myRs.getInt("flight_idFlight")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erzfe");
        }

        return ticket;
    }

    public Airport getDepartureAirport(int ticketNo) {

        Airport departureAirport = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select flight_idFlight from ticket where ticketNo=" + ticketNo + ";");

            while (myRs.next()) {
                departureAirport = new FlightDAOImpl().find((myRs.getInt("flight_idFlight"))).getDepartureAirport();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return departureAirport;

    }

    public Airport getArrivalAirport(int ticketNo) {

        Airport arrivalAirport = null;

        try {
            Statement myStmt = DatabaseConnection.getInstance().createStatement();
            ResultSet myRs = myStmt.executeQuery("select flight_idFlight from ticket where ticketNo=" + ticketNo + ";");

            while (myRs.next()) {
                arrivalAirport = new FlightDAOImpl().find((myRs.getInt("flight_idFlight"))).getArrivalAirport();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrivalAirport;

    }
    public void delete(int ticketNo) {

        try {
            PreparedStatement myStmt = DatabaseConnection.getInstance().prepareStatement("DELETE FROM ticket WHERE ticketNo=" + ticketNo + ";");
            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
