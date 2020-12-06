package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class SignUpPanel extends javax.swing.JPanel {
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
   
    private LogInFrame frame;

    
    public SignUpPanel(LogInFrame frame) {
        super();
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        
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

        this.setLayout(null);

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

        add(leftSignUpPanel);
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
                frame.dispose();
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

        add(rightSignUpPanel);
        rightSignUpPanel.setBounds(380, 0, 440, 530);
       
        setSize(new Dimension(822, 526));

    }

}
