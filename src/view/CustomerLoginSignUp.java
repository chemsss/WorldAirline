package view;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;

public final class CustomerLoginSignUp extends JFrame {

    //Login Panel
    private final JButton jButton1, jButton2, jButton3;
    private final JLabel jLabel1, jLabel2, jLabel3;
    private final JPanel jPanel1, jPanel2;
    private final JTextField jTextField2;
    private final JPasswordField password;

    //SignUp Panel
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel birthDate;
    private javax.swing.JLabel close;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel airplaneImage;
    private javax.swing.JLabel worldAirline;
    private javax.swing.JPanel leftSignUpPanel;
    private javax.swing.JPanel rightSignUpPanel;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel signUpPassword;
    private javax.swing.JPasswordField signUpPasswordField;
    private javax.swing.JTextField telephoneNumberField;
    private javax.swing.JLabel telephoneNumber;
    private com.toedter.calendar.JDateChooser birthDateDate;

    private MainMenu frame;

    public CustomerLoginSignUp(MainMenu frame) {
        //Login
        this.frame = frame;
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


        initCustomerLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public CustomerLoginSignUp() {

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

        initCustomerLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void initCustomerLogin() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(55, 112, 155));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new ImageIcon("img\\airplane_127px.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 120, 270, 190);

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
        jLabel2.setForeground(new Color(55, 112, 155));
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

        if (frame == null) {
            jButton1.setVisible(false);
        }
        jButton1.setBackground(new Color(255, 255, 255));
        jButton1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Or Continue as guest");
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                frame.dispose();
                new CustomerHomeFlightSearch(null);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(280, 490, 150, 30);

        jButton2.setBackground(new Color(55, 112, 155));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton2.setBorderPainted(false);

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (new CustomerController().CustomerLoginConnection(jTextField2.getText(), getMD5Hash(String.valueOf(password.getPassword()))) == true) {
                    frame.dispose();
                    new CustomerHomeFlightSearch(new CustomerController().getCustomerAccount(jTextField2.getText(), getMD5Hash(String.valueOf(password.getPassword()))));
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong email/password, please retry ", "", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        //jButton2.setActionCommand("Login");

        jButton2.setFocusPainted(false);

        jPanel2.add(jButton2);
        jButton2.setBounds(80, 410, 130, 40);

        jButton3.setBackground(new Color(55, 112, 155));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Sign up");
        jButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton3.setBorderPainted(false);
       // jButton3.addActionListener(controller);
        jButton3.setActionCommand("Sign up");
        
        jButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                jPanel2.setVisible(false);
                initSignUp();  
            }


        }
        
        );
        jButton3.setFocusPainted(false);
        jPanel2.add(jButton3);
        jButton3.setBounds(230, 410, 130, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 0, 440, 530);

        setSize(new Dimension(822, 526));
        setLocationRelativeTo(null);
    }

    public void initSignUp() {
        leftSignUpPanel = new javax.swing.JPanel();
        airplaneImage = new javax.swing.JLabel();
        worldAirline = new javax.swing.JLabel();
        rightSignUpPanel = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        email1 = new javax.swing.JLabel();
        signUpPassword = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        telephoneNumber = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        telephoneNumberField = new javax.swing.JTextField();

        birthDateDate = new com.toedter.calendar.JDateChooser();
        signUpPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        leftSignUpPanel.setBackground(new java.awt.Color(55, 112, 155));
        leftSignUpPanel.setLayout(null);

        airplaneImage.setIcon(new javax.swing.ImageIcon("img\\airplane_127px.png"));
        leftSignUpPanel.add(airplaneImage);
        airplaneImage.setBounds(110, 100, 280, 260);

        worldAirline.setBackground(new java.awt.Color(255, 255, 255));
        worldAirline.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        worldAirline.setForeground(new java.awt.Color(255, 255, 255));
        worldAirline.setText("WorldAirline");
        leftSignUpPanel.add(worldAirline);
        worldAirline.setBounds(80, 400, 240, 48);

        getContentPane().add(leftSignUpPanel);
        leftSignUpPanel.setBounds(0, 0, 380, 530);

        rightSignUpPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSignUpPanel.setLayout(null);

        close.setBackground(new Color(255, 255, 255));
        close.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        close.setForeground(new Color(55, 112, 155));
        close.setText("X");
        rightSignUpPanel.add(close);
        close.setBounds(410, 0, 30, 40);

        close.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });
        rightSignUpPanel.add(close);
        close.setBounds(410, 0, 30, 40);

        signUpButton.setBackground(new java.awt.Color(55, 112, 155));
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Signup");
        signUpButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        signUpButton.setBorderPainted(false);
        rightSignUpPanel.add(signUpButton);
      //A FAIRE  signUpButton.addActionListener(this);

        signUpButton.setBounds(160, 450, 130, 40);

        email1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        email1.setText("Email :");
        rightSignUpPanel.add(email1);
        email1.setBounds(40, 50, 70, 30);

        signUpPassword.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        signUpPassword.setText("Password :");
        rightSignUpPanel.add(signUpPassword);
        signUpPassword.setBounds(40, 100, 100, 30);

        firstName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        firstName.setText("First Name :");
        rightSignUpPanel.add(firstName);
        firstName.setBounds(40, 150, 100, 30);

        lastName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        lastName.setText("Last Name :");
        rightSignUpPanel.add(lastName);
        lastName.setBounds(40, 200, 100, 30);

        address.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        address.setText("Address :");
        rightSignUpPanel.add(address);
        address.setBounds(40, 250, 100, 30);

        birthDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        birthDate.setText("Birth date :");
        rightSignUpPanel.add(birthDate);
        birthDate.setBounds(40, 300, 100, 30);

        telephoneNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        telephoneNumber.setText("Telephone number :");
        rightSignUpPanel.add(telephoneNumber);
        telephoneNumber.setBounds(40, 350, 170, 30);

        emailField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));

        rightSignUpPanel.add(emailField);
        emailField.setBounds(230, 52, 130, 32);

        signUpPasswordField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        signUpPasswordField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rightSignUpPanel.add(signUpPasswordField);
        signUpPasswordField.setBounds(230, 102, 130, 32);

        firstNameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(51, 51, 51));

        rightSignUpPanel.add(firstNameField);
        firstNameField.setBounds(230, 152, 130, 32);

        lastNameField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));

        rightSignUpPanel.add(lastNameField);
        lastNameField.setBounds(230, 202, 130, 32);

        addressField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        addressField.setForeground(new java.awt.Color(51, 51, 51));

        rightSignUpPanel.add(addressField);
        addressField.setBounds(230, 252, 130, 32);

        rightSignUpPanel.add(birthDateDate);
        birthDateDate.setBounds(230, 302, 130, 32);

        telephoneNumberField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        telephoneNumberField.setForeground(new java.awt.Color(51, 51, 51));

        rightSignUpPanel.add(telephoneNumberField);
        telephoneNumberField.setBounds(230, 352, 130, 32);

        getContentPane().add(rightSignUpPanel);
        rightSignUpPanel.setBounds(380, 0, 440, 530);

        setSize(new java.awt.Dimension(822, 526));
        setLocationRelativeTo(null);
    }

    public String[] getEntry() {
        String[] list = new String[2];
        list[0] = jTextField2.getText();
        list[1] = String.valueOf(password.getPassword()); //char[] to String
        return list;
    }

    public static String getMD5Hash(String s) {

        String result = s;
        try {
            if (s != null) {
                MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1" 
                md.update(s.getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                result = hash.toString(16);
                while (result.length() < 32) { // 40 for SHA-1 
                    result = "0" + result;
                }
            }

        } catch (NoSuchAlgorithmException e) {

        }
        return result;

    }
}

