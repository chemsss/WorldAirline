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
import java.util.Date;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CustomerHomeFlightSearch extends javax.swing.JFrame {

    private JPanel oneWayPanel,jPanel1, roundTripPanel;
    private JScrollPane DepartureScrollPane,DepartureScrollPaneAR,ArrivalScrollPaneAR;
    private JButton Next,search,NextAR;
    private JLabel arrival,backGround,departureAR,departure,from,passengers,seat,to,worldWride,departureAR1,arrivalAR;
    private JDateChooser arrivalDate,departureDate;
    private JRadioButton businessClass,economyClass,firstClass,roundTrip,oneWay;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox<Airport> fromDeparture,toArrival;
    private JComboBox<String> selectPassenger;

    private JTable searchDeapartureFlights,searchDepartureFlightsAR,searchArrivalFlightsAR;
    private ActionListener controller;
    
    public CustomerHomeFlightSearch() {
        initComponents();
        this.setSize(1920,1080);
        this.setVisible(true);
        
    }            
    private void initComponents() {
        
        roundTripPanel=new JPanel();
        DepartureScrollPaneAR=new JScrollPane();
        ArrivalScrollPaneAR=new JScrollPane();

        NextAR=new JButton   ();
        
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
        worldWride = new JLabel();
        oneWayPanel = new JPanel();
        Next = new JButton();
        DepartureScrollPane = new JScrollPane();
        searchDeapartureFlights = new JTable();
        departureAR = new JLabel();
        arrivalAR=new  JLabel();
        searchDepartureFlightsAR=new JTable();
        searchArrivalFlightsAR=new JTable();
        departureAR1= new JLabel();
        backGround = new JLabel();
          
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
        public void actionPerformed(ActionEvent evt) {
                 arrival.setVisible(true);
                 arrivalDate.setVisible(true);
                 oneWayPanel.setVisible(false);
                 roundTripPanel.setVisible(true);
            }
        });
        jPanel1.add(roundTrip);
        roundTrip.setBounds(30, 20, 120, 30);

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
        departure.setText("Departure");
        jPanel1.add(departure);
        departure.setBounds(30, 170, 80, 40);
       
        jPanel1.add(departureDate);
        departureDate.setBounds(130, 180, 110, 20);
        
        arrival.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        arrival.setIcon(new javax.swing.ImageIcon("img\\calendar.png")); // NOI18N
        arrival.setText("Arrival");
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

        selectPassenger.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
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

        worldWride.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 110)); // NOI18N
        worldWride.setText("WorldAirline");
        getContentPane().add(worldWride);
        worldWride.setBounds(530, 10, 580, 110);

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
        Next.setBounds(710, 560, 110, 30);
        Next.setActionCommand("Next");

        ArrayList<Flight> flights =  new ArrayList<Flight>();
        flights.add(new FlightDAOImpl().find(5));
        flights.add(new FlightDAOImpl().find(6));
        System.out.println(flights.get(0).getIdFlight());
        SearchFlightsTableModel  model = new SearchFlightsTableModel(flights);
        searchDeapartureFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));
        searchDeapartureFlights.setModel(model);
        searchDeapartureFlights.setFocusable(false);
        searchDeapartureFlights.setGridColor(new java.awt.Color(0, 0, 0));
        searchDeapartureFlights.setOpaque(false);
        searchDeapartureFlights.setRowHeight(20);
        searchDeapartureFlights.setSelectionBackground(new java.awt.Color(200, 191, 191));
        searchDeapartureFlights.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDeapartureFlights.setShowHorizontalLines(false);
        searchDeapartureFlights.setShowVerticalLines(false);
        searchDeapartureFlights.getTableHeader().setReorderingAllowed(false);
        DepartureScrollPane.setViewportView(searchDeapartureFlights);

        oneWayPanel.add(DepartureScrollPane);
        DepartureScrollPane.setBounds(0, 40, 860, 500);

        departureAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureAR.setForeground(new java.awt.Color(255, 255, 255));
        departureAR.setText("Departure>>");
        oneWayPanel.add(departureAR);
        departureAR.setBounds(0, 0, 150, 30);

        getContentPane().add(oneWayPanel);
        oneWayPanel.setBounds(510, 190, 820, 590);
        
        
        
         roundTripPanel.setOpaque(false);
        roundTripPanel.setLayout(null);

        NextAR.setBackground(new java.awt.Color(102, 102, 102));
        NextAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        NextAR.setForeground(new java.awt.Color(255, 255, 255));
        NextAR.setText("Next");
        NextAR.setBorderPainted(false);
        NextAR.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NextAR.setFocusable(false);
        NextAR.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        roundTripPanel.add(NextAR);
        NextAR.setBounds(710, 560, 110, 30);

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
        DepartureScrollPaneAR.setBounds(0, 310, 860, 230);

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

        roundTripPanel.add(ArrivalScrollPaneAR);
        ArrivalScrollPaneAR.setBounds(0, 40, 860, 230);

        departureAR1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        departureAR1.setForeground(new java.awt.Color(255, 255, 255));
        departureAR1.setText("Departure>>");
        roundTripPanel.add(departureAR1);
        departureAR1.setBounds(0, 0, 150, 30);

        arrivalAR.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        arrivalAR.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAR.setText("Arrival<<");
        roundTripPanel.add(arrivalAR);
        arrivalAR.setBounds(0, 270, 150, 40);

        getContentPane().add(roundTripPanel);
        roundTripPanel.setVisible(true);
        oneWayPanel.setVisible(false);
        roundTripPanel.setBounds(510, 190, 820, 590);

        backGround.setIcon(new javax.swing.ImageIcon("img\\planeProgram.jpg")); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, -50, 1920, 1380);

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

    public javax.swing.JTable getSearchDeapartureFlights() {
        return searchDeapartureFlights;
    }

    public void setSearchDeapartureFlightsModel(SearchFlightsTableModel searchDeapartureFlights) {
        this.searchDeapartureFlights.setModel(searchDeapartureFlights);
    }
    
    
}
