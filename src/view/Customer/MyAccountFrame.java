package view.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.CustomerAccount;

public class MyAccountFrame extends javax.swing.JFrame {

    private javax.swing.JPanel myAccountPanel;

    public JPanel getMyAccountPanel() {
        return myAccountPanel;
    }
    
    private javax.swing.JLabel myAccount;
    private javax.swing.JButton booking;
    private javax.swing.JButton personalInfo;

    //My Personal Information Panel
    JPanel myAccountInfos;

    //My bookings 
    JPanel MyBookings;

    private CustomerAccount loggedInCustomer;

    public MyAccountFrame(CustomerAccount loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
        myAccountInfos = new MyAccountInfosPanel(this, this.loggedInCustomer);
        initComponents();
        this.setSize(530, 615);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {

        JPanel MyBookings = new MyBookingsPanel(this,loggedInCustomer);
        myAccountPanel = new javax.swing.JPanel();
        myAccount = new javax.swing.JLabel();
        booking = new javax.swing.JButton();
        personalInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);

        myAccountPanel.setBackground(new java.awt.Color(55, 112, 155));
        myAccountPanel.setLayout(null);

        myAccount.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myAccount.setForeground(new java.awt.Color(255, 255, 255));
        myAccount.setIcon(new javax.swing.ImageIcon("img\\male_user_90px.png")); // NOI18N
        myAccount.setText("My Account");
        myAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myAccountPanel.add(myAccount);
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
               
                
                myAccountPanel.setVisible(false);
                getContentPane().repaint();
                getContentPane().add(MyBookings);
                MyBookings.setVisible(true);

            }

        });

        myAccountPanel.add(booking);
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
                
                myAccountPanel.setVisible(false);
                getContentPane().repaint();
                getContentPane().add(myAccountInfos);
              
                myAccountInfos.setVisible(true);

            }

        });

        myAccountPanel.add(personalInfo);
        personalInfo.setBounds(140, 230, 230, 40);

        getContentPane().add(myAccountPanel);
        myAccountPanel.setBounds(0, 0, 530, 580);

        setBackground(new java.awt.Color(55, 112, 155));
        getContentPane().setLayout(null);
        
  

    }

     public JPanel getMyBookings() {
        return MyBookings;
    }

}
