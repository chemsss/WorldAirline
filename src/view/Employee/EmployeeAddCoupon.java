package view.Employee;

import controller.CouponController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class EmployeeAddCoupon extends javax.swing.JPanel {

    private javax.swing.JButton add;
    private javax.swing.JLabel addCoupon;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField CouponCode;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel Code;

    private javax.swing.JPanel center;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeAddCoupon() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));
    }

    private void initComponents() {

        add = new javax.swing.JButton();
        amount = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        Code = new javax.swing.JLabel();
        CouponCode = new javax.swing.JTextField();
        addCoupon = new javax.swing.JLabel();
        center = new javax.swing.JPanel();

        setLayout(null);
        center.setLayout(null);
        center.setBackground(new java.awt.Color(55, 112, 155));

        addCoupon.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        addCoupon.setForeground(new java.awt.Color(255, 255, 255));
        addCoupon.setText("Add a Coupon:");
        add(addCoupon);
        addCoupon.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        add.setBorderPainted(false);
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!((amount.getText().isEmpty()) && (CouponCode.getText().isEmpty()) || (amount.getText().isEmpty()) || (CouponCode.getText().isEmpty()))) {

                    if (CouponController.checkCouponAmount(amount.getText())) {

                        CouponController.addCoupon(CouponCode.getText(), Float.parseFloat(amount.getText()));

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valide Coupon code and Amount");
                }
            }
        });
        add(add);
        add.setBounds((screenWidth / 2) - 70, 280, 90, 30);

        amount.setText("");
        center.add(amount);
        amount.setBounds(560, 180, 150, 30);

        amountLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(255, 255, 255));
        amountLabel.setText("Coupon's amount:");
        center.add(amountLabel);
        amountLabel.setBounds(360, 180, 170, 30);

        Code.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        Code.setForeground(new java.awt.Color(255, 255, 255));
        Code.setText("Enter the code: ");
        center.add(Code);
        Code.setBounds(360, 120, 170, 30);

        CouponCode.setText("");
        center.add(CouponCode);
        CouponCode.setBounds(560, 120, 150, 30);

        add(center);
        center.setBounds(200, 10, 1000, 1000);

    }

}
