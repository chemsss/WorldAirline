package view.Customer;

import Exceptions.EmptyFields;
import com.toedter.calendar.JDateChooser;
import controller.FieldsController;
import controller.FlightController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import model.CustomerAccount;
import model.Flight;
import model.FlightSeat;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class PassengersInfosFrame extends javax.swing.JFrame {

    //Flight Details
    private javax.swing.JLabel flightDetails;
    private javax.swing.JPanel flightDetailsPanel;

    // For One Way
    private javax.swing.JLabel arrival;
    private javax.swing.JLabel arrivalAirport;
    private javax.swing.JLabel arrivalDateTime;
    private javax.swing.JLabel departure;
    private javax.swing.JLabel departureAirport;
    private javax.swing.JLabel departureDateTime;
    private javax.swing.JLabel from;
    private javax.swing.JLabel to;

    //For Round Trip
    private javax.swing.JLabel arrival2;
    private javax.swing.JLabel arrivalAirport2;
    private javax.swing.JLabel arrivalDateTime2;
    private javax.swing.JLabel departure2;
    private javax.swing.JLabel departureAirport2;
    private javax.swing.JLabel departureDateTime2;
    private javax.swing.JLabel from2;
    private javax.swing.JLabel to2;
    private JButton jButton1;

    //Passengers Details
    ArrayList<JLabel[]> labels = new ArrayList();
    ArrayList<JTextField[]> textFields = new ArrayList();
    ArrayList<JDateChooser> birthDates = new ArrayList();
    ArrayList<JComboBox<FlightSeat>> DepartAvailableSeatChoice = new ArrayList();
    ArrayList<JComboBox<FlightSeat>> ReturnAvailableSeatChoice = new ArrayList();
    private javax.swing.JScrollPane passengersScrollPane;
    private javax.swing.JPanel passengersPanel;

    //Selected flight(s)
    ArrayList<Flight> flights = new ArrayList();

    //Account Customer 
    private CustomerAccount loggedInCustomer;

    //Nber of passengers
    private int numberOfPassengers;

    //Class selected
    private String className;

    //payement JPanel
    JPanel payment;

    public PassengersInfosFrame(ArrayList<Flight> selectedFlight, int numberOfPassengers, String className) {
        super();
        this.loggedInCustomer = null;
        this.flights = selectedFlight;
        this.numberOfPassengers = numberOfPassengers;
        this.className = className;
        initComponents();
        this.setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
        //payment = new PaymentPanel(this);
    }

    public PassengersInfosFrame(ArrayList<Flight> selectedFlight, int numberOfPassengers, String className, CustomerAccount loggedInCustomer) {
        super();
        this.loggedInCustomer = loggedInCustomer;
        this.flights = selectedFlight;
        this.numberOfPassengers = numberOfPassengers;
        this.className = className;
        initComponents();
        this.setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
        //payment = new PaymentPanel(this);
    }

    private void initComponents() {

        flightDetailsPanel = new javax.swing.JPanel();
        flightDetails = new javax.swing.JLabel();
        passengersScrollPane = new javax.swing.JScrollPane();
        passengersPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        flightDetailsPanel.setBackground(new java.awt.Color(55, 112, 155));
        flightDetailsPanel.setLayout(null);

        flightDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        flightDetails.setText("Flight Details");
        flightDetails.setForeground(new java.awt.Color(255, 255, 255));
        flightDetailsPanel.add(flightDetails);
        flightDetails.setBounds(260, 0, 200, 40);

        //ONEWAY
        if (flights.size() == 1) {

            arrivalAirport = new javax.swing.JLabel();
            arrivalDateTime = new javax.swing.JLabel();
            arrival = new javax.swing.JLabel();
            to = new javax.swing.JLabel();
            departure = new javax.swing.JLabel();
            departureDateTime = new javax.swing.JLabel();
            from = new javax.swing.JLabel();
            departureAirport = new javax.swing.JLabel();

            arrivalAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            arrivalAirport.setForeground(new java.awt.Color(255, 255, 255));
            arrivalAirport.setText(flights.get(0).getArrivalAirport().getIdAirport());
            flightDetailsPanel.add(arrivalAirport);
            arrivalAirport.setBounds(440, 170, 150, 30);

            arrivalDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            arrivalDateTime.setForeground(new java.awt.Color(255, 255, 255));
            arrivalDateTime.setText(flights.get(0).getArrivalDateTimeToString());
            flightDetailsPanel.add(arrivalDateTime);
            arrivalDateTime.setBounds(90, 195, 130, 14);

            arrival.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            arrival.setForeground(new java.awt.Color(255, 255, 255));
            arrival.setIcon(new javax.swing.ImageIcon("img\\airplane_landing_40px.png")); // NOI18N
            arrival.setText("Arrival");
            flightDetailsPanel.add(arrival);
            arrival.setBounds(50, 170, 160, 30);

            to.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            to.setForeground(new java.awt.Color(255, 255, 255));
            to.setText("To");
            flightDetailsPanel.add(to);
            to.setBounds(310, 170, 50, 30);

            departure.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            departure.setForeground(new java.awt.Color(255, 255, 255));
            departure.setIcon(new javax.swing.ImageIcon("img\\airplane_take_off_40px.png")); // NOI18N
            departure.setText("Departure");
            flightDetailsPanel.add(departure);
            departure.setBounds(50, 100, 160, 30);

            departureDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            departureDateTime.setForeground(new java.awt.Color(255, 255, 255));
            departureDateTime.setText(flights.get(0).getDepartureDateTimeToString());
            flightDetailsPanel.add(departureDateTime);
            departureDateTime.setBounds(90, 125, 130, 14);

            from.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            from.setForeground(new java.awt.Color(255, 255, 255));
            from.setText("From");
            flightDetailsPanel.add(from);
            from.setBounds(310, 100, 50, 30);

            departureAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            departureAirport.setForeground(new java.awt.Color(255, 255, 255));
            departureAirport.setText((flights.get(0).getDepartureAirport().getIdAirport()));
            flightDetailsPanel.add(departureAirport);
            departureAirport.setBounds(440, 100, 150, 30);
            flightDetailsPanel.setBounds(0, 0, 630, 290);

        } else if (flights.size() == 2) {

            arrivalAirport2 = new javax.swing.JLabel();
            arrivalDateTime2 = new javax.swing.JLabel();
            arrival2 = new javax.swing.JLabel();
            to2 = new javax.swing.JLabel();
            departure2 = new javax.swing.JLabel();
            departureDateTime2 = new javax.swing.JLabel();
            from2 = new javax.swing.JLabel();
            departureAirport2 = new javax.swing.JLabel();

            arrivalAirport2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            arrivalAirport2.setForeground(new java.awt.Color(255, 255, 255));
            arrivalAirport2.setText(flights.get(1).getArrivalAirport().getIdAirport());
            flightDetailsPanel.add(arrivalAirport2);
            arrivalAirport2.setBounds(440, 250, 150, 30);

            arrivalDateTime2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            arrivalDateTime2.setForeground(new java.awt.Color(255, 255, 255));
            arrivalDateTime2.setText(flights.get(1).getArrivalDateTimeToString());
            flightDetailsPanel.add(arrivalDateTime2);
            arrivalDateTime2.setBounds(90, 265, 130, 14);

            arrival2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            arrival2.setForeground(new java.awt.Color(255, 255, 255));
            arrival2.setIcon(new javax.swing.ImageIcon("img\\airplane_landing_40px.png")); // NOI18N
            arrival2.setText("Arrival");
            flightDetailsPanel.add(arrival2);
            arrival2.setBounds(50, 240, 160, 30);

            to2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            to2.setForeground(new java.awt.Color(255, 255, 255));
            to2.setText("To");
            flightDetailsPanel.add(to2);
            to2.setBounds(310, 250, 50, 30);

            departure2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            departure2.setForeground(new java.awt.Color(255, 255, 255));
            departure2.setIcon(new javax.swing.ImageIcon("img\\airplane_take_off_40px.png")); // NOI18N
            departure2.setText("Departure");
            flightDetailsPanel.add(departure2);
            departure2.setBounds(50, 190, 160, 30);

            departureDateTime2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            departureDateTime2.setForeground(new java.awt.Color(255, 255, 255));
            departureDateTime2.setText(flights.get(1).getDepartureDateTimeToString());
            flightDetailsPanel.add(departureDateTime2);
            departureDateTime2.setBounds(90, 215, 130, 14);

            from2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            from2.setForeground(new java.awt.Color(255, 255, 255));
            from2.setText("From");
            flightDetailsPanel.add(from2);
            from2.setBounds(310, 190, 50, 30);

            departureAirport2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            departureAirport2.setForeground(new java.awt.Color(255, 255, 255));
            departureAirport2.setText((flights.get(1).getDepartureAirport().getIdAirport()));
            flightDetailsPanel.add(departureAirport2);
            departureAirport2.setBounds(440, 190, 150, 30);

            arrivalAirport = new javax.swing.JLabel();
            arrivalDateTime = new javax.swing.JLabel();
            arrival = new javax.swing.JLabel();
            to = new javax.swing.JLabel();
            departure = new javax.swing.JLabel();
            departureDateTime = new javax.swing.JLabel();
            from = new javax.swing.JLabel();
            departureAirport = new javax.swing.JLabel();

            arrivalAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            arrivalAirport.setForeground(new java.awt.Color(255, 255, 255));
            arrivalAirport.setText(flights.get(0).getArrivalAirport().getIdAirport());
            flightDetailsPanel.add(arrivalAirport);
            arrivalAirport.setBounds(440, 130, 150, 30);

            arrivalDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            arrivalDateTime.setForeground(new java.awt.Color(255, 255, 255));
            arrivalDateTime.setText(flights.get(0).getArrivalDateTimeToString());
            flightDetailsPanel.add(arrivalDateTime);
            arrivalDateTime.setBounds(90, 145, 130, 14);

            arrival.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            arrival.setForeground(new java.awt.Color(255, 255, 255));
            arrival.setIcon(new javax.swing.ImageIcon("img\\airplane_landing_40px.png")); // NOI18N
            arrival.setText("Arrival");
            flightDetailsPanel.add(arrival);
            arrival.setBounds(50, 120, 160, 30);

            to.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            to.setForeground(new java.awt.Color(255, 255, 255));
            to.setText("To");
            flightDetailsPanel.add(to);
            to.setBounds(310, 130, 50, 30);

            departure.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            departure.setForeground(new java.awt.Color(255, 255, 255));
            departure.setIcon(new javax.swing.ImageIcon("img\\airplane_take_off_40px.png")); // NOI18N
            departure.setText("Departure");
            flightDetailsPanel.add(departure);
            departure.setBounds(50, 70, 160, 30);

            departureDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
            departureDateTime.setForeground(new java.awt.Color(255, 255, 255));
            departureDateTime.setText(flights.get(0).getDepartureDateTimeToString());
            flightDetailsPanel.add(departureDateTime);
            departureDateTime.setBounds(90, 95, 130, 14);

            from.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            from.setForeground(new java.awt.Color(255, 255, 255));
            from.setText("From");
            flightDetailsPanel.add(from);
            from.setBounds(310, 70, 50, 30);

            departureAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            departureAirport.setForeground(new java.awt.Color(255, 255, 255));
            departureAirport.setText((flights.get(0).getDepartureAirport().getIdAirport()));
            flightDetailsPanel.add(departureAirport);
            departureAirport.setBounds(440, 70, 150, 30);

            flightDetailsPanel.setBounds(0, 0, 630, 300);
        }
        //STOP

        getContentPane().add(flightDetailsPanel);

        passengersPanel.setBackground(new java.awt.Color(255, 255, 255));
        passengersPanel.setForeground(new java.awt.Color(255, 255, 255));
        passengersPanel.setLayout(null);
        passengersPanel.setPreferredSize(new Dimension(100, 435 * numberOfPassengers));

        int y = 15;
        int y2 = 83;

        ArrayList<Integer> seatChoiceDepartBoundsY2 = new ArrayList();
        ArrayList<Integer> seatChoiceReturnBounds = new ArrayList();

        for (int i = 0; i < numberOfPassengers; i++) {

            JLabel[] label = new JLabel[9];
            JTextField[] text = new JTextField[7];

            for (int k = 0; k < 9; k++) {
                label[k] = new JLabel();
            }
            for (int k = 0; k < 7; k++) {
                text[k] = new JTextField();
            }
            JDateChooser birthDate = new JDateChooser();
            jButton1 = new JButton();

            label[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
            label[0].setText("Passenger " + (i + 1));
            label[0].setBounds(260, y, 130, 40);

            if (i == 0) {

                if (loggedInCustomer == null) {
                    //OK

                } else {
                    text[1].setText(loggedInCustomer.getFirstName());
                    text[1].setEditable(false);

                    text[2].setText(loggedInCustomer.getLastName());
                    text[2].setEditable(false);

                    birthDate.setDate(loggedInCustomer.getBirthDate());
                    birthDate.setEnabled(false);
                }
            }

            y += 70;
            label[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[1].setText("Email :");
            label[1].setBounds(30, y, 70, 20);

            y += 40;
            label[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[2].setText("First Name :");
            label[2].setBounds(30, y, 110, 20);

            y += 40;
            label[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[3].setText("Last Name :");
            label[3].setBounds(30, y, 110, 20);

            y += 40;
            label[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[4].setText("Address :");
            label[4].setBounds(30, y, 110, 20);

            y += 40;
            label[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[5].setText("Birth Date :");
            label[5].setBounds(30, y, 110, 20);

            y += 40;
            label[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[6].setText("Tel No :");
            label[6].setBounds(30, y, 110, 20);

            y += 40;
            label[7].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[7].setText("Nationality :");
            label[7].setBounds(30, y, 110, 25);

            y += 40;
            label[8].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
            label[8].setText("Passport No :");
            label[8].setBounds(30, y, 200, 25);

            y += 80;
            labels.add(label);
            birthDate.setOpaque(false);
            birthDates.add(birthDate);

            text[0].setBounds(195, y2, 130, 32);
            text[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[1].setBounds(195, y2, 130, 32);
            text[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[2].setBounds(195, y2, 130, 32);
            text[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            JComboBox<FlightSeat> seatChoice = new JComboBox();
            seatChoice.setModel(new DefaultComboBoxModel(FlightController.getAvailableSeats(flights.get(0).getIdFlight(), className)));
            seatChoice.setOpaque(false);
            seatChoice.setSelectedIndex(i);
            seatChoiceDepartBoundsY2.add(y2);
            DepartAvailableSeatChoice.add(seatChoice);
            
            JLabel labelSeatChoice = new JLabel("Depart Seat:");
            labelSeatChoice.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16));
            passengersPanel.add(labelSeatChoice);
            labelSeatChoice.setBounds(400, y2, 130, 32);
            

            y2 += 40;
            text[3].setBounds(195, y2, 130, 32);
            text[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            if (flights.size() == 2) {
                JComboBox<FlightSeat> seatChoice2 = new JComboBox();
                seatChoice2.setModel(new DefaultComboBoxModel(FlightController.getAvailableSeats(this.flights.get(0).getIdFlight(), className)));
                seatChoice2.setOpaque(false);
                seatChoice2.setSelectedIndex(i);
                seatChoiceReturnBounds.add(y2);
                ReturnAvailableSeatChoice.add(seatChoice2);
                
                JLabel labelSeatChoice2 = new JLabel("Return Seat:");
                labelSeatChoice2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16));
                passengersPanel.add(labelSeatChoice2);
                labelSeatChoice2.setBounds(400, y2, 130, 32);
            }

            y2 += 40;
            birthDate.setBounds(195, y2, 130, 32);

            y2 += 40;
            text[4].setBounds(195, y2, 130, 32);
            text[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[5].setBounds(195, y2, 130, 32);
            text[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[6].setBounds(195, y2, 130, 32);
            text[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            textFields.add(text);

            if (i == numberOfPassengers - 1) {

                jButton1.setBackground(new java.awt.Color(55, 112, 155));
                jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Next");
                jButton1.setBorderPainted(false);
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                jButton1.setFocusable(false);
                jButton1.setBounds(470, y2, 110, 30);
                jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            for (int i = 0; i < textFields.size(); i++) {

                                for (int j = 0; j < 7; j++) {
                                    if (textFields.get(i)[j].getText().isEmpty()) {
                                        throw new EmptyFields();
                                    }
                                }
                            }
                            for (int k = 0; k < birthDates.size(); k++) {
                                if (birthDates.get(k).getDate() == null) {
                                    throw new EmptyFields();
                                }
                            }
                            if (FieldsController.checkSeatNumbers(DepartAvailableSeatChoice, ReturnAvailableSeatChoice, numberOfPassengers) == false) {
                                JOptionPane.showMessageDialog(null, "Two people cannot share the same seat number.","",  JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                passengersPanel.setVisible(false);
                                flightDetailsPanel.setVisible(false);
                                passengersScrollPane.setVisible(false);

                                getContentPane().repaint();
                                setPayment();
                                getContentPane().add(payment);
                                payment.setVisible(true);
                                setSize(630, 750);
                            }
                            

                        } catch (EmptyFields exception) {
                            System.out.println(exception.getMessage());
                        }

                    }

                });

                passengersPanel.add(jButton1);

            } else {

                y2 += 110;
            }
        }

        for (int i = 0; i < labels.size(); i++) {
            for (int j = 0; j < 9; j++) {
                passengersPanel.add(labels.get(i)[j]);
            }

        }

        for (int i = 0; i < textFields.size(); i++) {
            for (int j = 0; j < 7; j++) {
                passengersPanel.add(textFields.get(i)[j]);
            }

        }

        for (int i = 0; i < birthDates.size(); i++) {
            passengersPanel.add(birthDates.get(i));
        }

        for (int i = 0; i < DepartAvailableSeatChoice.size(); i++) {
            passengersPanel.add(DepartAvailableSeatChoice.get(i));
            DepartAvailableSeatChoice.get(i).setBounds(485, seatChoiceDepartBoundsY2.get(i), 130, 32);
            AutoCompleteDecorator.decorate(DepartAvailableSeatChoice.get(i));
        }

        if (flights.size() == 2) {
            for (int i = 0; i < ReturnAvailableSeatChoice.size(); i++) {
                passengersPanel.add(ReturnAvailableSeatChoice.get(i));
                ReturnAvailableSeatChoice.get(i).setBounds(485, seatChoiceReturnBounds.get(i), 130, 32);
                AutoCompleteDecorator.decorate(ReturnAvailableSeatChoice.get(i));
            }
        }


        passengersScrollPane.setViewportView(passengersPanel);
        getContentPane().add(passengersScrollPane);
        passengersScrollPane.setBounds(0, 290, 630, 490);

        pack();

    }
    

    public void setPayment() {
        payment = new PaymentPanel(this);
    }

    public JPanel getFlightDetailsPanel() {
        return flightDetailsPanel;
    }

    public JPanel getPassengersPanel() {
        return passengersPanel;
    }

    public JScrollPane getPassengersScrollPane() {
        return passengersScrollPane;
    }

    public ArrayList<JTextField[]> getTextFields() {
        return textFields;
    }

    public ArrayList<JDateChooser> getBirthDates() {
        return birthDates;
    }

    public ArrayList<JComboBox<FlightSeat>> getDepartAvailableSeatChoice() {
        return DepartAvailableSeatChoice;
    }

    public ArrayList<JComboBox<FlightSeat>> getReturnAvailableSeatChoice() {
        return ReturnAvailableSeatChoice;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public CustomerAccount getLoggedInCustomer() {
        return loggedInCustomer;
    }
    
    
    
}
