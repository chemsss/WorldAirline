package view;

import controller.BookingController;
import controller.SearchBookingsTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Booking;

public class EmployeeBookingSearch extends JPanel {

    private javax.swing.JLabel title;
    private javax.swing.JLabel bookingNo;
    private javax.swing.JTextField bookingNoField;

    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;

    private javax.swing.JButton search;

    private ArrayList<Booking> bookings;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeBookingSearch() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));
    }

    private void initComponents() {

        bookings = new ArrayList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        bookingNo = new javax.swing.JLabel();
        bookingNoField = new javax.swing.JTextField();

        search = new javax.swing.JButton();

        setLayout(null);

        title.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Search Booking");
        add(title);
        title.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        jTable1.setModel(new SearchBookingsTableModel(bookings));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        search.setText("Next");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        search.setBorderPainted(false);

        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!bookingNoField.getText().isEmpty()) {

                    if (BookingController.checkBooking(Integer.parseInt(bookingNoField.getText()))) {
                        bookings.add(BookingController.getBooking(Integer.parseInt(bookingNoField.getText())));

                        jTable1.setModel(new SearchBookingsTableModel(bookings));
                        bookings = new ArrayList<Booking>();
                    }
                }

            }
        });
        add(search);
        search.setBounds(570, 122, 90, 30);

        bookingNoField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        bookingNoField.setBounds(400, 120, 150, 32);
        add(bookingNoField);

        bookingNo.setFont(new java.awt.Font("Yu Gothic UI light", 0, 20)); // NOI18N
        bookingNo.setForeground(new java.awt.Color(255, 255, 255));
        bookingNo.setText("Enter the Booking No: ");
        add(bookingNo);
        bookingNo.setBounds(200, 120, 300, 30);

        jTable1.setRowHeight(20);
        jTable1.setToolTipText("");
        jTable1.setSelectionBackground(new java.awt.Color(0, 204, 0));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));

        jScrollPane3.setViewportView(jTable1);
        add(jScrollPane3);
        jScrollPane3.setBounds(200, 200, 1000, 500);

    }

}
