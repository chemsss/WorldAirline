package view.Employee;

import controller.CouponController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Coupon;
import model.TableModel.SearchCouponsTableModel;

public class EmployeeManageCoupon extends javax.swing.JPanel {
    
    private javax.swing.JButton delete;
    private javax.swing.JLabel couponField;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JTextField couponIdField;
    private javax.swing.JButton search;
    private ArrayList<Coupon> coupons;

    
    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    public EmployeeManageCoupon() {
      super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));
    }

    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        couponIdField = new javax.swing.JTextField();
        couponField= new javax.swing.JLabel();
        search = new javax.swing.JButton();
        coupons = new ArrayList<Coupon>();
        
        setLayout(null);
        setBackground(new java.awt.Color(55, 112, 155));

        title.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Search Coupon");
        add(title);
        title.setBounds((screenWidth / 2) - 100, 20, 300, 40);
        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        search.setBorderPainted(false);
        search.setBounds(560, 122, 90, 30);

       search.addActionListener(new java.awt.event.ActionListener() {
            @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) {
  
               if (!couponIdField.getText().isEmpty()) {
                   
                    if (CouponController.checkCoupon(couponIdField.getText())) {
                        coupons = new ArrayList<Coupon>();
                        coupons.add(CouponController.getCoupon(Integer.parseInt(couponIdField.getText())));

                        table.setModel(new SearchCouponsTableModel(coupons));
                        coupons = new ArrayList<Coupon>();

                    }

                }

            }
        });
        add(search);
        
        coupons=CouponController.findAllCoupons();
        table.setModel(new SearchCouponsTableModel(coupons));
        jScrollPane4.setViewportView(table);

        add(jScrollPane4);
        jScrollPane4.setBounds(130, 90, 630, 330);

        delete.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14));
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setBorderPainted(false);
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!table.getSelectionModel().isSelectionEmpty())  //If we select a coupon
                {
                    String stringTicketNumber = table.getValueAt(table.getSelectedRow(), 1).toString();
                    CouponController.deleteCoupon(stringTicketNumber);
                    JOptionPane.showMessageDialog(null, "The Coupon has been deleted");
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a Coupon");
                }
               
                
            }
        });
        add(delete);
        delete.setBounds(1230, 360,  90, 30);
        
        couponIdField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        couponIdField.setBounds(390, 120, 150, 32);
        add(couponIdField);
        
        couponField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        couponField.setBounds(380, 120, 150, 32);

        couponField.setFont(new java.awt.Font("Yu Gothic UI light", 0, 20)); // NOI18N
        couponField.setForeground(new java.awt.Color(255, 255, 255));
        couponField.setText("Enter the Coupon Id: ");
        add(couponField);
        couponField.setBounds(200, 120, 300, 30);   
        
        table.setRowHeight(20);
        table.setToolTipText("");
        table.setSelectionBackground(new java.awt.Color(0, 204, 0));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(true);
        table.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));

        jScrollPane4.setViewportView(table);

        add(jScrollPane4);
        jScrollPane4.setBounds(200, 200, 1000, 500);
        
        
        
        
    }                       

}
