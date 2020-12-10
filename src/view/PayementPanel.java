package view;

import java.awt.Dimension;

public class PayementPanel extends javax.swing.JPanel {

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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton next;
    private javax.swing.JButton next1;
    private javax.swing.JLabel payUsing1;
    private javax.swing.JLabel payment;
    private javax.swing.JButton previous;
   
    private EmployeeAddTicket frame;

    
    public PayementPanel(EmployeeAddTicket frame) {
        super();
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
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

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        payment.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        this.add(payment);
        payment.setBounds(260, 20, 160, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1000$");
        this.add(jLabel2);
        jLabel2.setBounds(490, 520, 130, 30);

        creditCards.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        creditCards.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\25654-2-major-credit-card-logo-transparent_400x400.png")); // NOI18N
        this.add(creditCards);
        creditCards.setBounds(170, 150, 420, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\lock_30px.png")); // NOI18N
        this.add(jLabel4);
        jLabel4.setBounds(50, 410, 60, 30);

        couponCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        couponCode.setForeground(new java.awt.Color(255, 255, 255));
        couponCode.setText("Coupon code :");
        this.add(couponCode);
        couponCode.setBounds(370, 600, 100, 40);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Price :");
        this.add(jLabel6);
        jLabel6.setBounds(340, 520, 130, 30);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\credit_card_30px.png")); // NOI18N
        this.add(jLabel7);
        jLabel7.setBounds(50, 310, 40, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\GITHUB\\worldAirline\\img\\calendar_30px.png")); // NOI18N
        this.add(jLabel8);
        jLabel8.setBounds(50, 350, 30, 50);

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jTextField3.setText("Security Code");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(jTextField3);
        jTextField3.setBounds(120, 412, 210, 32);

        dateExp.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        dateExp.setText("MM / YY");
        dateExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(dateExp);
        dateExp.setBounds(120, 362, 210, 32);

        couponCodeField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        couponCodeField.setText("Code");
        couponCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(couponCodeField);
        couponCodeField.setBounds(480, 610, 80, 25);

        previous.setBackground(new java.awt.Color(255, 255, 255));
        previous.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        previous.setText("Previous");
        previous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        previous.setBorderPainted(false);
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                          
                           /* frame.getjScrollPane1().setVisible(true);
                            frame.getFlightDetailsPanel().setVisible(true);
                            frame.getjPanel3().setVisible(true);
                            frame.setSize(643, 815);

                            setVisible(false);*/
                            
                            

            }
        });
        this.add(previous);
        previous.setBounds(30, 670, 90, 30);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        next.setText("OK");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next.setBorderPainted(false);
        this.add(next);
        next.setBounds(575, 610, 35, 25);

        payUsing1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        payUsing1.setForeground(new java.awt.Color(255, 255, 255));
        payUsing1.setText("Pay using :");
        this.add(payUsing1);
        payUsing1.setBounds(50, 150, 130, 30);

        cardNumber1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cardNumber1.setText("Card number");
        cardNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(cardNumber1);
        cardNumber1.setBounds(120, 312, 210, 32);

        next1.setBackground(new java.awt.Color(255, 255, 255));
        next1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        next1.setText("Next");
        next1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next1.setBorderPainted(false);
        this.add(next1);
        next1.setBounds(510, 670, 90, 30);
        // getContentPane().add(this);
        this.setBounds(0, 0, 630, 720);

    }

}
