package view.Employee;


import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class EmployeeHome extends javax.swing.JFrame {

    private javax.swing.JMenuItem AddCoupon;
    private javax.swing.JMenuItem AddFlight;
    private javax.swing.JMenuItem DeleteBooking;
    private javax.swing.JMenu ManageCoupons;
    private javax.swing.JMenuItem SearchCoupon;
    private javax.swing.JMenuItem SearchFlight;
    private javax.swing.JMenuItem UpdateBooking;
    private javax.swing.JMenuItem Update_DeleteFlight;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu manageBookings;
    private javax.swing.JMenu manageFlight;
    private javax.swing.JMenuBar menuBar;
    
    private javax.swing.JMenu chartStatistics;
    private javax.swing.JMenuItem flightsPerMonth; 
    private javax.swing.JMenuItem pieDestinations;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeHome() {
        jPanel2 = new JPanel();

        initComponents();
        setExtendedState(Frame.MAXIMIZED_BOTH);

        this.setVisible(true);

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        menuBar = new javax.swing.JMenuBar();
        manageFlight = new javax.swing.JMenu();
        SearchFlight = new javax.swing.JMenuItem();
        AddFlight = new javax.swing.JMenuItem();
        Update_DeleteFlight = new javax.swing.JMenuItem();
        manageBookings = new javax.swing.JMenu();
        UpdateBooking = new javax.swing.JMenuItem();
        DeleteBooking = new javax.swing.JMenuItem();
        ManageCoupons = new javax.swing.JMenu();
        AddCoupon = new javax.swing.JMenuItem();
        SearchCoupon = new javax.swing.JMenuItem();
        
        chartStatistics = new javax.swing.JMenu();
        flightsPerMonth = new javax.swing.JMenuItem();
        pieDestinations = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(55, 112, 155));
        jPanel1.setLayout(null);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, screenWidth, screenHeight);

        manageFlight.setText("Manage flights");
        manageFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        manageFlight.setBackground(new java.awt.Color(255, 255, 255));

        SearchFlight.setText("Search Flight");
        SearchFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        SearchFlight.setToolTipText("");
        SearchFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeFlightSearch();
                initComponents();
                setSize(screenWidth, screenHeight);
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });
        manageFlight.add(SearchFlight);

        AddFlight.setText("Add Flight");

        AddFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        AddFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeAddFlight();
                initComponents();
                setSize(screenWidth, screenHeight);
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });
        manageFlight.add(AddFlight);

        Update_DeleteFlight.setText("Update/Delete Flight");
        Update_DeleteFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        Update_DeleteFlight.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                 jPanel2 = new EmployeeManageFlight();
   
                initComponents();
                setSize(screenWidth, screenHeight);
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });

        manageFlight.add(Update_DeleteFlight);

        menuBar.add(manageFlight);
        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setOpaque(true);
        manageBookings.setText("Manage bookings");
        manageBookings.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        manageBookings.setBackground(new java.awt.Color(255, 255, 255));

        UpdateBooking.setText("SearchBooking");
        UpdateBooking.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        manageBookings.add(UpdateBooking);
        UpdateBooking.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeBookingSearch();
                initComponents();
                setSize(screenWidth, screenHeight);
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });

        DeleteBooking.setText("Update/Delete Booking");
        DeleteBooking.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        manageBookings.add(DeleteBooking);
        DeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeManageBooking();
                initComponents();
                setSize(screenWidth, screenHeight);
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });

        menuBar.add(manageBookings);

        ManageCoupons.setText("Manage coupons");
        ManageCoupons.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        ManageCoupons.setBackground(new java.awt.Color(255, 255, 255));

        AddCoupon.setText("Add Coupon");
        AddCoupon.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        AddCoupon.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeAddCoupon();
                initComponents();
                setSize(screenWidth, screenHeight);   
                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });

        ManageCoupons.add(AddCoupon);

        SearchCoupon.setText("Search/Delete Coupon");
        SearchCoupon.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        SearchCoupon.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
               jPanel2 = new EmployeeManageCoupon();
                initComponents();
                setSize(screenWidth, screenHeight);
                                setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });
        ManageCoupons.add(SearchCoupon);

        menuBar.add(ManageCoupons);
        
        
        chartStatistics.setText("Statistics");
        
        flightsPerMonth.setText("Number of flights according to month");
        flightsPerMonth.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeChartFlightsPerMonth();
                initComponents();
                setSize(screenWidth ,screenHeight);
                jPanel2.setSize(screenWidth ,screenHeight);
                jPanel2.setBounds(0 , 0, screenWidth ,screenHeight);
                                        

            }
        });
        chartStatistics.add(flightsPerMonth);
        
        
        pieDestinations.setText("Most chosen destinations");
        pieDestinations.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getContentPane().removeAll();
                jPanel2 = new EmployeeChartPieDestination();
                initComponents();
                setSize(screenWidth ,screenHeight);
                jPanel2.setSize(screenWidth ,screenHeight);
                jPanel2.setBounds(0 , 0, screenWidth ,screenHeight);
                                        

            }
        });
        chartStatistics.add(pieDestinations);
        
        
        menuBar.add(chartStatistics);
        

        setJMenuBar(menuBar);

        jPanel1.add(jPanel2);

        pack();
    }

}
