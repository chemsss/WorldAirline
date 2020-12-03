package view;

import controller.BookingController;
import controller.CustomerController;
import controller.SearchBookingsTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Booking;
import model.CustomerAccount;

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
   
    
    private CustomerAccount loggedInCustomer;

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
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        booking.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel1.setVisible(false);
                myBookingsPanel.setVisible(true);
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
        personalInfo.addActionListener(new ActionListener()
        {
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
        ageCategory.setText("Age category");
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
        myBookingsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

    /*    ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(new FlightDAOImpl().find(5));
        flights.add(new FlightDAOImpl().find(6));
        System.out.println(flights.get(0).getIdFlight());*/
        
         ArrayList<Booking> bookings = BookingController.getBookings(loggedInCustomer.getIdAccount());
        SearchBookingsTableModel model = new SearchBookingsTableModel(bookings);
        myBookingsTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        myBookingsTable.setModel(model);
        
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
            }
        });
        myBookingsPanel.add(getBooking);
        getBooking.setBounds(170, 520, 190, 30);

        
        getContentPane().add(myBookingsPanel);
        myBookingsPanel.setBounds(0, 0, 530, 580);
        myBookingsPanel.setVisible(false);
        
        pack();
    }

}
