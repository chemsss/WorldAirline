package view.Employee;

import controller.AirplaneController;
import controller.AirportController;
import controller.FlightController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Timestamp;
import javax.swing.DefaultComboBoxModel;
import model.Airplane;
import model.Airport;

public class EmployeeAddFlight extends javax.swing.JPanel {

    private javax.swing.JButton add;
    private javax.swing.JLabel addAflight;
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
    private javax.swing.JLabel nbrSeatsBusiness;
    private javax.swing.JLabel nbrSeatsEco;
    private javax.swing.JLabel numberSeatsFrst;
    private javax.swing.JLabel priceFirst;
    private javax.swing.JLabel priceSeatBusiness;
    private javax.swing.JLabel priceSeatEco;
    private javax.swing.JTextField textNbrSeatFirst;
    private javax.swing.JTextField textnbrSeatsBusiness;
    private javax.swing.JTextField textpriceSeatBusiness;
    private javax.swing.JTextField textNbreSeatEco;
    private javax.swing.JTextField textPriceSeatFirst;
    private javax.swing.JTextField textPriceSeatsEco;
    private javax.swing.JLabel airline;
    private javax.swing.JTextField airlineField;

    private javax.swing.JPanel center;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeAddFlight() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));
    }

    private void initComponents() {

        textPriceSeatsEco = new javax.swing.JTextField();
        addAflight = new javax.swing.JLabel();
        nbrSeatsEco = new javax.swing.JLabel();
        priceSeatEco = new javax.swing.JLabel();
        textNbreSeatEco = new javax.swing.JTextField();
        textnbrSeatsBusiness = new javax.swing.JTextField();
        textpriceSeatBusiness = new javax.swing.JTextField();
        nbrSeatsBusiness = new javax.swing.JLabel();
        priceSeatBusiness = new javax.swing.JLabel();
        numberSeatsFrst = new javax.swing.JLabel();
        priceFirst = new javax.swing.JLabel();
        textPriceSeatFirst = new javax.swing.JTextField();
        textNbrSeatFirst = new javax.swing.JTextField();
        add = new javax.swing.JButton();
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


        setBackground(new java.awt.Color(55, 112, 155));
        center.setBackground(new java.awt.Color(55, 112, 155));
        setLayout(null);

        addAflight.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        addAflight.setForeground(new java.awt.Color(255, 255, 255));
        addAflight.setText("Add a flight:");
        add(addAflight);
        addAflight.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        center.setLayout(null);

        nbrSeatsEco.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        nbrSeatsEco.setForeground(new java.awt.Color(255, 255, 255));
        nbrSeatsEco.setText("Number of Seats (Economy Class):");
        center.add(nbrSeatsEco);
        nbrSeatsEco.setBounds(530, 100, 310, 25);

        priceSeatEco.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        priceSeatEco.setForeground(new java.awt.Color(255, 255, 255));
        priceSeatEco.setText("Seat Price :");
        center.add(priceSeatEco);
        priceSeatEco.setBounds(530, 130, 180, 30);

        nbrSeatsBusiness.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        nbrSeatsBusiness.setForeground(new java.awt.Color(255, 255, 255));
        nbrSeatsBusiness.setText("Number of Seats (Business Class):");
        center.add(nbrSeatsBusiness);
        nbrSeatsBusiness.setBounds(530, 220, 280, 25);

        priceSeatBusiness.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        priceSeatBusiness.setForeground(new java.awt.Color(255, 255, 255));
        priceSeatBusiness.setText("Seat Price :");
        center.add(priceSeatBusiness);
        priceSeatBusiness.setBounds(530, 250, 260, 25);

        numberSeatsFrst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        numberSeatsFrst.setForeground(new java.awt.Color(255, 255, 255));
        numberSeatsFrst.setText("Number of Seats (First Class):");
        center.add(numberSeatsFrst);
        numberSeatsFrst.setBounds(530, 340, 280, 25);

        priceFirst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N // NOI18N
        priceFirst.setForeground(new java.awt.Color(255, 255, 255));
        priceFirst.setText("Seat Price :");
        center.add(priceFirst);
        priceFirst.setBounds(530, 370, 260, 25);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        add.setBorderPainted(false);
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
/*
                if ((FlightController.CheckFlightInfo(choiceDepartureDate.getDate(), choiceArrivalDate.getDate(),airlineField.getText()))) {
                    Timestamp dateDeparture = new Timestamp(choiceDepartureDate.getDate().getYear(), choiceDepartureDate.getDate().getMonth(),
                            choiceDepartureDate.getDate().getDay(), Integer.parseInt(selectHourlyDeparture.getSelectedItem().toString()), Integer.parseInt(selectMinutesDeparture.getSelectedItem().toString()), 0, 0);

                    Timestamp dateArrival = new Timestamp(choiceArrivalDate.getDate().getYear(), choiceArrivalDate.getDate().getMonth(),
                            choiceArrivalDate.getDate().getDay(), Integer.parseInt(selectHourlyArrival.getSelectedItem().toString()), Integer.parseInt(selectMinutesArrival.getSelectedItem().toString()), 0, 0);
                    
                    FlightController.addFlight(((Airplane) choiceAirplane.getSelectedItem()).getIdAirplane(), airline.getText(), ((Airport) choiceDepartureAirport.getSelectedItem()).getIdAirport(), ((Airport) choiceArrivalAirport.getSelectedItem()).getIdAirport(), dateDeparture, dateArrival);
                }*/
            }

        });
        add(add);
        add.setBounds((screenWidth / 2) - 70, 650, 90, 30);
 
        airline.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        airline.setForeground(new java.awt.Color(255, 255, 255));
        airline.setText("Airline:");
        center.add(airline);
        airline.setBounds(50, 310, 110, 40);
        choiceArrivalAirport.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        center.add(choiceArrivalAirport);
        choiceArrivalAirport.setBounds(240, 500, 160, 30);

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
        arrivalAirport.setBounds(50, 510, 170, 25);

        departureAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        departureAirport.setForeground(new java.awt.Color(255, 255, 255));
        departureAirport.setText("Departure Airport:");
        center.add(departureAirport);
        departureAirport.setBounds(50, 440, 200, 30);

        choiceDepartureAirport.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        center.add(choiceDepartureAirport);
        choiceDepartureAirport.setBounds(240, 440, 160, 30);

        choiceAirplane.setModel(new DefaultComboBoxModel(AirplaneController.getAllAirplanes()));
        center.add(choiceAirplane);
        choiceAirplane.setBounds(240, 380, 160, 30);

        airplane.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        airplane.setForeground(new java.awt.Color(255, 255, 255));
        airplane.setText("Airplane:");
        center.add(airplane);
        airplane.setBounds(50, 370, 110, 40);

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

        selectMinutesDeparture.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        center.add(selectMinutesDeparture);
        selectMinutesDeparture.setBounds(340, 140, 60, 30);

        selectMinutesArrival.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        center.add(selectMinutesArrival);
        selectMinutesArrival.setBounds(340, 240, 60, 30);

        selectHourlyDeparture.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        center.add(selectHourlyDeparture);
        selectHourlyDeparture.setBounds(240, 140, 60, 30);

        selectHourlyArrival.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
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

        textNbreSeatEco.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textNbreSeatEco.setText("");
        center.add(textNbreSeatEco);
        textNbreSeatEco.setBounds(830, 90, 150, 32);

        textPriceSeatsEco.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textPriceSeatsEco.setText("");
        center.add(textPriceSeatsEco);
        textPriceSeatsEco.setBounds(830, 130, 150, 32);

        textnbrSeatsBusiness.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textnbrSeatsBusiness.setText("");
        center.add(textnbrSeatsBusiness);
        textnbrSeatsBusiness.setBounds(830, 210, 150, 32);

        textpriceSeatBusiness.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textpriceSeatBusiness.setText("");
        center.add(textpriceSeatBusiness);
        textpriceSeatBusiness.setBounds(830, 250, 150, 32);

        textNbrSeatFirst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textNbrSeatFirst.setText("");
        center.add(textNbrSeatFirst);
        textNbrSeatFirst.setBounds(830, 330, 150, 32);

        textPriceSeatFirst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        textPriceSeatFirst.setText("");
        center.add(textPriceSeatFirst);
        textPriceSeatFirst.setBounds(830, 370, 150, 32);

        if(!(textNbreSeatEco.getText().isEmpty() || textPriceSeatsEco.getText().isEmpty() || textnbrSeatsBusiness.getText().isEmpty() || textpriceSeatBusiness.getText().isEmpty()|| textNbrSeatFirst.getText().isEmpty() || textPriceSeatFirst.getText().isEmpty()))
        {
            FlightController.checkFlightSeat(textNbreSeatEco.getText(), textPriceSeatsEco.getText());
            FlightController.checkFlightSeat(textnbrSeatsBusiness.getText(), textpriceSeatBusiness.getText());
            FlightController.checkFlightSeat(textNbrSeatFirst.getText(),textPriceSeatFirst.getText());
           
        }
        add(center);
        center.setBounds(200, 30, 1000, 1000);

    }
    
    

}
