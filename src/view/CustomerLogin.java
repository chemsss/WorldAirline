package view;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerLogin extends JFrame {

    private JButton jButton1, jButton2, jButton3;
    private JLabel jLabel1, jLabel2, jLabel3;
    private JPanel jPanel1, jPanel2;
    private JTextField jTextField2;
    private JPasswordField password;

    private ActionListener controller;

    public CustomerLogin() {
        super("Customer login");

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jPanel2 = new JPanel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jLabel2 = new JLabel();
        
        password = new JPasswordField("Password");

        controller = new CustomerLoginChoice(this); // création du controller
        initCustomerLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void initCustomerLogin() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(0, 181, 204));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon("img\\plane_white.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 120, 270, 190);

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(new Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("WorldAirline");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 400, 240, 48);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 530);

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        jLabel2.setForeground(new Color(0, 181, 204));
        jLabel2.setText("X");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(410, 0, 30, 40);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });

        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                password.setText("");
            }
        });
        jPanel2.add(password);
        password.setBounds(70, 220, 270, 60);

        jTextField2.setFont(new Font("Segoe UI Light", 0, 20)); // NOI18N
        jTextField2.setForeground(new Color(51, 51, 51));
        jTextField2.setText("Enter email adress...");
        jTextField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        jTextField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField2.setText("");
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(70, 100, 270, 50);

        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Or Continue as guest");
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(280, 490, 150, 30);

        jButton2.setBackground(new Color(0, 181, 204));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton2.setBorderPainted(false);
        
        jButton2.addActionListener(controller);
        jButton2.setActionCommand("Login");
        
        jButton2.setFocusPainted(false);


        jPanel2.add(jButton2);
        jButton2.setBounds(80, 410, 130, 40);

        jButton3.setBackground(new Color(0, 181, 204));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Sign up");
        jButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(controller);
        jButton3.setActionCommand("Sign up");
        jButton3.setFocusPainted(false);
        jPanel2.add(jButton3);
        jButton3.setBounds(230, 410, 130, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 0, 440, 530);

        setSize(new Dimension(822, 526));
        setLocationRelativeTo(null);
    }

    public String[] getEntry() {
        String[] list = new String[2];
        list[0] = jTextField2.getText();
        list[1] = String.valueOf(password.getPassword()); //char[] to String
        return list;
    }
}