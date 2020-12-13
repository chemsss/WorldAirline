package view;

import test.EmployeeAddTicket;
import java.awt.Dimension;

public class PaymentPanel extends javax.swing.JPanel {

    private javax.swing.JTextField cardNumber;
    private javax.swing.JLabel couponCode;
    private javax.swing.JTextField couponCodeField;
    private javax.swing.JLabel creditCards;
    private javax.swing.JTextField dateExp;
    private javax.swing.JLabel amountWithoutDiscount;
    private javax.swing.JLabel lock;
    private javax.swing.JLabel amountAfterDiscount;
    private javax.swing.JLabel creditCardsPng;
    private javax.swing.JLabel calendarPng;
    private javax.swing.JTextField securityCode;
    private javax.swing.JButton applicatePromoCode;
    private javax.swing.JButton next;
    private javax.swing.JLabel payUsing1;
    private javax.swing.JLabel payment;
    private javax.swing.JButton previous;
   
    private PassengersInfosFrame frame;

    
    public PaymentPanel(PassengersInfosFrame frame) {
        super();
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        payment = new javax.swing.JLabel();
        amountWithoutDiscount = new javax.swing.JLabel();
        creditCards = new javax.swing.JLabel();
        lock = new javax.swing.JLabel();
        couponCode = new javax.swing.JLabel();
        amountAfterDiscount = new javax.swing.JLabel();
        creditCardsPng = new javax.swing.JLabel();
        calendarPng = new javax.swing.JLabel();
        securityCode = new javax.swing.JTextField();
        dateExp = new javax.swing.JTextField();
        couponCodeField = new javax.swing.JTextField();
        previous = new javax.swing.JButton();
        applicatePromoCode = new javax.swing.JButton();
        payUsing1 = new javax.swing.JLabel();
        cardNumber = new javax.swing.JTextField();
        next = new javax.swing.JButton();

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        payment.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        this.add(payment);
        payment.setBounds(260, 20, 160, 40);

        amountWithoutDiscount.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        amountWithoutDiscount.setForeground(new java.awt.Color(255, 255, 255));
        amountWithoutDiscount.setText("1000$");
        this.add(amountWithoutDiscount);
        amountWithoutDiscount.setBounds(490, 520, 130, 30);

        creditCards.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        creditCards.setIcon(new javax.swing.ImageIcon("img\\paymentMethods.png")); // NOI18N
        this.add(creditCards);
        creditCards.setBounds(170, 150, 420, 40);

        lock.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        lock.setIcon(new javax.swing.ImageIcon("img\\lock_30px.png")); // NOI18N
        this.add(lock);
        lock.setBounds(50, 410, 60, 30);

        couponCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        couponCode.setForeground(new java.awt.Color(255, 255, 255));
        couponCode.setText("Coupon code :");
        this.add(couponCode);
        couponCode.setBounds(370, 600, 100, 40);

<<<<<<< Updated upstream:src/view/PaymentPanel.java
        amountAfterDiscount.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        amountAfterDiscount.setForeground(new java.awt.Color(255, 255, 255));
        amountAfterDiscount.setText("Total Price :");
        this.add(amountAfterDiscount);
        amountAfterDiscount.setBounds(340, 520, 130, 30);

        creditCardsPng.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        creditCardsPng.setIcon(new javax.swing.ImageIcon("img\\credit_card_30px.png")); // NOI18N
        this.add(creditCardsPng);
        creditCardsPng.setBounds(50, 310, 40, 30);

        calendarPng.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        calendarPng.setIcon(new javax.swing.ImageIcon("img\\calendar_30px.png")); // NOI18N
        this.add(calendarPng);
        calendarPng.setBounds(50, 350, 30, 50);

        securityCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        securityCode.setText("Security Code");
        securityCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(securityCode);
        securityCode.setBounds(120, 412, 210, 32);
=======
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
                jTextField3.setBounds(120, 412, 210, 32);

        jTextField3.setText("Security Code");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(jTextField3);
>>>>>>> Stashed changes:src/view/PayementPanel.java

        
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
                          
                            frame.getPassengersScrollPane().setVisible(true);
                            frame.getFlightDetailsPanel().setVisible(true);
                            frame.getPassengersPanel().setVisible(true);
                            frame.setSize(643, 815);

                            setVisible(false);
                            
                            

            }
        });
        this.add(previous);
        previous.setBounds(30, 670, 90, 30);

        applicatePromoCode.setBackground(new java.awt.Color(255, 255, 255));
        applicatePromoCode.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        applicatePromoCode.setText("OK");
        applicatePromoCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        applicatePromoCode.setBorderPainted(false);
        this.add(applicatePromoCode);
        applicatePromoCode.setBounds(575, 610, 35, 25);

        payUsing1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        payUsing1.setForeground(new java.awt.Color(255, 255, 255));
        payUsing1.setText("Pay using :");
        this.add(payUsing1);
        payUsing1.setBounds(50, 150, 130, 30);

        cardNumber.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        cardNumber.setText("Card number");
        cardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.add(cardNumber);
        cardNumber.setBounds(120, 312, 210, 32);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        next.setText("Next");
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        next.setBorderPainted(false);
        this.add(next);
        next.setBounds(510, 670, 90, 30);
        this.setBounds(0, 0, 630, 720);

    }

}
