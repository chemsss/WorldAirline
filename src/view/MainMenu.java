package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//First screen Menu
public final class MainMenu extends JFrame {

   private JLabel  title, subscribeNewsletter, subTitle,worldImage;
    private JButton admin, subscribe, bookFlight, contact;
    private JTextField email;
    private javax.swing.JLabel airplaneImg;
    private javax.swing.JLabel cloudImg;
    private javax.swing.JLabel cloudImg2;

    private final ActionListener controller;

    public MainMenu() {
        super("WorldAirline");
        subTitle = new JLabel();
        contact = new JButton();
        subscribe = new JButton();
        subscribeNewsletter = new JLabel();
        email = new JTextField();
        bookFlight = new JButton();
        admin = new JButton();
        title = new JLabel();
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
        subTitle.setFont(new java.awt.Font("Yu Gothic UI ", 0, 20)); // NOI18N
        subTitle.setForeground(new Color(255, 255, 255));
        subTitle.setText("Hello travelers. Where would you like to go? ");

        contentPane.add(subTitle);
        subTitle.setBounds(310, 100, 410, 50);

        contact.setBackground(new Color(0, 204, 0));
        contact.setForeground(new Color(255, 255, 255));
        contact.setText("Contacts");
        contact.setFocusPainted(false);
        contact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        contact.addActionListener(controller);
        contact.setActionCommand("Contact");
        contact.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N)

        contentPane.add(contact);
        contact.setBounds(843, 530, 100, 23);

        subscribe.setText("Subscribe");
        subscribe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        subscribe.setFocusPainted(false);
        subscribe.addActionListener(controller);
        subscribe.setActionCommand("Subscribe");
        subscribe.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        subscribe.setBackground(new Color(255, 255, 255));
        subscribe.setForeground(new Color(0, 0, 0));

        contentPane.add(subscribe);
        subscribe.setBounds(150, 530, 100, 23);

        subscribeNewsletter.setForeground(new Color(255, 255, 255));
        subscribeNewsletter.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)
        subscribeNewsletter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subscribeNewsletter.setText("Subscribe to our Newsletter :");

        contentPane.add(subscribeNewsletter);
        subscribeNewsletter.setBounds(10, 510, 150, 13);

        email.setText("peter@gmail.com");
        email.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email.setText("");
            }
        });
        email.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N)

        contentPane.add(email);
        email.setBounds(10, 528, 130, 25);

        bookFlight.setBackground(new Color(255, 255, 255));
        bookFlight.setForeground(new Color(0, 0, 0));
        bookFlight.setText("Book a Flight !");
        bookFlight.setFocusPainted(false);
        bookFlight.addActionListener(controller);
        bookFlight.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N)

        bookFlight.setActionCommand("Book a Flight !");       
        bookFlight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        getContentPane().add(bookFlight);
        bookFlight.setBounds(430, 220, 170, 90);

        admin.setBackground(new Color(255, 0, 0));
        admin.setForeground(new Color(255, 255, 255));
        admin.setText("Admin");
        admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin.setFocusPainted(false);
        admin.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N)
        admin.addActionListener(controller);
        admin.setActionCommand("Admin");
        getContentPane().add(admin);
        admin.setBounds(960, 530, 100, 23);

        title.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N
        title.setForeground(new Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Welcome to WorldAirline !");
        contentPane.add(title);
        title.setBounds(60, 20, 920, 70);

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
