/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Chems
 */
public class EmployeeBookingSearch extends JPanel {
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel idflight2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton search2;
    private javax.swing.JTextField textidflight2;
    private javax.swing.JLabel title2;
    // End of variables declaration     
    
    public EmployeeBookingSearch() {
        super();
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int)screenSize.getWidth(),(int)screenSize.getHeight()));
        setBounds(0, 0, 1100, 570);
    }
    
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idflight2 = new javax.swing.JLabel();
        textidflight2 = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        title2 = new javax.swing.JLabel();

        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        add(jScrollPane3);
        jScrollPane3.setBounds(140, 140, 630, 330);

        idflight2.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        idflight2.setText("Enter the id of the booking: ");
        add(idflight2);
        idflight2.setBounds(30, 60, 200, 22);

        textidflight2.setText("jTextField1");
        textidflight2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        add(textidflight2);
        textidflight2.setBounds(230, 63, 150, 20);

        search2.setText("research");
        search2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        add(search2);
        search2.setBounds(400, 60, 90, 23);

        title2.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        title2.setText("Search booking:");
        add(title2);
        title2.setBounds(370, 10, 150, 30);
    }
    
    
}
