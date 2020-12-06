package view;

import Exceptions.EmptyFields;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.CustomerAccount;
import model.Flight;

public class PassengersInfosFrame extends javax.swing.JFrame {

    //Passenger Informations
    private javax.swing.JLabel flightDetails;
    private javax.swing.JPanel flightDetailsPanel;
    private javax.swing.JPanel jPanel3;

    public JPanel getFlightDetailsPanel() {
        return flightDetailsPanel;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JLabel arrival;
    private javax.swing.JLabel arrivalAirport;
    private javax.swing.JLabel arrivalDateTime;
    private javax.swing.JLabel departure;
    private javax.swing.JLabel departureAirport;
    private javax.swing.JLabel departureDateTime;
    private javax.swing.JLabel from;
    private javax.swing.JLabel to;

    private javax.swing.JLabel arrival2;
    private javax.swing.JLabel arrivalAirport2;
    private javax.swing.JLabel arrivalDateTime2;
    private javax.swing.JLabel departure2;
    private javax.swing.JLabel departureAirport2;
    private javax.swing.JLabel departureDateTime2;
    private javax.swing.JLabel from2;
    private javax.swing.JLabel to2;
    private JButton jButton1;
    ArrayList<JLabel[]> labels = new ArrayList();
    ArrayList<JTextField[]> textFields = new ArrayList();
    ArrayList<JDateChooser> birthDates = new ArrayList();

    ArrayList<Flight> flights = new ArrayList();

    private CustomerAccount loggedInCustomer;

    private final int numberOfPassengers;

    JPanel Payement;

  
    public PassengersInfosFrame(ArrayList<Flight> selectedFlight, int numberOfPassengers) {
        super();
        Payement = new PayementPanel(this);
        this.flights = selectedFlight;
        this.numberOfPassengers = numberOfPassengers;
        initComponents();
        this.setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
    }

    public PassengersInfosFrame(ArrayList<Flight> selectedFlight, int numberOfPassengers, CustomerAccount loggedInCustomer) {
        super();
        Payement = new PayementPanel(this);
        this.loggedInCustomer = loggedInCustomer;
        this.flights = selectedFlight;
        this.numberOfPassengers = numberOfPassengers;
        initComponents();
        this.setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        flightDetailsPanel = new javax.swing.JPanel();
        flightDetails = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);
        jPanel3.setPreferredSize(new Dimension(100, 435 * numberOfPassengers));

        int y = 15;
        int y2 = 83;

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

            y2 += 40;
            text[3].setBounds(195, y2, 130, 32);
            text[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

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
                            jPanel3.setVisible(false);
                            flightDetailsPanel.setVisible(false);
                            jScrollPane1.setVisible(false);
                            getContentPane().repaint();
                            
                            getContentPane().add(Payement);
                            Payement.setVisible(true);
                            setSize(630, 750);

                          

                        } catch (EmptyFields exception) {
                            System.out.println(exception.getMessage());
                        }

                    }

                });

                jPanel3.add(jButton1);

            } else {

                y2 += 110;
            }
        }

        for (int i = 0; i < labels.size(); i++) {
            for (int j = 0; j < 9; j++) {
                jPanel3.add(labels.get(i)[j]);
            }

        }

        for (int i = 0; i < textFields.size(); i++) {
            for (int j = 0; j < 7; j++) {
                jPanel3.add(textFields.get(i)[j]);
            }

        }

        for (int i = 0; i < birthDates.size(); i++) {
            jPanel3.add(birthDates.get(i));
        }

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 290, 630, 490);

        pack();

    }

    private void initPayement() {
        /*
        
        this.setSize(635, 750);
        jPanel2 = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        creditCards = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        couponCode = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        dateExp = new javax.swing.JTextField();
        couponCodeField = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        payUsing1 = new javax.swing.JLabel();
        cardNumber1 = new javax.swing.JTextField();
        next1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 112, 155));
        jPanel2.setLayout(null);

        payment.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        jPanel2.add(payment);
        payment.setBounds(260, 20, 160, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1000$");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(490, 520, 130, 30);

        creditCards.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        creditCards.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\25654-2-major-credit-card-logo-transparent_400x400.png")); // NOI18N
        jPanel2.add(creditCards);
        creditCards.setBounds(170, 150, 420, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\lock_30px.png")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(50, 410, 60, 30);

        couponCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        couponCode.setForeground(new java.awt.Color(255, 255, 255));
        couponCode.setText("Coupon code :");
        jPanel2.add(couponCode);
        couponCode.setBounds(370, 600, 100, 40);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Price :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(340, 520, 130, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\credit_card_30px.png")); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 310, 40, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\calendar_30px.png")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 350, 30, 50);

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jTextField3.setText("Security Code");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(120, 412, 210, 32);

        dateExp.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        dateExp.setText("MM / YY");
        dateExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(dateExp);
        dateExp.setBounds(120, 362, 210, 32);

        couponCodeField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        couponCodeField.setText("Code");
        couponCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(couponCodeField);
        couponCodeField.setBounds(480, 610, 80, 25);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        previous.setBorderPainted(false);
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPanel3.setVisible(true);
                flightDetailsPanel.setVisible(true);
                jScrollPane1.setVisible(true);
                jPanel2.setVisible(false);
                setSize(643, 815);

            }
        });
        jPanel2.add(previous);
        previous.setBounds(30, 670, 90, 30);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        next.setText("OK");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next.setBorderPainted(false);
        jPanel2.add(next);
        next.setBounds(575, 610, 35, 25);

        payUsing1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        payUsing1.setForeground(new java.awt.Color(255, 255, 255));
        payUsing1.setText("Pay using :");
        jPanel2.add(payUsing1);
        payUsing1.setBounds(50, 150, 130, 30);

        cardNumber1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cardNumber1.setText("Card number");
        cardNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(cardNumber1);
        cardNumber1.setBounds(120, 312, 210, 32);

        next1.setBackground(new java.awt.Color(255, 255, 255));
        next1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        next1.setText("Next");
        next1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next1.setBorderPainted(false);
        jPanel2.add(next1);
        next1.setBounds(510, 670, 90, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 630, 720);

         */
    }

}
