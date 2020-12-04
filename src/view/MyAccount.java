package view;

import DataAcessObjectImpl.BookingDAOImpl;
import controller.BookingController;
import controller.CustomerController;
import controller.PassengerController;
import controller.SearchBookingsTableModel;
import controller.SearchTicketsTableModel;
import controller.TicketController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Booking;
import model.CustomerAccount;
import model.Ticket;

public class MyAccount extends javax.swing.JFrame {

    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myAccount;
    private javax.swing.JButton booking;
    private javax.swing.JButton personalInfo;

    ///For My personnal info Panel
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel ageCategory;
    private javax.swing.JLabel ageCategory1;
    private javax.swing.JLabel birthDate;
    private com.toedter.calendar.JDateChooser birthDateDate;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel myPersonalInfo;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton save;
    private javax.swing.JTextField telephoneNumberField;
    private javax.swing.JLabel telephoneNumber;
    private javax.swing.JButton previous;

    //My bookings
    private javax.swing.JScrollPane bookingScrollPane;
    private javax.swing.JButton getBooking;
    private javax.swing.JLabel myBookings;
    private javax.swing.JPanel myBookingsPanel;
    private javax.swing.JTable myBookingsTable;
    private javax.swing.JButton previous2;

    // My Ticket                 
    private javax.swing.JLabel myTickets;
    private javax.swing.JPanel myTicketsPanel;
    private javax.swing.JScrollPane myTicketsScrollPane;
    private javax.swing.JTable myTicketsTable;
    private javax.swing.JButton previous3;
    private javax.swing.JButton viewTicket;
    private Booking selectedBooking;

    //My Ticket Details
    private javax.swing.JLabel arrivalDateTime2;
    private javax.swing.JLabel arrivalTimeDate;
    private javax.swing.JLabel departureTimeDate;
    private javax.swing.JLabel departureTimeDate2;
    private javax.swing.JLabel flight;
    private javax.swing.JLabel flight2;
    private javax.swing.JLabel from;
    private javax.swing.JLabel from2;
    private javax.swing.JLabel myTicketDetails;
    private javax.swing.JPanel myTicketDetailsPanel;
    private javax.swing.JLabel nameOfPasenger2;
    private javax.swing.JLabel nameOfPassenger;
    private javax.swing.JButton previous4;
    private javax.swing.JLabel to;
    private javax.swing.JLabel to2;
    private CustomerAccount loggedInCustomer;
    private Ticket selectedTicket;

    public MyAccount(CustomerAccount loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
        initComponents();
        this.setSize(530, 615);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myAccount = new javax.swing.JLabel();
        booking = new javax.swing.JButton();
        personalInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(55, 112, 155));
        jPanel1.setLayout(null);

        myAccount.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myAccount.setForeground(new java.awt.Color(255, 255, 255));
        myAccount.setIcon(new javax.swing.ImageIcon("img\\male_user_90px.png")); // NOI18N
        myAccount.setText("My Account");
        myAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(myAccount);
        myAccount.setBounds(190, 20, 160, 150);

        booking.setBackground(new java.awt.Color(255, 255, 255));
        booking.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        booking.setText("My Bookings");
        booking.setBorder(null);
        booking.setBorderPainted(false);
        booking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        booking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel1.setVisible(false);
                myBookingsPanel.setVisible(true);
                setLocationRelativeTo(null);

            }

        });

        jPanel1.add(booking);
        booking.setBounds(140, 300, 230, 40);

        personalInfo.setBackground(new java.awt.Color(255, 255, 255));
        personalInfo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        personalInfo.setText("My Personal Information");
        personalInfo.setBorder(null);
        personalInfo.setBorderPainted(false);
        personalInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        personalInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel1.setVisible(false);
                jPanel3.setVisible(true);

            }

        });

        jPanel1.add(personalInfo);
        personalInfo.setBounds(140, 230, 230, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 580);

        //For My  personnal Info Panel
        jPanel3 = new javax.swing.JPanel();
        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        ageCategory = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        telephoneNumberField = new javax.swing.JTextField();
        birthDateDate = new com.toedter.calendar.JDateChooser();
        passwordField = new javax.swing.JPasswordField();
        myPersonalInfo = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        telephoneNumber = new javax.swing.JLabel();
        ageCategory1 = new javax.swing.JLabel();
        previous = new javax.swing.JButton();

        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(55, 112, 155));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setLayout(null);

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email :");
        jPanel3.add(email);
        email.setBounds(80, 110, 70, 30);

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password :");
        jPanel3.add(password);
        password.setBounds(80, 160, 100, 30);

        firstName.setBackground(new java.awt.Color(255, 255, 255));
        firstName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setText("First Name :");
        jPanel3.add(firstName);
        firstName.setBounds(80, 210, 100, 30);

        lastName.setBackground(new java.awt.Color(255, 255, 255));
        lastName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setText("Last Name :");
        jPanel3.add(lastName);
        lastName.setBounds(80, 260, 100, 30);

        address.setBackground(new java.awt.Color(255, 255, 255));
        address.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Address :");
        jPanel3.add(address);
        address.setBounds(80, 310, 100, 30);

        birthDate.setBackground(new java.awt.Color(255, 255, 255));
        birthDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        birthDate.setForeground(new java.awt.Color(255, 255, 255));
        birthDate.setText("Birth date :");
        jPanel3.add(birthDate);
        birthDate.setBounds(80, 360, 100, 30);

        ageCategory.setBackground(new java.awt.Color(255, 255, 255));
        ageCategory.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        ageCategory.setForeground(new java.awt.Color(255, 255, 255));
        ageCategory.setText(loggedInCustomer.getAgeCategory());
        jPanel3.add(ageCategory);
        ageCategory.setBounds(270, 460, 110, 30);

        emailField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));
        emailField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        emailField.setText(loggedInCustomer.getEmail());
        jPanel3.add(emailField);
        emailField.setBounds(270, 111, 160, 35);

        firstNameField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(51, 51, 51));
        firstNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        firstNameField.setText(loggedInCustomer.getFirstName());
        jPanel3.add(firstNameField);
        firstNameField.setBounds(270, 211, 160, 35);

        lastNameField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));
        lastNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lastNameField.setText(loggedInCustomer.getLastName());
        jPanel3.add(lastNameField);
        lastNameField.setBounds(270, 261, 160, 35);

        addressField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        addressField.setForeground(new java.awt.Color(51, 51, 51));
        addressField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        addressField.setText(loggedInCustomer.getAddress());
        jPanel3.add(addressField);
        addressField.setBounds(270, 311, 160, 35);

        telephoneNumberField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        telephoneNumberField.setForeground(new java.awt.Color(51, 51, 51));
        telephoneNumberField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        telephoneNumberField.setText(loggedInCustomer.getTelephoneNumber());
        jPanel3.add(telephoneNumberField);
        telephoneNumberField.setBounds(270, 411, 160, 35);

        birthDateDate.setDate(loggedInCustomer.getBirthDate());
        birthDateDate.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        jPanel3.add(birthDateDate);

        birthDateDate.setBounds(272, 362, 160, 33);

        passwordField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        passwordField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel3.add(passwordField);
        passwordField.setBounds(270, 161, 160, 35);

        myPersonalInfo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myPersonalInfo.setForeground(new java.awt.Color(255, 255, 255));
        myPersonalInfo.setText("My Personal Information");

        jPanel3.add(myPersonalInfo);
        myPersonalInfo.setBounds(130, 20, 260, 30);

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        save.setText("Save");
        save.setBorder(null);
        save.setBorderPainted(false);
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //if PAS DE PB =>save

                /*
                
                 */
                //else mssg erreur
            }
        });
        jPanel3.add(save);
        save.setBounds(210, 530, 90, 30);

        telephoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        telephoneNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        telephoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        telephoneNumber.setText("Telephone number :");
        jPanel3.add(telephoneNumber);
        telephoneNumber.setBounds(80, 410, 170, 30);

        ageCategory1.setBackground(new java.awt.Color(255, 255, 255));
        ageCategory1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        ageCategory1.setForeground(new java.awt.Color(255, 255, 255));
        ageCategory1.setText("Age category :");
        jPanel3.add(ageCategory1);
        ageCategory1.setBounds(80, 460, 170, 30);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(null);
        previous.setBorderPainted(false);
        previous.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPanel1.setVisible(true);
                jPanel3.setVisible(false);
            }
        });
        jPanel3.add(previous);
        previous.setBounds(3, 555, 40, 20);

        getContentPane().add(jPanel3);
        jPanel3.setVisible(false);
        jPanel3.setBounds(0, 0, 530, 580);

        myBookingsPanel = new javax.swing.JPanel();
        myBookings = new javax.swing.JLabel();
        previous2 = new javax.swing.JButton();
        bookingScrollPane = new javax.swing.JScrollPane();
        myBookingsTable = new javax.swing.JTable();
        getBooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        myBookingsPanel.setBackground(new java.awt.Color(55, 112, 155));
        myBookingsPanel.setLayout(null);

        myBookings.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myBookings.setForeground(new java.awt.Color(255, 255, 255));
        myBookings.setText("My Bookings");

        myBookingsPanel.add(myBookings);
        myBookings.setBounds(200, 10, 140, 40);

        previous2.setBackground(new java.awt.Color(255, 255, 255));
        previous2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous2.setText("Previous");
        previous2.setBorder(null);
        previous2.setBorderPainted(false);
        previous2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jPanel1.setVisible(true);
                myBookingsPanel.setVisible(false);
            }
        });
        myBookingsPanel.add(previous2);
        previous2.setBounds(3, 555, 40, 20);

        System.out.println("AAAAA");
        ArrayList<Booking> bookings = BookingController.getBookings(loggedInCustomer.getIdAccount());
        System.out.println((loggedInCustomer.getIdAccount()));
  
        System.out.println(bookings.size() +"ertyuj");
        SearchBookingsTableModel model = new SearchBookingsTableModel(bookings);

        myBookingsTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        myBookingsTable.setModel(model);
        myBookingsTable.setRowHeight(20);
        myBookingsTable.setToolTipText("");
        myBookingsTable.setSelectionBackground(new java.awt.Color(0, 204, 0));
        myBookingsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myBookingsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myBookingsTable.setShowGrid(true);
        bookingScrollPane.setViewportView(myBookingsTable);

        myBookingsPanel.add(bookingScrollPane);
        bookingScrollPane.setBounds(20, 90, 480, 390);

        getBooking.setBackground(new java.awt.Color(255, 255, 255));
        getBooking.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        getBooking.setText("Get Booking tickets");
        getBooking.setBorder(null);
        getBooking.setBorderPainted(false);
        getBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
       
        getBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //If a booking is selected
               
                if (!myBookingsTable.getSelectionModel().isSelectionEmpty()) {
                    String stringBookingNo = myBookingsTable.getValueAt(myBookingsTable.getSelectedRow(), 0).toString();
                    int bookingNo = Integer.parseInt(stringBookingNo);

                    selectedBooking = BookingController.getBooking(bookingNo);
                    initMyTickets();
                    myTicketsPanel.setVisible(true);
                    myBookingsPanel.setVisible(false);

                }

            }
        });
        myBookingsPanel.add(getBooking);
        getBooking.setBounds(170, 520, 190, 30);

        getContentPane().add(myBookingsPanel);
        myBookingsPanel.setBounds(0, 0, 530, 580);
        myBookingsPanel.setVisible(false);

      
        myTicketDetailsPanel = new javax.swing.JPanel();
        myTicketDetails = new javax.swing.JLabel();
        previous4 = new javax.swing.JButton();
        to = new javax.swing.JLabel();
        arrivalTimeDate = new javax.swing.JLabel();
        flight = new javax.swing.JLabel();
        to2 = new javax.swing.JLabel();
        arrivalDateTime2 = new javax.swing.JLabel();
        flight2 = new javax.swing.JLabel();
        nameOfPassenger = new javax.swing.JLabel();
        nameOfPasenger2 = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        from2 = new javax.swing.JLabel();
        departureTimeDate = new javax.swing.JLabel();
        departureTimeDate2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        myTicketDetailsPanel.setBackground(new java.awt.Color(55, 112, 155));
        myTicketDetailsPanel.setLayout(null);

        myTicketDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myTicketDetails.setForeground(new java.awt.Color(255, 255, 255));
        myTicketDetails.setText("My Ticket Details");
        myTicketDetailsPanel.add(myTicketDetails);
        myTicketDetails.setBounds(170, 10, 200, 40);

        previous4.setBackground(new java.awt.Color(255, 255, 255));
        previous4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous4.setText("Previous");
        previous4.setBorder(null);
        previous4.setBorderPainted(false);
        previous4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myTicketsPanel.setVisible(true);
                myTicketDetailsPanel.setVisible(false);
            }
        });

    }

    public void initMyTicketDetails() {
        //My Ticket Details

        departureTimeDate2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        departureTimeDate2.setForeground(new java.awt.Color(255, 255, 255));
        departureTimeDate2.setText("jLabel1");
        myTicketDetailsPanel.add(departureTimeDate2);
        departureTimeDate2.setBounds(310, 200, 70, 20);

        to2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        to2.setForeground(new java.awt.Color(255, 255, 255));
        to2.setText("jLabel1");
        myTicketDetailsPanel.add(to2);
        to2.setBounds(60, 260, 70, 20);

        arrivalDateTime2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        arrivalDateTime2.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDateTime2.setText("jLabel1");
        myTicketDetailsPanel.add(arrivalDateTime2);
        arrivalDateTime2.setBounds(310, 260, 70, 20);

        flight2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        flight2.setForeground(new java.awt.Color(255, 255, 255));
        flight2.setText("jLabel1");
        myTicketDetailsPanel.add(flight2);
        flight2.setBounds(310, 130, 70, 20);

        myTicketDetailsPanel.add(previous4);
        previous4.setBounds(3, 555, 60, 20);

        to.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("To");
        myTicketDetailsPanel.add(to);
        to.setBounds(60, 240, 160, 30);

        arrivalTimeDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arrivalTimeDate.setForeground(new java.awt.Color(255, 255, 255));
        arrivalTimeDate.setText("Arrival Date Time");
        myTicketDetailsPanel.add(arrivalTimeDate);
        arrivalTimeDate.setBounds(310, 240, 170, 30);

        flight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        flight.setForeground(new java.awt.Color(255, 255, 255));
        flight.setText("Flight");
        myTicketDetailsPanel.add(flight);
        flight.setBounds(310, 110, 90, 30);

        nameOfPassenger.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nameOfPassenger.setForeground(new java.awt.Color(255, 255, 255));
        nameOfPassenger.setText("Name Of Passenger");
        myTicketDetailsPanel.add(nameOfPassenger);
        nameOfPassenger.setBounds(60, 110, 180, 30);

        from.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        myTicketDetailsPanel.add(from);
        from.setBounds(60, 180, 160, 30);

        departureTimeDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        departureTimeDate.setForeground(new java.awt.Color(255, 255, 255));
        departureTimeDate.setText("Departure Date Time");
        myTicketDetailsPanel.add(departureTimeDate);
        departureTimeDate.setBounds(310, 180, 180, 30);

        from.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        myTicketDetailsPanel.add(from);
        from.setBounds(60, 180, 160, 30);

        nameOfPasenger2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        nameOfPasenger2.setForeground(new java.awt.Color(255, 255, 255));

        System.out.println(selectedTicket);

        if (selectedTicket != null) {
            System.out.println("gegrg");
            nameOfPasenger2.setText(PassengerController.getLastNamePassengerByTicketNo(selectedTicket.getTicketNo()) + " " + PassengerController.getFirstNamePassengerByTicketNo(selectedTicket.getTicketNo()));

        }

        myTicketDetailsPanel.add(nameOfPasenger2);
        nameOfPasenger2.setBounds(60, 130, 70, 20);

        from2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        from2.setForeground(new java.awt.Color(255, 255, 255));

        if (selectedTicket != null) {
            from2.setText(TicketController.getDepartureAirport(selectedTicket.getTicketNo()).toString());
        }

        myTicketDetailsPanel.add(from2);
        from2.setBounds(60, 200, 70, 20);

        getContentPane().add(myTicketDetailsPanel);
        myTicketDetailsPanel.setBounds(0, 0, 570, 580);
        myTicketDetailsPanel.setVisible(false);

    }
    
    public void initMyTickets()
    {
          //My Ticket
        myTicketsPanel = new javax.swing.JPanel();
        myTickets = new javax.swing.JLabel();
        previous3 = new javax.swing.JButton();
        myTicketsScrollPane = new javax.swing.JScrollPane();
        myTicketsTable = new javax.swing.JTable();
        viewTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        myTicketsPanel.setBackground(new java.awt.Color(55, 112, 155));
        myTicketsPanel.setLayout(null);

        myTickets.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myTickets.setForeground(new java.awt.Color(255, 255, 255));
        myTickets.setText("My Tickets");
        myTicketsPanel.add(myTickets);
        myTickets.setBounds(200, 10, 140, 40);

        previous3.setBackground(new java.awt.Color(255, 255, 255));
        previous3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous3.setText("Previous");
        previous3.setBorder(null);
        previous3.setBorderPainted(false);
        previous3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                myBookingsPanel.setVisible(true);
                myTicketsPanel.setVisible(false);

            }
        });
        myTicketsPanel.add(previous3);
        previous3.setBounds(3, 555, 60, 20);

        myTicketsTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        SearchTicketsTableModel model2= new SearchTicketsTableModel(selectedBooking.getBookingNo());
        
        myTicketsTable.setModel(model2);
        myTicketsTable.setRowHeight(20);

        myTicketsTable.setToolTipText("");
        myTicketsTable.setSelectionBackground(new java.awt.Color(0, 204, 0));
        myTicketsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myTicketsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myTicketsTable.setShowGrid(true);
        myTicketsScrollPane.setViewportView(myTicketsTable);

        myTicketsPanel.add(myTicketsScrollPane);
        myTicketsScrollPane.setBounds(20, 90, 480, 390);

        viewTicket.setBackground(new java.awt.Color(255, 255, 255));
        viewTicket.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        viewTicket.setText("Ticket Details");
        viewTicket.setBorder(null);
        viewTicket.setBorderPainted(false);
        viewTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //If a Ticket is selected
                if (!myTicketsTable.getSelectionModel().isSelectionEmpty()) {
                    String stringTicketNo = myTicketsTable.getValueAt(myTicketsTable.getSelectedRow(), 0).toString();

                    int TicketNo = Integer.parseInt(stringTicketNo);

                    selectedTicket = TicketController.getTicket(TicketNo);
                    System.out.println(selectedTicket);

                    myTicketsPanel.setVisible(false);

                    initMyTicketDetails();
                    myTicketDetailsPanel.setVisible(true);

                }

            }
        });

        myTicketsPanel.add(viewTicket);
        viewTicket.setBounds(170, 520, 190, 30);

        getContentPane().add(myTicketsPanel);
        myTicketsPanel.setBounds(0, 0, 530, 580);
        myTicketsPanel.setVisible(false);
    }
}
