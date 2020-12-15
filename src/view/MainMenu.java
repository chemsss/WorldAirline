package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//First screen Menu
public final class MainMenu extends JFrame {

    JLabel jLabel1, jLabel2, jLabel3, jLabel4,worldImage;
    JButton jButton1, jButton2, jButton3, jButton4;
    JTextField jTextField1;
    private javax.swing.JLabel airplaneImg;
    private javax.swing.JLabel cloudImg;
    private javax.swing.JLabel cloudImg2;

    private final ActionListener controller;

    public MainMenu() {
        super("WorldAirline");
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
        cloudImg = new javax.swing.JLabel();
        cloudImg2 = new javax.swing.JLabel();
        airplaneImg = new javax.swing.JLabel();
        initMainMenu();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1080, 601);
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

        jButton4.setBackground(new Color(0, 204, 0));
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setText("Contacts");
        jButton4.setFocusPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.addActionListener(controller);
        jButton4.setActionCommand("Contacts");
        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N)

        contentPane.add(jButton4);
        jButton4.setBounds(843, 530, 100, 23);

        jButton2.setText("Subscribe");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setFocusPainted(false);
        jButton2.addActionListener(controller);
        jButton2.setActionCommand("Subscribe");
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        jButton2.setBackground(new Color(255, 255, 255));
        jButton2.setForeground(new Color(0, 0, 0));

        contentPane.add(jButton2);
        jButton2.setBounds(150, 530, 100, 23);

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setText("Subscribe to our Newletter :");

        contentPane.add(jLabel3);
        jLabel3.setBounds(10, 510, 150, 13);

        jTextField1.setText("peter@gmail.com");
        jTextField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField1.setText("");
            }
        });
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)

        contentPane.add(jTextField1);
        jTextField1.setBounds(10, 528, 130, 25);

        jButton3.setBackground(new Color(255, 255, 255));
        jButton3.setForeground(new Color(0, 0, 0));
        jButton3.setText("Book a Flight !");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(controller);
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N)

        jButton3.setActionCommand("Book a Flight !");       
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        getContentPane().add(jButton3);
        jButton3.setBounds(430, 220, 170, 90);

        jButton1.setBackground(new Color(255, 0, 0));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Admin");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        jButton1.addActionListener(controller);
        jButton1.setActionCommand("Admin");
        getContentPane().add(jButton1);
        jButton1.setBounds(960, 530, 100, 23);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome to WorldAirline !");
        contentPane.add(jLabel2);
        jLabel2.setBounds(60, 20, 920, 70);

        cloudImg.setIcon(new javax.swing.ImageIcon("img\\cloud_127px.png")); // NOI18N
        getContentPane().add(cloudImg);
        cloudImg.setBounds(840, 270, 130, 140);

        cloudImg2.setIcon(new javax.swing.ImageIcon("img\\cloud_127px.png")); // NOI18N
        getContentPane().add(cloudImg2);
        cloudImg2.setBounds(50, 190, 130, 140);

        airplaneImg.setIcon(new javax.swing.ImageIcon("img\\airplane_mode_on_127px.png")); // NOI18N
        getContentPane().add(airplaneImg);
        airplaneImg.setBounds(460, 390, 130, 140);
        contentPane.setBackground((new Color(55, 112, 155)));

        pack();

    }
}
