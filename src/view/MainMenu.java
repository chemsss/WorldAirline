package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//First screen Menu
public final class MainMenu extends JFrame {

    JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    JButton jButton1, jButton2, jButton3, jButton4;
    JTextField jTextField1;
    
    private final ActionListener controller;

    public MainMenu() {
        super("worldAirline");

        jLabel4 = new JLabel();
        jButton4 = new JButton();
        jButton2 = new JButton();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton3 = new JButton();
        jButton1 = new JButton();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();

     controller = new MainMenuChoice(this); // création du controller

        initMainMenu();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1068, 601);
        this.setLocationRelativeTo(null);
    }

    public void initMainMenu() {

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI ", 0, 20)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Hello travelers. Where would you like to go? ");
              
        contentPane.add(jLabel4);
        jLabel4.setBounds(310, 100, 410, 50);

        jButton4.setBackground(new Color(55,112,155));
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setText("Contacts");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(controller);
        jButton4.setActionCommand("Contacts");
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        
        
        contentPane.add(jButton4);
        jButton4.setBounds(850, 530, 100, 23);

        
        jButton2.setText("Subscribe");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(controller);
        jButton2.setActionCommand("Subscribe");
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        jButton2.setBackground(new Color(55,112,155));
        jButton2.setForeground(new Color(255, 255, 255));
       
        contentPane.add(jButton2);
        jButton2.setBounds(150, 530, 100, 23);
  
       

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)

        jLabel3.setText("Subscribe to our Newletter :");

        contentPane.add(jLabel3);
        jLabel3.setBounds(10, 510, 150, 13);

        jTextField1.setText("peter@gmail.com");
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)
     
       
        contentPane.add(jTextField1);
        jTextField1.setBounds(10, 527, 130, 28);
 
        jButton3.setBackground(new Color(55,112,155));
        jButton3.setForeground(new Color(255,255, 255));
        jButton3.setText("Book a Flight !");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(controller);
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N)

        jButton3.setActionCommand("Book a Flight !"); 
        getContentPane().add(jButton3);
        jButton3.setBounds(430, 220, 170, 90);

        jButton1.setBackground(new Color(255, 0, 0));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Admin");
        jButton1.setFocusPainted(false);
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)

        jButton1.addActionListener(controller);
        jButton1.setActionCommand("Admin");
        getContentPane().add(jButton1);
        jButton1.setBounds(970, 530, 73, 23);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome to WorldAirline !");
        contentPane.add(jLabel2);
        jLabel2.setBounds(60, 20, 920, 70);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon("img\\airplane.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(null);
       
        contentPane.add(jLabel1);
        jLabel1.setBounds(0, 0, 1068, 601);

        pack();
      
    }
}
