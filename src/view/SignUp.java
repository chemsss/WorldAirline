package view;

public class SignUp extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JLabel adress;
    private javax.swing.JTextField adressField;
    private javax.swing.JLabel birthDate;
    private javax.swing.JTextField birthDateField;
    private javax.swing.JLabel close;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel password1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField telephoneNulberField;
    private javax.swing.JLabel telephoneNumber;

    public SignUp() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        email1 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        firstName = new javax.swing.JLabel();
        lastName = new javax.swing.JLabel();
        adress = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        telephoneNumber = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        adressField = new javax.swing.JTextField();
        birthDateField = new javax.swing.JTextField();
        telephoneNulberField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("img\\plane_white.png"));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 100, 280, 260);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("WorldAirline");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 400, 240, 48);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 530);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        close.setForeground(new java.awt.Color(0, 181, 204));
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {

                dispose();

            }
        });
        jPanel2.add(close);
        close.setBounds(410, 0, 30, 40);

        jButton3.setBackground(new java.awt.Color(0, 181, 204));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Signup");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        jButton3.setBorderPainted(false);
        jPanel2.add(jButton3);
        jButton3.setBounds(160, 450, 130, 40);

        email1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        email1.setText("Email :");
        jPanel2.add(email1);
        email1.setBounds(40, 50, 70, 30);

        password1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        password1.setText("Password :");
        jPanel2.add(password1);
        password1.setBounds(40, 100, 100, 30);

        firstName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        firstName.setText("First Name :");
        jPanel2.add(firstName);
        firstName.setBounds(40, 150, 100, 30);

        lastName.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lastName.setText("Last Name :");
        jPanel2.add(lastName);
        lastName.setBounds(40, 200, 100, 30);

        adress.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        adress.setText("Adress :");
        jPanel2.add(adress);
        adress.setBounds(40, 250, 100, 30);

        birthDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        birthDate.setText("Birth date :");
        jPanel2.add(birthDate);
        birthDate.setBounds(40, 300, 100, 30);

        telephoneNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        telephoneNumber.setText("Telephone number :");
        jPanel2.add(telephoneNumber);
        telephoneNumber.setBounds(40, 350, 170, 30);

        emailField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));
        emailField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(emailField);
        emailField.setBounds(230, 50, 160, 30);

        passwordField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(51, 51, 51));
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(passwordField);
        passwordField.setBounds(230, 100, 160, 30);

        firstNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(51, 51, 51));
        firstNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(firstNameField);
        firstNameField.setBounds(230, 150, 160, 30);

        lastNameField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(51, 51, 51));
        lastNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(lastNameField);
        lastNameField.setBounds(230, 200, 160, 30);

        adressField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        adressField.setForeground(new java.awt.Color(51, 51, 51));
        adressField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        adressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(adressField);
        adressField.setBounds(230, 250, 160, 30);

        birthDateField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        birthDateField.setForeground(new java.awt.Color(51, 51, 51));
        birthDateField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        birthDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(birthDateField);
        birthDateField.setBounds(230, 300, 160, 30);

        telephoneNulberField.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        telephoneNulberField.setForeground(new java.awt.Color(51, 51, 51));
        telephoneNulberField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        telephoneNulberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(telephoneNulberField);
        telephoneNulberField.setBounds(230, 350, 160, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 0, 440, 530);

        setSize(new java.awt.Dimension(822, 526));
        setLocationRelativeTo(null);
    }

}
