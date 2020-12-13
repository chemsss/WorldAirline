package view.Customer;

import view.Customer.CustomerFlightSearchChoice;
import DataAcessObjectImpl.FlightDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import model.*;
import controller.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import controller.AirportController;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.Date;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CustomerHomeFlightSearch extends javax.swing.JFrame {

    private JPanel oneWayPanel, jPanel1, roundTripPanel;
    private JScrollPane departureScrollPane, departureScrollPaneRoundTrip, returnScrollPaneRoundTrip;
    private JButton next, search, nextRoundTrip;
    private JLabel arrival, departureRoundTrip, departure, from, passengers, seat, to, worldAirline, departureRoundTrip1, arrivalRoundTrip;
   
    private JDateChooser returnDate, departureDate;
    private JRadioButton businessClass, economyClass, firstClass, roundTrip, oneWay;
    private ButtonGroup OneWayOrRoundTrip;


    private ButtonGroup className;
    private JComboBox<Airport> fromDeparture, toArrival;
    private JComboBox<String> selectPassenger;
   
    private javax.swing.JButton myAccount;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    private JTable searchDepartureFlights, searchDepartureFlightsRoundTrip, searchReturnFlightsRoundTrip;
    private CustomerAccount loggedInCustomer;

    public CustomerAccount getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public CustomerHomeFlightSearch(CustomerAccount customer) {

        loggedInCustomer = customer;
        initComponents();
        setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setVisible(true);

    }

    private void initComponents() {

        roundTripPanel = new JPanel();
        departureScrollPaneRoundTrip = new JScrollPane();
        returnScrollPaneRoundTrip = new JScrollPane();
        nextRoundTrip = new JButton();
        OneWayOrRoundTrip = new ButtonGroup();
        className = new ButtonGroup();
        jPanel1 = new JPanel();
        oneWay = new JRadioButton();
        economyClass = new JRadioButton();
        selectPassenger = new JComboBox<>();
        to = new JLabel();
        seat = new JLabel();
        fromDeparture = new JComboBox<>();
        from = new JLabel();
        returnDate = new JDateChooser();
        departure = new JLabel();
        departureDate = new JDateChooser();
        roundTrip = new JRadioButton();
        businessClass = new JRadioButton();
        firstClass = new JRadioButton();
        passengers = new JLabel();
        arrival = new JLabel();
        toArrival = new JComboBox<>();
        search = new JButton();
        worldAirline = new JLabel();
        oneWayPanel = new JPanel();
        next = new JButton();
        departureScrollPane = new JScrollPane();
        searchDepartureFlights = new JTable();
        departureRoundTrip = new JLabel();
        arrivalRoundTrip = new JLabel();
        searchDepartureFlightsRoundTrip = new JTable();
        searchReturnFlightsRoundTrip = new JTable();
        departureRoundTrip1 = new JLabel();
        myAccount = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        OneWayOrRoundTrip.add(roundTrip);
        roundTrip.setFont(new Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        roundTrip.setForeground(new Color(0, 0, 0));
        roundTrip.setText("ROUND TRIP");
        roundTrip.setContentAreaFilled(false);
        roundTrip.setFocusable(false);
        roundTrip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                arrival.setVisible(true);
                returnDate.setVisible(true);
                oneWayPanel.setVisible(false);
                roundTripPanel.setVisible(true);
            }
        });
        jPanel1.add(roundTrip);
        roundTrip.setBounds(30, 20, 120, 30);
        myAccount.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        myAccount.setForeground(new Color(255, 255, 255)); // NOI18N

        myAccount.setIcon(new javax.swing.ImageIcon("img\\male_user_70px.png")); // NOI18N
        myAccount.addActionListener((new CustomerFlightSearchChoice(this)));
        if (loggedInCustomer != null) {
            myAccount.setText(" My account");
            myAccount.setActionCommand("Logged");
        } else {
            myAccount.setText(" Log in");
            myAccount.setActionCommand("Unlogged");

        }
        myAccount.setBorder(null);
        myAccount.setFocusable(false);
        myAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myAccount.setOpaque(false);
        myAccount.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(myAccount);
        myAccount.setContentAreaFilled(false);
        myAccount.setBorderPainted(false);
        myAccount.setBounds(screenWidth - 180, 50, 200, 200);
        myAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        roundTrip.setSelected(true);
        OneWayOrRoundTrip.add(oneWay);
        oneWay.setFont(new Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        oneWay.setForeground(new java.awt.Color(0, 0, 0));
        oneWay.setText("ONE-WAY");
        oneWay.setContentAreaFilled(false);
        oneWay.setFocusable(false);
        oneWay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrival.setVisible(false);
                returnDate.setVisible(false);
                oneWayPanel.setVisible(true);
                roundTripPanel.setVisible(false);

            }
        });
        jPanel1.add(oneWay);
        oneWay.setBounds(190, 20, 110, 30);
        from.setFont(new Font("Yu Gothic UI", 0, 12)); // NOI18N
        from.setIcon(new ImageIcon("img\\location.png")); // NOI18N
        from.setText("From");
        jPanel1.add(from);
        from.setBounds(30, 70, 70, 40);
        fromDeparture.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        fromDeparture.setOpaque(false);
        jPanel1.add(fromDeparture);
        fromDeparture.setBounds(128, 80, 160, 30);
        AutoCompleteDecorator.decorate(fromDeparture);
        to.setFont(new Font("Yu Gothic UI", 0, 12)); // NOI18N
        to.setIcon(new ImageIcon("img\\location.png")); // NOI18N
        to.setText("To");
        jPanel1.add(to);
        to.setBounds(30, 120, 70, 40);
        toArrival.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        toArrival.setOpaque(false);

        jPanel1.add(toArrival);
        toArrival.setBounds(128, 130, 160, 30);
        AutoCompleteDecorator.decorate(toArrival);
        departure.setFont(new Font("Yu Gothic UI", 0, 12)); // NOI18N
        departure.setIcon(new ImageIcon("img\\calendar.png")); // NOI18N
        departure.setText("Depart");
        jPanel1.add(departure);
        departure.setBounds(30, 170, 80, 40);
        jPanel1.add(departureDate);
        departureDate.setBounds(130, 175, 155, 29);
        departureDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        arrival.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        arrival.setIcon(new javax.swing.ImageIcon("img\\calendar.png")); // NOI18N
        arrival.setText("Return");
        jPanel1.add(arrival);
        arrival.setBounds(30, 210, 80, 40);
        jPanel1.add(returnDate);
        returnDate.setBounds(130, 215, 155, 29);
        returnDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        passengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        passengers.setIcon(new javax.swing.ImageIcon("img\\users.png")); // NOI18N
        passengers.setText("Passenger(s)");
        jPanel1.add(passengers);
        passengers.setBounds(30, 260, 90, 40);
        jPanel1.add(economyClass);
       economyClass. setSelected(true);
        economyClass.setBounds(130, 380, 120, 30);
        selectPassenger.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        selectPassenger.setOpaque(false);

        jPanel1.add(selectPassenger);
        selectPassenger.setBounds(130, 270, 120, 25);
        seat.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        seat.setIcon(new javax.swing.ImageIcon("img\\seat.png")); // NOI18N
        seat.setText("Seat");
        jPanel1.add(seat);
        seat.setBounds(30, 340, 80, 40);
        className.add(firstClass);
        firstClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        firstClass.setForeground(new java.awt.Color(0, 0, 0));
        firstClass.setText("First Class");
        firstClass.setContentAreaFilled(false);
        firstClass.setFocusable(false);

        jPanel1.add(firstClass);
        firstClass.setBounds(130, 320, 110, 30);
        className.add(businessClass);
        businessClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        businessClass.setForeground(new java.awt.Color(0, 0, 0));
        businessClass.setText("Business Class");
        businessClass.setContentAreaFilled(false);
        businessClass.setFocusable(false);

        jPanel1.add(businessClass);
        businessClass.setBounds(130, 350, 110, 30);
        className.add(economyClass);
        economyClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        economyClass.setForeground(new java.awt.Color(0, 0, 0));
        economyClass.setText("Economy Class");
        economyClass.setContentAreaFilled(false);
        economyClass.setFocusable(false);

        search.setBackground(new Color(55, 112, 155));
        search.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setBorderPainted(false);
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.setFocusable(false);
        jPanel1.add(search);
        search.setBounds(130, 440, 110, 30);
        search.setActionCommand("Search");
        
        search.addActionListener(new CustomerFlightSearchChoice(this));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 230, 360, 500);
        worldAirline.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 110)); // NOI18N
        worldAirline.setText("WorldAirline");
        getContentPane().add(worldAirline);
        worldAirline.setBounds((screenWidth / 2) - 300, 20, 600, 110);
        worldAirline.setForeground(new java.awt.Color(255, 255, 255));
        oneWayPanel.setOpaque(false);
        oneWayPanel.setLayout(null);
       
        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        next.setForeground(new java.awt.Color(0, 0, 0));
        next.setText("Next");
        next.setBorderPainted(false);
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next.setFocusable(false);
        oneWayPanel.add(next);
        next.setBounds(710, 560, 110, 30);
        next.setActionCommand("Next");
        next.addActionListener(new CustomerFlightSearchChoice(this));
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(new FlightDAOImpl().find(5));
        flights.add(new FlightDAOImpl().find(6));
        System.out.println(flights.get(0).getIdFlight());
        SearchFlightsTableModel model = new SearchFlightsTableModel();
       
        searchDepartureFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        searchDepartureFlights.setModel(model);
        searchDepartureFlights.setFocusable(false);
        searchDepartureFlights.setGridColor(new java.awt.Color(0, 0, 0));
        searchDepartureFlights.setOpaque(false);
        searchDepartureFlights.setRowHeight(20);
        searchDepartureFlights.setForeground(new Color (0,0,0));

        searchDepartureFlights.setSelectionBackground(new java.awt.Color(0, 204, 0));
        searchDepartureFlights.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDepartureFlights.setShowHorizontalLines(false);
        searchDepartureFlights.setShowVerticalLines(false);
        searchDepartureFlights.getTableHeader().setReorderingAllowed(false);
        departureScrollPane.setViewportView(searchDepartureFlights);
        departureScrollPane.getViewport().setBackground(Color.WHITE);

        oneWayPanel.add(departureScrollPane);
        departureScrollPane.setBounds(0, 40, 860, 500);
        
        departureRoundTrip.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureRoundTrip.setForeground(new java.awt.Color(255, 255, 255));
        departureRoundTrip.setText("Depart>>");
        oneWayPanel.add(departureRoundTrip);
        departureRoundTrip.setBounds(0, 0, 150, 30);
        getContentPane().add(oneWayPanel);
        oneWayPanel.setBounds(510, 190, 820, 590);
        roundTripPanel.setOpaque(false);
        roundTripPanel.setLayout(null);
        nextRoundTrip.setBackground(new java.awt.Color(255, 255, 255));
        nextRoundTrip.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        nextRoundTrip.setForeground(new java.awt.Color(0, 0, 0));
        nextRoundTrip.setText("Next");
        nextRoundTrip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        nextRoundTrip.setBorderPainted(false);
        nextRoundTrip.setFocusable(false);
        nextRoundTrip.setActionCommand("Next");
        nextRoundTrip.addActionListener(new CustomerFlightSearchChoice(this));
        roundTripPanel.add(nextRoundTrip);
        nextRoundTrip.setBounds(710, 560, 110, 30);

        searchDepartureFlightsRoundTrip.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        searchDepartureFlightsRoundTrip.setModel(model);
        searchDepartureFlightsRoundTrip.setFocusable(false);
        searchDepartureFlightsRoundTrip.setForeground(new Color (0,0,0));

        searchDepartureFlightsRoundTrip.setGridColor(new java.awt.Color(0, 0, 0));
        searchDepartureFlightsRoundTrip.setOpaque(false);
        searchDepartureFlightsRoundTrip.setRowHeight(20);
        searchDepartureFlightsRoundTrip.setSelectionBackground(new java.awt.Color(0, 204, 0));
        searchDepartureFlightsRoundTrip.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDepartureFlightsRoundTrip.setShowHorizontalLines(false);
        searchDepartureFlightsRoundTrip.setShowVerticalLines(false);
        searchDepartureFlightsRoundTrip.getTableHeader().setReorderingAllowed(false);
        departureScrollPaneRoundTrip.setViewportView(searchDepartureFlightsRoundTrip);
                departureScrollPaneRoundTrip.getViewport().setBackground(Color.WHITE);

        roundTripPanel.add(departureScrollPaneRoundTrip);
        departureScrollPaneRoundTrip.setBounds(0, 310, 820, 230);

        searchReturnFlightsRoundTrip.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
                searchReturnFlightsRoundTrip.setForeground(new Color (0,0,0));

        searchReturnFlightsRoundTrip.setModel(model);
        searchReturnFlightsRoundTrip.setFocusable(false);
        searchReturnFlightsRoundTrip.setGridColor(new java.awt.Color(0, 0, 0));
        searchReturnFlightsRoundTrip.setOpaque(false);
        searchReturnFlightsRoundTrip.setRowHeight(20);
        searchReturnFlightsRoundTrip.setSelectionBackground(new java.awt.Color(0, 204, 0));
        searchReturnFlightsRoundTrip.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchReturnFlightsRoundTrip.setShowHorizontalLines(false);
        searchReturnFlightsRoundTrip.setShowVerticalLines(false);
        searchReturnFlightsRoundTrip.getTableHeader().setReorderingAllowed(false);
        returnScrollPaneRoundTrip.setViewportView(searchReturnFlightsRoundTrip);
        returnScrollPaneRoundTrip.getViewport().setBackground(Color.WHITE);

        roundTripPanel.add(returnScrollPaneRoundTrip);
        returnScrollPaneRoundTrip.setBounds(0, 40, 820, 230);
        departureRoundTrip1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureRoundTrip1.setForeground(new java.awt.Color(255, 255, 255));
        departureRoundTrip1.setText("Depart>>");
        roundTripPanel.add(departureRoundTrip1);
        departureRoundTrip1.setBounds(0, 0, 150, 30);
        arrivalRoundTrip.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        arrivalRoundTrip.setForeground(new java.awt.Color(255, 255, 255));
        arrivalRoundTrip.setText("Return<<");
        roundTripPanel.add(arrivalRoundTrip);
        arrivalRoundTrip.setBounds(0, 270, 150, 40);
        getContentPane().add(roundTripPanel);
        roundTripPanel.setVisible(true);
        oneWayPanel.setVisible(false);
        roundTripPanel.setBounds(510, 190, 820, 590);

        //backGround.setIcon(new javax.swing.ImageIcon("img\\auqwj-tjqus.jpg")); // NOI18N
        // backGround.setBounds(0, 0, screenWidth, screenHeight);
        //getContentPane().add(backGround);
        this.getContentPane().setBackground((new Color(55, 112, 155)));
        pack();
    }

    public Date getReturnDate() {
        return returnDate.getDate();
    }
    public ButtonGroup getOneWayOrRoundTrip() {
        return OneWayOrRoundTrip;
    }
    public JRadioButton getBusinessClass() {
        return businessClass;
    }

    public Date getDepartureDate() {
        return departureDate.getDate();
    }

    public JRadioButton getEconomyClass() {
        return economyClass;
    }

    public String getFirstClass() {
        return firstClass.getText();
    }

    public JComboBox<Airport> getFromDeparture() {
        return fromDeparture;
    }

    public JRadioButton getOneWay() {
        return oneWay;
    }

    public JRadioButton getRoundTrip() {
        return roundTrip;
    }

    public int getSelectPassenger() {
        return Integer.parseInt((String) selectPassenger.getSelectedItem());
    }

    public JComboBox<Airport> getToArrival() {
        return toArrival;
    }

    public javax.swing.JTable getSearchDepartureFlights() {
        return searchDepartureFlights;
    }

    public JTable getSearchDepartureFlightsRoundTrip() {
        return searchDepartureFlightsRoundTrip;
    }

    public JTable getSearchReturnFlightsRoundTrip() {
        return searchReturnFlightsRoundTrip;
    }

    public void setSearchDepartureFlightsModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchDepartureFlights.setModel(searchDepartureFlights);
    }

    public void setSearchDepartureFlightsRoundTripModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchDepartureFlightsRoundTrip.setModel(searchDepartureFlights);
    }

    public void setSearchReturnFlightsRoundTripModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchReturnFlightsRoundTrip.setModel(searchDepartureFlights);
    }

}
