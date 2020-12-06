package view;

import controller.BookingController;
import controller.SearchBookingsTableModel;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Booking;
import model.CustomerAccount;

public class MyBookingsPanel extends javax.swing.JPanel {

    private javax.swing.JScrollPane bookingScrollPane;
    private javax.swing.JButton getBooking;
    private javax.swing.JLabel myBookings;
    private javax.swing.JTable myBookingsTable;
    private javax.swing.JButton previous2;

    private final MyAccountFrame frame;
    private final CustomerAccount loggedInCustomer;

    private Booking selectedBooking;
    private JPanel MyTickets;

    public MyBookingsPanel(MyAccountFrame frame, CustomerAccount loggedInCustomer) {
        super();
        this.loggedInCustomer = loggedInCustomer;
        this.frame = frame;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        myBookings = new javax.swing.JLabel();
        previous2 = new javax.swing.JButton();
        bookingScrollPane = new javax.swing.JScrollPane();
        myBookingsTable = new javax.swing.JTable();
        getBooking = new javax.swing.JButton();

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        myBookings.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myBookings.setForeground(new java.awt.Color(255, 255, 255));
        myBookings.setText("My Bookings");

        this.add(myBookings);
        myBookings.setBounds(200, 10, 140, 40);

        previous2.setBackground(new java.awt.Color(255, 255, 255));
        previous2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous2.setText("Previous");
        previous2.setBorder(null);
        previous2.setBorderPainted(false);
        previous2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                frame.getMyAccountPanel().setVisible(true);
                setVisible(false);
                frame.setSize(530, 615);

            }
        });
        this.add(previous2);
        previous2.setBounds(3, 555, 40, 20);

        ArrayList<Booking> bookings = BookingController.getBookings(loggedInCustomer.getIdAccount());
        System.out.println((loggedInCustomer.getIdAccount()));

        SearchBookingsTableModel model = new SearchBookingsTableModel(bookings);

        myBookingsTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        myBookingsTable.setModel(model);
        myBookingsTable.setRowHeight(20);
        myBookingsTable.setToolTipText("");
        myBookingsTable.setSelectionBackground(new java.awt.Color(0, 204, 0));
        myBookingsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myBookingsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myBookingsTable.setShowGrid(true);
        bookingScrollPane.setViewportView(myBookingsTable);

        this.add(bookingScrollPane);
        bookingScrollPane.setBounds(20, 90, 480, 390);

        getBooking.setBackground(new java.awt.Color(255, 255, 255));
        getBooking.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        getBooking.setText("Get Booking tickets");
        getBooking.setBorder(null);
        getBooking.setBorderPainted(false);
        getBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JPanel myPanel = this;
        getBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //If a booking is selected
                if (!myBookingsTable.getSelectionModel().isSelectionEmpty()) {
                    String stringBookingNo = myBookingsTable.getValueAt(myBookingsTable.getSelectedRow(), 0).toString();
                    int bookingNo = Integer.parseInt(stringBookingNo);

                    selectedBooking = BookingController.getBooking(bookingNo);

                    setVisible(false);
                    MyTickets = new MyTicketsPanel((MyBookingsPanel) myPanel, selectedBooking, frame);
                    MyTickets.setVisible(true);
                    frame.getContentPane().add(MyTickets);
                }

            }
        });
        this.add(getBooking);
        getBooking.setBounds(170, 520, 190, 30);

        this.setBounds(0, 0, 530, 580);
    }

}
