package test;

import controller.AirplaneController;
import controller.AirportController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Flight;
import controller.FlightController;
import controller.FlightSeatsController;
import controller.SearchFlightSeatsTableModel;
import java.math.BigDecimal;
import java.sql.Timestamp;
import model.Airplane;
import model.Airport;
import model.FlightSeat;

public class EmployeeManageFlight extends JPanel {

    private javax.swing.JLabel idFlight;
    private javax.swing.JButton search;
    private javax.swing.JTextField textidFlight;
    private javax.swing.JLabel title;
    private Flight flight;

    private javax.swing.JLabel airplane;
    private javax.swing.JLabel arrivalAirport;
    private javax.swing.JLabel arrivalDate;
    private javax.swing.JComboBox choiceAirplane;
    private javax.swing.JComboBox choiceArrivalAirport;
    private com.toedter.calendar.JDateChooser choiceArrivalDate;
    private javax.swing.JComboBox choiceDepartureAirport;
    private com.toedter.calendar.JDateChooser choiceDepartureDate;
    private javax.swing.JLabel departureAirport;
    private javax.swing.JLabel departureDate;
    private javax.swing.JComboBox selectMinutesDeparture;
    private javax.swing.JComboBox selectMinutesArrival;
    private javax.swing.JComboBox selectHourlyDeparture;
    private javax.swing.JComboBox selectHourlyArrival;
    private javax.swing.JLabel hourlyArrivalLabel;
    private javax.swing.JLabel hourlyDepartureLabel;
    private javax.swing.JLabel airline;
    private javax.swing.JTextField airlineField;
    private javax.swing.JTable tableSeat;
    private javax.swing.JScrollPane seatScrollPane;
    private javax.swing.JButton updateFlight, deleteFlight, addSeat, deleteSeat;
    private javax.swing.JLabel flightSeatsLabel;
    final Airport[] tab = AirportController.getAllAirports();
    final Airplane[] tab1 = AirplaneController.getAllAirports();
    private ArrayList<FlightSeat> flightSeats;

    private javax.swing.JPanel center;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeManageFlight() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));

    }

    private void initComponents() {

        flight = null;
        title = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        textidFlight = new javax.swing.JTextField();
        idFlight = new javax.swing.JLabel();

        choiceArrivalAirport = new javax.swing.JComboBox();
        arrivalAirport = new javax.swing.JLabel();
        departureAirport = new javax.swing.JLabel();
        choiceDepartureAirport = new javax.swing.JComboBox();
        choiceAirplane = new javax.swing.JComboBox();
        airplane = new javax.swing.JLabel();
        arrivalDate = new javax.swing.JLabel();
        choiceArrivalDate = new com.toedter.calendar.JDateChooser();
        choiceDepartureDate = new com.toedter.calendar.JDateChooser();
        departureDate = new javax.swing.JLabel();
        selectMinutesDeparture = new javax.swing.JComboBox();
        selectMinutesArrival = new javax.swing.JComboBox();
        selectHourlyDeparture = new javax.swing.JComboBox();
        selectHourlyArrival = new javax.swing.JComboBox();
        hourlyArrivalLabel = new javax.swing.JLabel();
        hourlyDepartureLabel = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        airline = new javax.swing.JLabel();
        airlineField = new javax.swing.JTextField();
        choiceDepartureAirport = new javax.swing.JComboBox();
        choiceArrivalAirport = new javax.swing.JComboBox();
        tableSeat = new javax.swing.JTable();
        seatScrollPane = new javax.swing.JScrollPane();
        updateFlight = new javax.swing.JButton();
        deleteFlight = new javax.swing.JButton();
        addSeat = new javax.swing.JButton();
        deleteSeat = new javax.swing.JButton();
        flightSeatsLabel = new javax.swing.JLabel();
        flightSeats = new ArrayList<>();
        setBackground(new java.awt.Color(55, 112, 155));
        center.setBackground(new java.awt.Color(55, 112, 155));
        center.setLayout(null);

        setLayout(null);

        title.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        title.setText("Manage flight");
        add(title);
        title.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        search.setBorderPainted(false);
        search.setBounds(570, 122, 90, 30);

        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!textidFlight.getText().isEmpty()) {

                    if (FlightController.checkFlight(Integer.parseInt(textidFlight.getText()))) {
                        flight = FlightController.getFlight(Integer.parseInt(textidFlight.getText()));

                        ArrayList<Flight> flight = new ArrayList();

                        flight.add(FlightController.getFlight(Integer.parseInt(textidFlight.getText())));

                        choiceDepartureDate.setDate(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getDepartureDate());
                        choiceArrivalDate.setDate(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getArrivalDate());
                        airlineField.setText(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getAirlineName());
                        selectHourlyDeparture.setSelectedItem(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getDepartureHourTimeToString());
                        selectMinutesDeparture.setSelectedItem(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getDepartureMinTimeToString());
                        selectHourlyArrival.setSelectedItem(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getArrivalHourTimeToString());
                        selectMinutesArrival.setSelectedItem(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getArrivalMinTimeToString());

                        for (int i = 0; i < tab.length; i++) {
                            if (tab[i].getNameAirport().equals(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getDepartureAirport().getNameAirport())) {
                                choiceDepartureAirport.setSelectedIndex(i);
                            }
                            if (tab[i].getNameAirport().equals(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getArrivalAirport().getNameAirport())) {
                                choiceArrivalAirport.setSelectedIndex(i);
                            }
                        }

                        for (int j = 0; j < tab1.length; j++) {
                            if (tab1[j].getModel().equals(FlightController.getFlight(Integer.parseInt(textidFlight.getText())).getAirplane().getModel())) {
                                choiceAirplane.setSelectedIndex(j);
                            }
                        }
                        flightSeats = FlightSeatsController.getFlightSeats(Integer.parseInt(textidFlight.getText()));
                        SearchFlightSeatsTableModel model = new SearchFlightSeatsTableModel(flightSeats);
                        tableSeat.setModel(model);

                    } else { //refresh values
                        choiceDepartureDate.setCalendar(null);
                        choiceArrivalDate.setCalendar(null);

                        selectMinutesDeparture.setSelectedIndex(0);
                        selectMinutesArrival.setSelectedIndex(0);
                        selectHourlyDeparture.setSelectedIndex(0);
                        selectHourlyArrival.setSelectedIndex(0);
                        airlineField.setText("");
                        choiceArrivalAirport.setSelectedIndex(1);
                        choiceAirplane.setSelectedIndex(0);
                        choiceDepartureAirport.setSelectedIndex(1);
                        flight = null;

                        flightSeats = new ArrayList();
                        SearchFlightSeatsTableModel model = new SearchFlightSeatsTableModel(flightSeats);
                        tableSeat.setModel(model);
                    }

                } else {

                    choiceDepartureDate.setCalendar(null);
                    choiceArrivalDate.setCalendar(null);

                    selectMinutesDeparture.setSelectedIndex(0);
                    selectMinutesArrival.setSelectedIndex(0);
                    selectHourlyDeparture.setSelectedIndex(0);
                    selectHourlyArrival.setSelectedIndex(0);
                    airlineField.setText("");
                    choiceArrivalAirport.setSelectedIndex(1);
                    choiceAirplane.setSelectedIndex(0);
                    choiceDepartureAirport.setSelectedIndex(1);

                    flightSeats = new ArrayList();
                    flight = null;

                    SearchFlightSeatsTableModel model = new SearchFlightSeatsTableModel(flightSeats);
                    tableSeat.setModel(model);
                }
            }
        });
        add(search);

        textidFlight.setText("");
        textidFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        add(textidFlight);
        textidFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        textidFlight.setBounds(388, 120, 160, 32);

        idFlight.setFont(new java.awt.Font("Yu Gothic UI light", 0, 20)); // NOI18N
        idFlight.setForeground(new java.awt.Color(255, 255, 255));
        idFlight.setText("Enter the flight Id: ");
        add(idFlight);
        idFlight.setBounds(200, 120, 300, 30);

        airline.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        airline.setForeground(new java.awt.Color(255, 255, 255));
        airline.setText("Airline:");
        center.add(airline);
        airline.setBounds(50, 310, 110, 40);
        choiceDepartureAirport.setBounds(240, 440, 160, 30);
        choiceArrivalAirport.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        center.add(choiceArrivalAirport);
       // choiceArrivalAirport.setBounds(240, 500, 160, 30);
        choiceArrivalAirport.setBounds(240, 440, 160, 30);

        airlineField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        airlineField.setText("");
        airlineField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        center.add(airlineField);

        center.add(airlineField);
        airlineField.setBounds(240, 320, 160, 32);

        arrivalAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        arrivalAirport.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAirport.setText("Arrival Airport:");
        center.add(arrivalAirport);
     //   arrivalAirport.setBounds(50, 510, 170, 25);
        arrivalAirport.setBounds(50, 440, 200, 30);

        departureAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        departureAirport.setForeground(new java.awt.Color(255, 255, 255));
        departureAirport.setText("Departure Airport:");
        center.add(departureAirport);
       // departureAirport.setBounds(50, 440, 200, 30);
        departureAirport.setBounds(50, 370, 160, 40);


        choiceDepartureAirport.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        center.add(choiceDepartureAirport);
   //     choiceDepartureAirport.setBounds(240, 440, 160, 30);
          choiceDepartureAirport.setBounds(240, 380, 160, 30);


        choiceAirplane.setModel(new DefaultComboBoxModel(AirplaneController.getAllAirports()));
        center.add(choiceAirplane);
        choiceAirplane.setBounds(240, 380, 160, 30);
        choiceAirplane.setVisible(false);

        airplane.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        airplane.setForeground(new java.awt.Color(255, 255, 255));
        airplane.setText("Airplane:");
        center.add(airplane);
        airplane.setBounds(50, 370, 110, 40);
        airplane.setVisible(false);

        arrivalDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        arrivalDate.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDate.setText("Arrival Date:");
        center.add(arrivalDate);
        arrivalDate.setBounds(50, 200, 160, 30);
        center.add(choiceArrivalDate);
        choiceArrivalDate.setBounds(240, 200, 160, 30);
        center.add(choiceDepartureDate);
        choiceDepartureDate.setBounds(240, 100, 160, 30);

        departureDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        departureDate.setForeground(new java.awt.Color(255, 255, 255));
        departureDate.setText("Departure Date:");
        center.add(departureDate);
        departureDate.setBounds(50, 100, 140, 25);

        selectMinutesDeparture.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        center.add(selectMinutesDeparture);
        selectMinutesDeparture.setBounds(340, 140, 60, 30);

        selectMinutesArrival.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        center.add(selectMinutesArrival);
        selectMinutesArrival.setBounds(340, 240, 60, 30);

        selectHourlyDeparture.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        center.add(selectHourlyDeparture);
        selectHourlyDeparture.setBounds(240, 140, 60, 30);

        selectHourlyArrival.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        center.add(selectHourlyArrival);
        selectHourlyArrival.setBounds(240, 240, 60, 30);

        hourlyArrivalLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hourlyArrivalLabel.setForeground(new java.awt.Color(255, 255, 255));
        hourlyArrivalLabel.setText("H");
        center.add(hourlyArrivalLabel);
        hourlyArrivalLabel.setBounds(315, 238, 20, 30);

        hourlyDepartureLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hourlyDepartureLabel.setForeground(new java.awt.Color(255, 255, 255));
        hourlyDepartureLabel.setText("H");
        center.add(hourlyDepartureLabel);
        hourlyDepartureLabel.setBounds(315, 148, 10, 16);

        updateFlight.setBackground(new java.awt.Color(255, 255, 255));
        updateFlight.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        updateFlight.setText("Update Flight");
        updateFlight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        updateFlight.setBorderPainted(false);
        updateFlight.setBounds(50, 530, 90, 30);

        updateFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (FlightController.CheckFlightInfo(choiceDepartureDate.getDate(), choiceArrivalDate.getDate(), airlineField.getText())) {
                    Timestamp dateDeparture = new Timestamp(choiceDepartureDate.getDate().getYear(), choiceDepartureDate.getDate().getMonth(),
                            choiceDepartureDate.getDate().getDay(), Integer.parseInt(selectHourlyDeparture.getSelectedItem().toString()), Integer.parseInt(selectMinutesDeparture.getSelectedItem().toString()), 0, 0);

                    Timestamp dateArrival = new Timestamp(choiceArrivalDate.getDate().getYear(), choiceArrivalDate.getDate().getMonth(),
                            choiceArrivalDate.getDate().getDay(), Integer.parseInt(selectHourlyArrival.getSelectedItem().toString()), Integer.parseInt(selectMinutesArrival.getSelectedItem().toString()), 0, 0);

                    FlightController.updateFlight(Integer.parseInt(textidFlight.getText()), ((Airplane) choiceAirplane.getSelectedItem()).getIdAirplane(), airlineField.getText(),
                            ((Airport) choiceDepartureAirport.getSelectedItem()).getIdAirport(), ((Airport) choiceArrivalAirport.getSelectedItem()).getIdAirport(), dateDeparture, dateArrival);

                    JOptionPane.showMessageDialog(null, "Update Successfully");
                }

            }
        });
        center.add(updateFlight);

        deleteFlight.setBackground(new java.awt.Color(255, 255, 255));
        deleteFlight.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        deleteFlight.setText("Delete Flight");
        deleteFlight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        deleteFlight.setBorderPainted(false);
        deleteFlight.setBounds(312, 530, 90, 30);

        deleteFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (flight != null) {
                    Timestamp dateDeparture = new Timestamp(choiceDepartureDate.getDate().getYear(), choiceDepartureDate.getDate().getMonth(),
                            choiceDepartureDate.getDate().getDay(), Integer.parseInt(selectHourlyDeparture.getSelectedItem().toString()), Integer.parseInt(selectMinutesDeparture.getSelectedItem().toString()), 0, 0);

                    Timestamp dateArrival = new Timestamp(choiceArrivalDate.getDate().getYear(), choiceArrivalDate.getDate().getMonth(),
                            choiceArrivalDate.getDate().getDay(), Integer.parseInt(selectHourlyArrival.getSelectedItem().toString()), Integer.parseInt(selectMinutesArrival.getSelectedItem().toString()), 0, 0);

                    FlightController.updateFlight(Integer.parseInt(textidFlight.getText()), ((Airplane) choiceAirplane.getSelectedItem()).getIdAirplane(), airlineField.getText(),
                            ((Airport) choiceDepartureAirport.getSelectedItem()).getIdAirport(), ((Airport) choiceArrivalAirport.getSelectedItem()).getIdAirport(), dateDeparture, dateArrival);

                    FlightController.deleteFlight(Integer.parseInt(textidFlight.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flight selected");

                }

            }
        });
        center.add(deleteFlight);

        addSeat.setBackground(new java.awt.Color(255, 255, 255));
        addSeat.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        addSeat.setText("Add Seat");
        addSeat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        addSeat.setBorderPainted(false);
        addSeat.setBounds(1140, 180, 90, 30);

        addSeat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!tableSeat.getSelectionModel().isSelectionEmpty()) //If we select a seat
                {
                    new EmployeeAddSeat(Integer.parseInt(textidFlight.getText()));

                }

            }
        });
        center.add(addSeat);

        deleteSeat.setBackground(new java.awt.Color(255, 255, 255));
        deleteSeat.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        deleteSeat.setText("Delete Seat");
        deleteSeat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        deleteSeat.setBorderPainted(false);
        deleteSeat.setBounds(1140, 370, 90, 30);

        deleteSeat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (flight != null) {

                    String stringSeatNumber = tableSeat.getValueAt(tableSeat.getSelectedRow(), 0).toString();
                    int seatNumber = Integer.parseInt(stringSeatNumber);

                    String className = tableSeat.getValueAt(tableSeat.getSelectedRow(), 1).toString();
                    String stringseatPrice = tableSeat.getValueAt(tableSeat.getSelectedRow(), 2).toString();
                    BigDecimal seatPrice = new BigDecimal(stringseatPrice);

                    boolean isAvailable;
                    String stringIsAvailable = tableSeat.getValueAt(tableSeat.getSelectedRow(), 3).toString();
                    if (stringIsAvailable.equals("Yes")) {
                        isAvailable = true;
                    } else {
                        isAvailable = false;
                    }

                    FlightSeat flightSeat = new FlightSeat(seatNumber, className, seatPrice, isAvailable);
                    FlightSeatsController.deleteFlightSeat(flightSeat);

                } else {
                    JOptionPane.showMessageDialog(null, "No Flight selected");

                }

            }
        });
        center.add(deleteSeat);
        choiceArrivalAirport.setSelectedIndex(5);
        choiceDepartureAirport.setSelectedIndex(1);

        flightSeatsLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        flightSeatsLabel.setForeground(new java.awt.Color(255, 255, 255));
        flightSeatsLabel.setText("Flight's Seats");
        center.add(flightSeatsLabel);
        flightSeatsLabel.setBounds(740, 70, 160, 30);
        SearchFlightSeatsTableModel model = new SearchFlightSeatsTableModel(flightSeats);
        tableSeat.setModel(model);

        tableSeat.setRowHeight(20);
        tableSeat.setToolTipText("");
        tableSeat.setSelectionBackground(new java.awt.Color(0, 204, 0));
        tableSeat.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSeat.setShowGrid(true);
        tableSeat.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));

        seatScrollPane.setViewportView(tableSeat);
        center.add(seatScrollPane);
        seatScrollPane.setBounds(500, 100, 590, 360);

        add(center);
        center.setBounds(150, 120, screenWidth - 150, screenHeight - 120);


    }

}
