package view.Employee;

import controller.BookingController;
import controller.FlightController;
import controller.SearchTicketsTableModel;
import controller.TicketController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Booking;

public class EmployeeManageBooking extends javax.swing.JPanel {

    private com.toedter.calendar.JDateChooser choiceDepartureDate;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteTickets;
    private javax.swing.JButton addTicket;
    private javax.swing.JLabel bookingDateLabel;
    private javax.swing.JLabel bookingNoLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField priceofaseat2;
    private javax.swing.JLabel customerAccount;
    private javax.swing.JTextField customerAccountField;
    private javax.swing.JButton search;
    private javax.swing.JTable tableSeat;
    private javax.swing.JTextField bookingNoField;
    private javax.swing.JLabel title;
    private javax.swing.JButton update;
    private Booking selectedBooking;
    private javax.swing.JPanel center;

    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeManageBooking() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));
    }

    private void initComponents() {

        title = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        bookingNoField = new javax.swing.JTextField();
        bookingNoLabel = new javax.swing.JLabel();
        bookingDateLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSeat = new javax.swing.JTable();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        deleteTickets = new javax.swing.JButton();
        choiceDepartureDate = new com.toedter.calendar.JDateChooser();
        priceofaseat2 = new javax.swing.JTextField();
        customerAccount = new javax.swing.JLabel();
        customerAccountField = new javax.swing.JTextField();
        addTicket = new javax.swing.JButton();

        center = new javax.swing.JPanel();
        center.setBackground(new java.awt.Color(55, 112, 155));
        center.setLayout(null);

        setLayout(null);

        title.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));

        title.setText("Manage Booking");
        add(title);
        title.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        search.setBorderPainted(false);
        search.setBounds(590, 122, 90, 30);

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!bookingNoField.getText().isEmpty()) {
                    if (BookingController.getBooking(Integer.parseInt(bookingNoField.getText())) == null) {
                        JOptionPane.showMessageDialog(null, "The booking has not been founded");
                  
                    } else {
                        selectedBooking = BookingController.getBooking(Integer.parseInt(bookingNoField.getText()));
                        choiceDepartureDate.setDate(selectedBooking.getBookingDate());
                        tableSeat.setModel(new SearchTicketsTableModel(Integer.parseInt(bookingNoField.getText())));
                    }

                }

            }
        });
        add(search);

        bookingNoField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        bookingNoField.setBounds(420, 120, 150, 32);
        add(bookingNoField);

        bookingNoLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        bookingNoLabel.setText("Enter the Booking No: ");
        bookingNoLabel.setForeground(new java.awt.Color(255, 255, 255));

        add(bookingNoLabel);
        bookingNoLabel.setBounds(200, 120, 300, 30);

        bookingDateLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        bookingDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        bookingDateLabel.setText("Booking Date:");

        center.add(bookingDateLabel);
        bookingDateLabel.setBounds(40, 40, 160, 30);

        tableSeat.setModel(new SearchTicketsTableModel());
        jScrollPane2.setViewportView(tableSeat);

        center.add(jScrollPane2);
        jScrollPane2.setBounds(500, 30, 590, 360);

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        update.setText("Update");
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        update.setBorderPainted(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!bookingNoField.getText().isEmpty()) {
                   
                    try {
                        BookingController.updateBooking(Integer.parseInt(bookingNoField.getText()), (Date) choiceDepartureDate.getDate(), Integer.parseInt(customerAccountField.getText()), Integer.parseInt(priceofaseat2.getText()), Integer.parseInt(bookingNoField.getText()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the Booking No");
                }

            }
        });
        center.add(update);
        update.setBounds(40, 200, 90, 30);

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        delete.setBorderPainted(false);

        center.add(delete);
        delete.setBounds(325, 200, 90, 30);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!bookingNoField.getText().isEmpty()) {
                   
                    try {
                        if((BookingController.checkBooking(Integer.parseInt(bookingNoField.getText()))))
                        {
                            BookingController.deleteBooking(Integer.parseInt(bookingNoField.getText()));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    
                }
                  else {
                    JOptionPane.showMessageDialog(null, "Please enter the Booking No");
                }

            }
        });

        deleteTickets.setBackground(new java.awt.Color(255, 255, 255));
        deleteTickets.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        deleteTickets.setText("Delete ticket");
        deleteTickets.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        deleteTickets.setBorderPainted(false);

        deleteTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!tableSeat.getSelectionModel().isSelectionEmpty()) //If we select a flight
                {
                    String stringTicketNumber = tableSeat.getValueAt(tableSeat.getSelectedRow(), 0).toString();
                    int TicketNumber = Integer.parseInt(stringTicketNumber);

                    TicketController.deleteFlight(TicketNumber);

                }
                else{
                            JOptionPane.showMessageDialog(null, "Please, select a booking");

            }
            }
        });
        center.add(deleteTickets);
        deleteTickets.setBounds(1140, 260, 90, 30);

        center.add(choiceDepartureDate);
        choiceDepartureDate.setBounds(255, 40, 160, 30);

        customerAccount.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        customerAccount.setForeground(new java.awt.Color(255, 255, 255));
        customerAccount.setText("Customer Account:");
        center.add(customerAccount);
        customerAccount.setBounds(40, 110, 200, 30);

        customerAccountField.setText("");
        center.add(customerAccountField);
        customerAccountField.setBounds(255, 110, 160, 32);

        addTicket.setBackground(new java.awt.Color(255, 255, 255));
        addTicket.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        addTicket.setText("Add ticket");
        addTicket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        addTicket.setBorderPainted(false);

        addTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {

                    if (selectedBooking != null) {

                        String strIdFlight;
                        int idFlight;
                        strIdFlight = JOptionPane.showInputDialog("Enter the id of the flight ");
                        idFlight = Integer.parseInt(strIdFlight);

                        if (FlightController.checkFlight(idFlight)) {
                            new EmployeeAddTicket(selectedBooking, idFlight);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Select a Booking");

                    }

                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

            }
        });
        addTicket.setBounds(1140, 80, 90, 30);
        center.add(addTicket);

        add(center);
        center.setBounds(165, 200, screenWidth, screenHeight);

    }

}
