package view.Employee;

import Exceptions.EmptyFields;
import controller.FlightSeatsController;
import java.math.BigDecimal;
import model.FlightSeat;

public class EmployeeAddSeat extends javax.swing.JFrame {

    private javax.swing.JComboBox availabilty;
    private javax.swing.JComboBox className;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField seatNumber;

    public EmployeeAddSeat(int idFlight) {
        initComponents(idFlight);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void initComponents(final int idFlight) {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        availabilty = new javax.swing.JComboBox();
        seatNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        className = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(55, 112, 155));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Availability:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 210, 150, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add a Seat");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 10, 150, 40);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seat Number:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 90, 150, 40);

        availabilty.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Yes", "No"}));
        jPanel1.add(availabilty);
        availabilty.setBounds(160, 220, 160, 32);
        jPanel1.add(seatNumber);
        seatNumber.setBounds(160, 100, 160, 32);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Class Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 130, 150, 40);

        className.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Economy Class", "Buisness Class", "First Class"}));
        jPanel1.add(className);
        className.setBounds(160, 140, 160, 32);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seat Price:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 170, 150, 40);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(160, 180, 160, 32);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {

                    if (!((seatNumber.getText().isEmpty()) && (jTextField4.getText().isEmpty()))) {
                        if (FlightSeatsController.CheckFlightSeatInfo(seatNumber.getText(), jTextField4.getText())) {
                            boolean isAvailable;
                            if (availabilty.getSelectedItem().toString().equals("Yes")) {
                                isAvailable = true;
                            } else {
                                isAvailable = false;
                            }

                            FlightSeat seat = new FlightSeat(Integer.parseInt(seatNumber.getText()), className.getSelectedItem().toString(), new BigDecimal(jTextField4.getText()), isAvailable);
                            FlightSeatsController.addFlightSeat(seat, idFlight);


                        }
                    } else {
                        throw new EmptyFields();
                    }
                } catch (EmptyFields exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 280, 83, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        pack();
    }

}
