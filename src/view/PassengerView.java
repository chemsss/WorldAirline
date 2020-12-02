package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassengerView extends javax.swing.JFrame {

    /**
     * Creates new form PassengerTest
     */
    public PassengerView() {
        initComponents();
        this.setVisible(true);
        this.setSize(643,815);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55,112,155));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel1.setText("Flight Infos");
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(260, 0, 160, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 630, 290);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);
        jPanel3.setPreferredSize(new Dimension(100, 5000));

        ArrayList<JLabel[]> labels = new ArrayList();
        ArrayList<JTextField[]> textFields = new ArrayList();
        ArrayList<JDateChooser> birthDates = new ArrayList();

        int y = 10;
        int y2 = 80;

        for (int i = 0; i < 4; i++) {

            JLabel[] label = new JLabel[9];
            JTextField[] text = new JTextField[7];

            for (int k = 0; k < 9; k++) {
                label[k] = new JLabel();
            }
            for (int k = 0; k < 7; k++) {
                text[k] = new JTextField();
            }

            label[0].setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
            label[0].setText("Passenger " + (i + 1));
            label[0].setBounds(270, y, 100, 30);

            y += 70;
            label[1].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[1].setText("Email :");
            label[1].setBounds(30, y, 70, 20);

            y += 40;
            label[2].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[2].setText("First Name :");
            label[2].setBounds(30, y, 110, 20);

            y += 40;
            label[3].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[3].setText("Last Name :");
            label[3].setBounds(30, y, 110, 20);

            y += 40;
            label[4].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[4].setText("Address :");
            label[4].setBounds(30, y, 110, 20);

            y += 40;
            label[5].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[5].setText("Birth Date :");
            label[5].setBounds(30, y, 110, 20);

            y += 40;
            label[6].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[6].setText("Tel No :");
            label[6].setBounds(30, y, 110, 20);

            y += 40;
            label[7].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[7].setText("Nationality :");
            label[7].setBounds(30, y, 110, 20);

            y += 40;
            label[8].setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
            label[8].setText("Passport No :");
            label[8].setBounds(30, y, 110, 20);
            
            y += 80;
            labels.add(label);
            JDateChooser birthDate = new JDateChooser();
            birthDate.setOpaque(false);
            birthDates.add(birthDate);

            
            text[0].setBounds(160, y2, 120, 20);

            y2 += 40;
            text[1].setBounds(160, y2, 120, 20);

            y2 += 40;
            text[2].setBounds(160, y2, 120, 20);

            y2 += 40;
            text[3].setBounds(160, y2, 120, 20);

            y2 += 40;
            birthDate.setBounds(160, y2, 120, 20);
            
            y2 += 40;
            text[4].setBounds(160, y2, 120, 20);

            y2 += 40;
            text[5].setBounds(160, y2, 120, 20);

            y2 += 40;
            text[6].setBounds(160, y2, 120, 20);

            y2 += 40;
            textFields.add(text);
            y2 += 110;

      
            
           

            if (i == 3) {

                JButton jButton1 = new JButton();

                jButton1.setBackground(new java.awt.Color(102, 102, 102));
                jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Next");
                jButton1.setBorderPainted(false);
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                jButton1.setFocusable(false);
                jButton1.setBounds(470, y, 110, 30);

                jPanel3.add(jButton1);
            }
        }

        for (int i = 0; i < labels.size(); i++) {
            for (int j = 0; j < 9; j++) {
                jPanel3.add(labels.get(i)[j]);
            }

        }

        for (int i = 0; i < textFields.size(); i++) {
            for (int j = 0; j < 7; j++) {
                jPanel3.add(textFields.get(i)[j]);
            }

        }

        for (int i = 0; i < birthDates.size(); i++) {
            jPanel3.add(birthDates.get(i));
        }

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 290, 630, 490);
        pack();

    }

    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration                   
}
