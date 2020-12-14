package view;

public class Contact extends javax.swing.JFrame {

    public Contact() {
        initComponents();
        this.setSize(530, 430);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

   
    private void initComponents() {

        panel = new javax.swing.JPanel();
        worldAirline = new javax.swing.JLabel();
        chemseddine = new javax.swing.JLabel();
        abbas = new javax.swing.JLabel();
        td3Ing3 = new javax.swing.JLabel();
        dan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panel.setBackground(new java.awt.Color(55, 112, 155));
        panel.setLayout(null);

        worldAirline.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 36)); // NOI18N
        worldAirline.setForeground(new java.awt.Color(255, 255, 255));
        worldAirline.setText("WorldAirline");
        panel.add(worldAirline);
        worldAirline.setBounds(160, 20, 230, 40);

        chemseddine.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        chemseddine.setForeground(new java.awt.Color(255, 255, 255));
        chemseddine.setText("BRAHIM KHLIL Chemseddine   :  chemseddine.brahimkhlil@edu.ece.fr ");
        panel.add(chemseddine);
        chemseddine.setBounds(30, 230, 510, 40);

        abbas.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        abbas.setForeground(new java.awt.Color(255, 255, 255));
        abbas.setText("JIAR Abbas  :  abbas.jiar@edu.ece.fr ");
        panel.add(abbas);
        abbas.setBounds(30, 170, 390, 40);

        td3Ing3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        td3Ing3.setForeground(new java.awt.Color(255, 255, 255));
        td3Ing3.setText("TD3 ING3");
        panel.add(td3Ing3);
        td3Ing3.setBounds(200, 310, 100, 40);

        dan.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        dan.setForeground(new java.awt.Color(255, 255, 255));
        dan.setText("BELISSA Dan :  dan.belissa@edu.ece.fr");
        panel.add(dan);
        dan.setBounds(30, 110, 390, 40);

        getContentPane().add(panel);
        panel.setBounds(0, 0, 530, 430);

        pack();
    }                        

 
    private javax.swing.JLabel abbas;
    private javax.swing.JLabel chemseddine;
    private javax.swing.JLabel dan;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel td3Ing3;
    private javax.swing.JLabel worldAirline;
}
