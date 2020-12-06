package view;

import DataAcessObjectImpl.FlightDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import model.*;
import controller.*;
import javax.swing.*;
import com.toedter.calendar.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import controller.AirportController;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CustomerHomeFlightSearch extends javax.swing.JFrame {

    private JPanel oneWayPanel, jPanel1, roundTripPanel;
    private JScrollPane DepartureScrollPane, DepartureScrollPaneAR, ArrivalScrollPaneAR;
    private JButton Next, search, NextAR;
    private JLabel arrival, backGround, departureAR, departure, from, passengers, seat, to, worldAirline, departureAR1, arrivalAR;
    private JDateChooser arrivalDate, departureDate;
    private JRadioButton businessClass, economyClass, firstClass, roundTrip, oneWay;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox<Airport> fromDeparture, toArrival;
    private JComboBox<String> selectPassenger;
    private javax.swing.JButton myAccount;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    int screenHeight = screenSize.height;
    
    int screenWidth = screenSize.width;


    private JTable searchDepartureFlights, searchDepartureFlightsAR, searchArrivalFlightsAR;
    private ActionListener controller;

    private CustomerAccount loggedInCustomer;

    public CustomerHomeFlightSearch(CustomerAccount customer) {
        loggedInCustomer = customer;
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        //this.setSize((int) screenSize.getWidth() ,(int) screenSize.getHeight());
        System.out.println(screenWidth +" "+ screenHeight);
        System.out.println(getMonitorSizes());
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        setSize(1600, 900);
        this.setVisible(true);

    }
private String getMonitorSizes() {        
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[]    gs = ge.getScreenDevices();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < gs.length; i++) {
        DisplayMode dm = gs[i].getDisplayMode();
        sb.append(i + ", width: " + dm.getWidth() + ", height: " + dm.getHeight() + "\n");
    }    
    return sb.toString();
}
    private void initComponents() {

        try {             
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img\\430119.jpg")))));         
        } catch (IOException e) {             
            e.printStackTrace();         
        }
        
        roundTripPanel = new JPanel();
        DepartureScrollPaneAR = new JScrollPane();
        ArrivalScrollPaneAR = new JScrollPane();

        NextAR = new JButton();

        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        jPanel1 = new JPanel();
        oneWay = new JRadioButton();
        economyClass = new JRadioButton();
        selectPassenger = new JComboBox<>();
        to = new JLabel();
        seat = new JLabel();
        fromDeparture = new JComboBox<>();
        from = new JLabel();
        arrivalDate = new JDateChooser();
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
        Next = new JButton();
        DepartureScrollPane = new JScrollPane();
        searchDepartureFlights = new JTable();
        departureAR = new JLabel();
        arrivalAR = new JLabel();
        searchDepartureFlightsAR = new JTable();
        searchArrivalFlightsAR = new JTable();
        departureAR1 = new JLabel();
        backGround = new JLabel();
        myAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);
        


        jPanel1.setBackground(new java.awt.Color(200, 191, 191));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        buttonGroup1.add(roundTrip);
        roundTrip.setFont(new Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        roundTrip.setForeground(new Color(255, 255, 255));
        roundTrip.setText("ROUND TRIP");
        roundTrip.setContentAreaFilled(false);
        roundTrip.setFocusable(false);

        roundTrip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                arrival.setVisible(true);
                arrivalDate.setVisible(true);
                oneWayPanel.setVisible(false);
                roundTripPanel.setVisible(true);
            }
        });
        jPanel1.add(roundTrip);
        roundTrip.setBounds(30, 20, 120, 30);
        
        myAccount.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        myAccount.setIcon(new javax.swing.ImageIcon("img\\Icon-Small-50.png")); // NOI18N
        if(loggedInCustomer!=null)
            myAccount.setText(" My account");
        else
            myAccount.setText(" Log in");
        
        myAccount.setActionCommand("My account");
        myAccount.setBorder(null);
        myAccount.setFocusable(false);
        myAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myAccount.setOpaque(false);
        myAccount.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        myAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(myAccount);
        myAccount.setContentAreaFilled(false);
        myAccount.setBorderPainted(false);
        myAccount.setBounds(screenWidth-150, 50, 140, 80);
        myAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        roundTrip.setSelected(true);
        buttonGroup1.add(oneWay);
        oneWay.setFont(new Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        oneWay.setForeground(new java.awt.Color(255, 255, 255));
        oneWay.setText("ONE-WAY");
        oneWay.setContentAreaFilled(false);
        oneWay.setFocusable(false);

        oneWay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrival.setVisible(false);
                arrivalDate.setVisible(false);
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
        fromDeparture.setBounds(130, 80, 155, 20);
        AutoCompleteDecorator.decorate(fromDeparture);

        to.setFont(new Font("Yu Gothic UI", 0, 12)); // NOI18N
        to.setIcon(new ImageIcon("img\\location.png")); // NOI18N
        to.setText("To");
        jPanel1.add(to);
        to.setBounds(30, 120, 70, 40);

        toArrival.setModel(new DefaultComboBoxModel(AirportController.getAllAirports()));
        toArrival.setOpaque(false);
        /*     toArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toArrivalActionPerformed(evt);
            }
        });*/
        jPanel1.add(toArrival);
        toArrival.setBounds(130, 130, 155, 20);
        AutoCompleteDecorator.decorate(toArrival);

        departure.setFont(new Font("Yu Gothic UI", 0, 12)); // NOI18N
        departure.setIcon(new ImageIcon("img\\calendar.png")); // NOI18N
        departure.setText("Depart");
        jPanel1.add(departure);
        departure.setBounds(30, 170, 80, 40);

        jPanel1.add(departureDate);
        departureDate.setBounds(130, 180, 110, 20);

        arrival.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        arrival.setIcon(new javax.swing.ImageIcon("img\\calendar.png")); // NOI18N
        arrival.setText("Return");
        jPanel1.add(arrival);
        arrival.setBounds(30, 210, 80, 40);

        jPanel1.add(arrivalDate);
        arrivalDate.setBounds(130, 220, 110, 20);

        passengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        passengers.setIcon(new javax.swing.ImageIcon("img\\users.png")); // NOI18N
        passengers.setText("Passenger(s)");
        jPanel1.add(passengers);
        passengers.setBounds(30, 260, 90, 40);
        jPanel1.add(economyClass);
        economyClass.setBounds(130, 380, 120, 30);

        selectPassenger.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        selectPassenger.setOpaque(false);
        /*     selectPassenger.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPassengerActionPerformed(evt);
            }
        });*/
        jPanel1.add(selectPassenger);
        selectPassenger.setBounds(130, 270, 110, 20);

        seat.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        seat.setIcon(new javax.swing.ImageIcon("img\\seat.png")); // NOI18N
        seat.setText("Seat");
        jPanel1.add(seat);
        seat.setBounds(30, 340, 80, 40);

        buttonGroup2.add(firstClass);
        firstClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        firstClass.setForeground(new java.awt.Color(255, 255, 255));
        firstClass.setText("First Class");
        firstClass.setContentAreaFilled(false);
        firstClass.setFocusable(false);
        /*  firstClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstClassActionPerformed(evt);
            }
        });*/
        jPanel1.add(firstClass);
        firstClass.setBounds(130, 320, 110, 30);

        buttonGroup2.add(businessClass);
        businessClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        businessClass.setForeground(new java.awt.Color(255, 255, 255));
        businessClass.setText("Business Class");
        businessClass.setContentAreaFilled(false);
        businessClass.setFocusable(false);
        /*   businessClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessClassActionPerformed(evt);
            }
        });*/
        jPanel1.add(businessClass);
        businessClass.setBounds(130, 350, 110, 30);

        buttonGroup2.add(economyClass);
        economyClass.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        economyClass.setForeground(new java.awt.Color(255, 255, 255));
        economyClass.setText("Economy Class");
        economyClass.setContentAreaFilled(false);
        economyClass.setFocusable(false);
        /*economyClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //economyClassActionPerformed(evt);
            }
        });*/

        search.setBackground(new java.awt.Color(102, 102, 102));
        search.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setBorderPainted(false);
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        worldAirline.setBounds((screenWidth/2)-300, 20, 600, 110);
        worldAirline.setForeground(new java.awt.Color(0, 0, 0));

        oneWayPanel.setOpaque(false);
        oneWayPanel.setLayout(null);

        Next.setBackground(new java.awt.Color(102, 102, 102));
        Next.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Next.setForeground(new java.awt.Color(255, 255, 255));
        Next.setText("Next");
        Next.setBorderPainted(false);
        Next.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Next.setFocusable(false);
        oneWayPanel.add(Next);
        Next.setBounds(4*screenWidth/7 -110, 560, 110, 30);
        Next.setActionCommand("Next");
        Next.addActionListener(new CustomerFlightSearchChoice(this));

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
        searchDepartureFlights.setSelectionBackground(new java.awt.Color(200, 191, 191));
        searchDepartureFlights.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDepartureFlights.setShowHorizontalLines(false);
        searchDepartureFlights.setShowVerticalLines(false);
        searchDepartureFlights.getTableHeader().setReorderingAllowed(false);
        DepartureScrollPane.setViewportView(searchDepartureFlights);

        oneWayPanel.add(DepartureScrollPane);
        DepartureScrollPane.setBounds(0, 40, 4*screenWidth/7, 500);

        departureAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureAR.setForeground(new java.awt.Color(255, 255, 255));
        departureAR.setText("Depart>>");
        oneWayPanel.add(departureAR);
        departureAR.setBounds(0, 0, 150, 30);

        getContentPane().add(oneWayPanel);
        oneWayPanel.setBounds(510, 190, 4*screenWidth/7, 590);

        roundTripPanel.setOpaque(false);
        roundTripPanel.setLayout(null);

        NextAR.setBackground(new java.awt.Color(102, 102, 102));
        NextAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        NextAR.setForeground(new java.awt.Color(255, 255, 255));
        NextAR.setText("Next");
        NextAR.setBorderPainted(false);
        NextAR.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NextAR.setFocusable(false);
        NextAR.setActionCommand("Next");
        NextAR.addActionListener(new CustomerFlightSearchChoice(this));
        roundTripPanel.add(NextAR);
        NextAR.setBounds(4*screenWidth/7 - 110, 560, 110, 30);

        //ArrayList<Flight> flights =  new ArrayList<Flight>();
        //    flights.add(new FlightDAOImpl().find(5));
        //  SearchFlightsTableModel  model = new SearchFlightsTableModel(flights);
        searchDepartureFlightsAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        searchDepartureFlightsAR.setModel(model);
        searchDepartureFlightsAR.setFocusable(false);
        searchDepartureFlightsAR.setGridColor(new java.awt.Color(0, 0, 0));
        searchDepartureFlightsAR.setOpaque(false);
        searchDepartureFlightsAR.setRowHeight(20);
        searchDepartureFlightsAR.setSelectionBackground(new java.awt.Color(200, 191, 191));
        searchDepartureFlightsAR.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDepartureFlightsAR.setShowHorizontalLines(false);
        searchDepartureFlightsAR.setShowVerticalLines(false);
        searchDepartureFlightsAR.getTableHeader().setReorderingAllowed(false);
        DepartureScrollPaneAR.setViewportView(searchDepartureFlightsAR);

        roundTripPanel.add(DepartureScrollPaneAR);
        DepartureScrollPaneAR.setBounds(0, 310, 4*screenWidth/7, 230);

        //   ArrayList<Flight> flights =  new ArrayList<Flight>();
        //flights.add(new FlightDAOImpl().find(5));
        // SearchFlightsTableModel  model = new SearchFlightsTableModel(flights);
        searchArrivalFlightsAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        searchArrivalFlightsAR.setModel(model);
        searchArrivalFlightsAR.setFocusable(false);
        searchArrivalFlightsAR.setGridColor(new java.awt.Color(0, 0, 0));
        searchArrivalFlightsAR.setOpaque(false);
        searchArrivalFlightsAR.setRowHeight(20);
        searchArrivalFlightsAR.setSelectionBackground(new java.awt.Color(200, 191, 191));
        searchArrivalFlightsAR.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchArrivalFlightsAR.setShowHorizontalLines(false);
        searchArrivalFlightsAR.setShowVerticalLines(false);
        searchArrivalFlightsAR.getTableHeader().setReorderingAllowed(false);
        ArrivalScrollPaneAR.setViewportView(searchArrivalFlightsAR);

        
        ArrivalScrollPaneAR.setBounds(0, 40, 4*screenWidth/7, 230);
        roundTripPanel.add(ArrivalScrollPaneAR);
        
        departureAR1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureAR1.setForeground(new java.awt.Color(255, 255, 255));
        departureAR1.setText("Depart>>");
        roundTripPanel.add(departureAR1);
        departureAR1.setBounds(0, 0, 150, 30);

        arrivalAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        arrivalAR.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAR.setText("Return<<");
        roundTripPanel.add(arrivalAR);
        arrivalAR.setBounds(0, 270, 150, 40);

        getContentPane().add(roundTripPanel);
        roundTripPanel.setVisible(true);
        oneWayPanel.setVisible(false);
        roundTripPanel.setBounds(510, 190, 4*screenWidth/7 , 590);

        backGround.setIcon(new javax.swing.ImageIcon("img\\auqwj-tjqus.jpg")); // NOI18N
        //getContentPane().add(backGround);
        backGround.setBounds(0, 0, screenWidth, screenHeight);

     
        
        pack();
    }

 
    
    //getters for the Search button action listener
    public Date getArrivalDate() {
        return arrivalDate.getDate();
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

    public JTable getSearchDepartureFlightsAR() {
        return searchDepartureFlightsAR;
    }

    public JTable getSearchArrivalFlightsAR() {
        return searchArrivalFlightsAR;
    }

    public void setSearchDepartureFlightsModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchDepartureFlights.setModel(searchDepartureFlights);
    }

    public void setSearchDepartureFlightsARModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchDepartureFlightsAR.setModel(searchDepartureFlights);
    }

    public void setSearchArrivalFlightsARModel(SearchFlightsTableModel searchDepartureFlights) {
        this.searchArrivalFlightsAR.setModel(searchDepartureFlights);
    }

    public CustomerAccount getLoggedInCustomer() {
        return loggedInCustomer;
    }

    
    
}
