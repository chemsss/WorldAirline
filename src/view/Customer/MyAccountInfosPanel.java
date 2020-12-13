package view.Customer;

import model.CustomerAccount;

public class MyAccountInfosPanel extends javax.swing.JPanel {

    ///For My personal info Panel
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel ageCategory;
    private javax.swing.JLabel ageCategory1;
    private javax.swing.JLabel birthDate;
    private com.toedter.calendar.JDateChooser birthDateDate;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel myPersonalInfo;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton save;
    private javax.swing.JTextField telephoneNumberField;
    private javax.swing.JLabel telephoneNumber;
    private javax.swing.JButton previous;

    private final MyAccountFrame frame;
    private final CustomerAccount loggedInCustomer;

    public MyAccountInfosPanel(MyAccountFrame frame, CustomerAccount loggedInCustomer) {
        super();
        this.loggedInCustomer = loggedInCustomer;
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        ageCategory = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        telephoneNumberField = new javax.swing.JTextField();
        birthDateDate = new com.toedter.calendar.JDateChooser();
        passwordField = new javax.swing.JPasswordField();
        myPersonalInfo = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        telephoneNumber = new javax.swing.JLabel();
        ageCategory1 = new javax.swing.JLabel();
        previous = new javax.swing.JButton();

        setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setLayout(null);

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email :");
        this.add(email);
        email.setBounds(80, 110, 70, 30);

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password :");
        this.add(password);
        password.setBounds(80, 160, 100, 30);

        firstName.setBackground(new java.awt.Color(255, 255, 255));
        firstName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setText("First Name :");
        this.add(firstName);
        firstName.setBounds(80, 210, 100, 30);

        lastName.setBackground(new java.awt.Color(255, 255, 255));
        lastName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setText("Last Name :");
        this.add(lastName);
        lastName.setBounds(80, 260, 100, 30);

        address.setBackground(new java.awt.Color(255, 255, 255));
        address.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Address :");
        this.add(address);
        address.setBounds(80, 310, 100, 30);

        birthDate.setBackground(new java.awt.Color(255, 255, 255));
        birthDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        birthDate.setForeground(new java.awt.Color(255, 255, 255));
        birthDate.setText("Birth date :");
        this.add(birthDate);
        birthDate.setBounds(80, 360, 100, 30);

        ageCategory.setBackground(new java.awt.Color(255, 255, 255));
        ageCategory.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        ageCategory.setForeground(new java.awt.Color(255, 255, 255));
        ageCategory.setText(loggedInCustomer.getAgeCategory());
        this.add(ageCategory);
        ageCategory.setBounds(270, 460, 110, 30);

        emailField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));
        emailField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        emailField.setText(loggedInCustomer.getEmail());
        this.add(emailField);
        emailField.setBounds(270, 111, 160, 35);

        firstNameField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(51, 51, 51));
        firstNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        firstNameField.setText(loggedInCustomer.getFirstName());
        this.add(firstNameField);
        firstNameField.setBounds(270, 211, 160, 35);

        lastNameField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));
        lastNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lastNameField.setText(loggedInCustomer.getLastName());
        this.add(lastNameField);
        lastNameField.setBounds(270, 261, 160, 35);

        addressField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        addressField.setForeground(new java.awt.Color(51, 51, 51));
        addressField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        addressField.setText(loggedInCustomer.getAddress());
        this.add(addressField);
        addressField.setBounds(270, 311, 160, 35);

        telephoneNumberField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        telephoneNumberField.setForeground(new java.awt.Color(51, 51, 51));
        telephoneNumberField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        telephoneNumberField.setText(loggedInCustomer.getTelephoneNumber());
        this.add(telephoneNumberField);
        telephoneNumberField.setBounds(270, 411, 160, 35);

        birthDateDate.setDate(loggedInCustomer.getBirthDate());
        birthDateDate.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        this.add(birthDateDate);

        birthDateDate.setBounds(272, 362, 160, 33);

        passwordField.setFont(new java.awt.Font("Segoe UI Plain", 0, 12)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        passwordField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        this.add(passwordField);
        passwordField.setBounds(270, 161, 160, 35);

        myPersonalInfo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myPersonalInfo.setForeground(new java.awt.Color(255, 255, 255));
        myPersonalInfo.setText("My Personal Information");

        this.add(myPersonalInfo);
        myPersonalInfo.setBounds(130, 20, 260, 30);

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        save.setText("Save");
        save.setBorder(null);
        save.setBorderPainted(false);
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //if PAS DE PB =>save

                /*
                
                 */
                //else mssg erreur
            }
        });
        this.add(save);
        save.setBounds(210, 530, 90, 30);

        telephoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        telephoneNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        telephoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        telephoneNumber.setText("Telephone number :");
        this.add(telephoneNumber);
        telephoneNumber.setBounds(80, 410, 170, 30);

        ageCategory1.setBackground(new java.awt.Color(255, 255, 255));
        ageCategory1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        ageCategory1.setForeground(new java.awt.Color(255, 255, 255));
        ageCategory1.setText("Age category :");
        this.add(ageCategory1);
        ageCategory1.setBounds(80, 460, 170, 30);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(null);
        previous.setBorderPainted(false);
        previous.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                
                frame.getMyAccountPanel().setVisible(true);   

                setVisible(false);
            }
        });

        this.add(previous);
        previous.setBounds(3, 555, 40, 20);

        this.setBounds(0, 0, 530, 580);

    }

}
