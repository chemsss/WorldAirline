package view;

import model.CustomerAccount;

public class MyAccount extends javax.swing.JFrame {

    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel myAccount;
    private javax.swing.JButton personalInfo;
    private javax.swing.JButton personalInfo1;
    
    private CustomerAccount loggedInCustomer;
    
    public MyAccount(CustomerAccount loggedInCustomer) {
        this.loggedInCustomer=loggedInCustomer;
        initComponents();
        this.setSize(530, 510);

        this.setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myAccount = new javax.swing.JLabel();
        personalInfo = new javax.swing.JButton();
        personalInfo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(55, 112, 155));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(null);

        myAccount.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myAccount.setForeground(new java.awt.Color(255, 255, 255));
        myAccount.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\user_white.png")); // NOI18N
        myAccount.setText("My Account");
        myAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(myAccount);
        myAccount.setBounds(190, 20, 160, 150);

        personalInfo.setBackground(new java.awt.Color(255, 255, 255));
        personalInfo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        personalInfo.setText("My Bookings");
        personalInfo.setBorder(null);
        personalInfo.setBorderPainted(false);
        personalInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.add(personalInfo);
        personalInfo.setBounds(140, 300, 230, 40);

        personalInfo1.setBackground(new java.awt.Color(255, 255, 255));
        personalInfo1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        personalInfo1.setText("My Personal Information");
        personalInfo1.setBorder(null);
        personalInfo1.setBorderPainted(false);
        personalInfo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.add(personalInfo1);
        personalInfo1.setBounds(140, 230, 230, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 510);

        pack();
    }                        
          
}
