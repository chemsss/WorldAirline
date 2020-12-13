package view.Customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class EmployeeLogin extends JFrame {

    private final JButton  jButton2;
    private final JLabel jLabel1, jLabel2, jLabel3;
    private final JPanel jPanel1, jPanel2;
    private final JTextField jTextField2;
    private final JPasswordField password;


    public EmployeeLogin() {
        super("Employee login");

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jPanel2 = new JPanel();
        //jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        password = new JPasswordField("Password");

        //controller = new EmployeeLoginChoice(this); // création du controller
        initEmployeeLogin();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public void initEmployeeLogin() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(255, 0, 0));
        jPanel1.setLayout(null);

       jLabel1.setIcon(new javax.swing.ImageIcon("img\\employee_127px.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 100, 280, 260);

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

        jLabel2.setBackground(new Color(255, 0, 0));
        jLabel2.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        jLabel2.setForeground(new Color(255, 0, 0));
        jLabel2.setText("X");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(410, 0, 30, 40);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
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

        //jTextField1.setBounds(70, 200, 270, 50);

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

        jButton2.setBackground(new Color(255, 0, 0));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(0, 181, 204)));
        jButton2.setBorderPainted(false);
        //jButton2.addActionListener(controller);
        
        
        
        jButton2.setActionCommand("Login");
        jButton2.setFocusPainted(false);

        jPanel2.add(jButton2);
        jButton2.setBounds(150, 410, 130, 40);

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
