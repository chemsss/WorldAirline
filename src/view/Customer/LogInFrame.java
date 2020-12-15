package view.Customer;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import view.MainMenu;

public final class LogInFrame extends JFrame {

    //Login Panel
    private final JButton continueAsGuest, login, signUp;
    private final JLabel airplaneImg, close, title;
    private final JPanel leftPanel, rightPanel2;
    private final JTextField email;
    private final JPasswordField password;

    //Jpanel SignUp
    private JPanel signUpPanel;

    private MainMenu frame;

    public LogInFrame(MainMenu frame) {

        this.frame = frame;

        leftPanel = new JPanel();
        airplaneImg = new JLabel();
        title = new JLabel();
        rightPanel2 = new JPanel();
        email = new JTextField();
        continueAsGuest = new JButton();
        login = new JButton();
        signUp = new JButton();
        close = new JLabel();
        password = new JPasswordField("Password");

        initCustomerLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(822, 526));

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public LogInFrame() {

        leftPanel = new JPanel();
        airplaneImg = new JLabel();
        title = new JLabel();
        rightPanel2 = new JPanel();
        email = new JTextField();
        continueAsGuest = new JButton();
        login = new JButton();
        signUp = new JButton();
        close = new JLabel();
        password = new JPasswordField("Password");

        initCustomerLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(822, 526));

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        frame = new MainMenu();
        frame.setVisible(false);
        

    }

    public void initCustomerLogin() {

        setUndecorated(true);

        getContentPane().setLayout(null);

        leftPanel.setBackground(new Color(55, 112, 155));
        leftPanel.setLayout(null);

        airplaneImg.setIcon(new ImageIcon("img\\airplane_127px.png")); // NOI18N
        leftPanel.add(airplaneImg);
        airplaneImg.setBounds(110, 120, 270, 190);

        title.setBackground(new Color(255, 255, 255));
        title.setFont(new Font("Segoe UI Light", 0, 36)); // NOI18N
        title.setForeground(new Color(255, 255, 255));
        title.setText("WorldAirline");
        leftPanel.add(title);
        title.setBounds(80, 400, 240, 48);

        getContentPane().add(leftPanel);
        leftPanel.setBounds(0, 0, 380, 530);

        rightPanel2.setBackground(new Color(255, 255, 255));
        rightPanel2.setLayout(null);

        close.setBackground(new Color(255, 255, 255));
        close.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        close.setForeground(new Color(55, 112, 155));
        close.setText("X");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rightPanel2.add(close);
        close.setBounds(410, 0, 30, 40);

        close.addMouseListener(new java.awt.event.MouseAdapter() {
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
        rightPanel2.add(password);
        password.setBounds(70, 220, 270, 60);

        email.setFont(new Font("Segoe UI Light", 0, 20)); // NOI18N
        email.setForeground(new Color(51, 51, 51));
        email.setText("Enter email adress...");
        email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        email.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email.setText("");
            }
        });
        rightPanel2.add(email);
        email.setBounds(70, 100, 270, 50);

        if (frame == null) {
            continueAsGuest.setVisible(false);
        }
        continueAsGuest.setBackground(new Color(255, 255, 255));
        continueAsGuest.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        continueAsGuest.setText("Or Continue as guest");
        continueAsGuest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        continueAsGuest.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        continueAsGuest.setBorderPainted(false);
        continueAsGuest.setFocusPainted(false);
        continueAsGuest.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
                frame.dispose();
                new CustomerHome(null);
            }
        });
        rightPanel2.add(continueAsGuest);
        continueAsGuest.setBounds(280, 490, 150, 30);

        login.setBackground(new Color(55, 112, 155));
        login.setForeground(new Color(255, 255, 255));
        login.setText("Login");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        login.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        login.setBorderPainted(false);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (new CustomerController().CustomerLoginConnection(email.getText(), FieldsController.getMD5Hash(String.valueOf(password.getPassword()))) == true) {
                    frame.dispose();
                    dispose();
                    new CustomerHome(new CustomerController().getCustomerAccount(email.getText(), FieldsController.getMD5Hash(String.valueOf(password.getPassword()))));
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong email/password, please retry ", "", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        login.setFocusPainted(false);

        rightPanel2.add(login);
        login.setBounds(80, 410, 130, 40);

        signUp.setBackground(new Color(55, 112, 155));
        signUp.setForeground(new Color(255, 255, 255));
        signUp.setText("Sign up");
        signUp.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        signUp.setBorderPainted(false);
        signUp.setActionCommand("Sign up");
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LogInFrame loginFrame = this;
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rightPanel2.setVisible(false);
                getContentPane().repaint();

                signUpPanel = new SignUpPanel(loginFrame);
                getContentPane().add(signUpPanel);

                signUpPanel.setVisible(true);

            }

        }
        );
        signUp.setFocusPainted(false);
        rightPanel2.add(signUp);
        signUp.setBounds(230, 410, 130, 40);

        getContentPane().add(rightPanel2);
        rightPanel2.setBounds(380, 0, 440, 530);

        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

    }

    
    }

    

