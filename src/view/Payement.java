package view;

/**
 *
 * @author Unknow
 */
public class Payement extends javax.swing.JFrame {

    private javax.swing.JTextField cardNumber1;
    private javax.swing.JLabel couponCode;
    private javax.swing.JTextField couponCodeField;
    private javax.swing.JLabel creditCards;
    private javax.swing.JTextField dateExp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton next;
    private javax.swing.JButton next1;
    private javax.swing.JLabel payUsing1;
    private javax.swing.JLabel payment;
    private javax.swing.JButton previous;

    public Payement() {
        initComponents();
        this.setSize(630, 720);
        this.setVisible(true);
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        creditCards = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        couponCode = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        dateExp = new javax.swing.JTextField();
        couponCodeField = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        payUsing1 = new javax.swing.JLabel();
        cardNumber1 = new javax.swing.JTextField();
        next1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 112, 155));
        jPanel2.setLayout(null);

        payment.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        jPanel2.add(payment);
        payment.setBounds(260, 20, 160, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1000$");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(490, 520, 130, 30);

        creditCards.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        creditCards.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\25654-2-major-credit-card-logo-transparent_400x400.png")); // NOI18N
        jPanel2.add(creditCards);
        creditCards.setBounds(170, 150, 420, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\lock_30px.png")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(50, 410, 60, 30);

        couponCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        couponCode.setForeground(new java.awt.Color(255, 255, 255));
        couponCode.setText("Coupon code :");
        jPanel2.add(couponCode);
        couponCode.setBounds(370, 600, 100, 40);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Price :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(340, 520, 130, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\credit_card_30px.png")); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 310, 40, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\calendar_30px.png")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 350, 30, 50);

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jTextField3.setText("Security Code");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(120, 410, 210, 30);

        dateExp.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        dateExp.setText("MM / YY");
        dateExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(dateExp);
        dateExp.setBounds(120, 360, 210, 30);

        couponCodeField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        couponCodeField.setText("Code");
        couponCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(couponCodeField);
        couponCodeField.setBounds(480, 610, 80, 25);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        previous.setBorderPainted(false);
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(previous);
        previous.setBounds(30, 670, 90, 30);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        next.setText("OK");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next.setBorderPainted(false);
        jPanel2.add(next);
        next.setBounds(575, 610, 35, 25);

        payUsing1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        payUsing1.setForeground(new java.awt.Color(255, 255, 255));
        payUsing1.setText("Pay using :");
        jPanel2.add(payUsing1);
        payUsing1.setBounds(50, 150, 130, 30);

        cardNumber1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cardNumber1.setText("Card number");
        cardNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jPanel2.add(cardNumber1);
        cardNumber1.setBounds(120, 310, 210, 30);

        next1.setBackground(new java.awt.Color(255, 255, 255));
        next1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        next1.setText("Next");
        next1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next1.setBorderPainted(false);
        jPanel2.add(next1);
        next1.setBounds(510, 670, 90, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 630, 720);

        pack();
    }// </editor-fold>                        

    // End of variables declaration                   
}
