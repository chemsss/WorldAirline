package view.Customer;

import controller.PassengerController;
import controller.SearchTicketsTableModel;
import controller.TicketController;
import javax.swing.JPanel;
import model.Booking;
import model.CustomerAccount;
import model.Ticket;

public class MyTicketDetailPanel extends javax.swing.JPanel {

    // My Ticket Detail          
    private javax.swing.JLabel barcode;
    private javax.swing.JLabel arrivalDateTime2;
    private javax.swing.JLabel arrivalTimeDate;
    private javax.swing.JLabel departureTimeDate;
    private javax.swing.JLabel departureTimeDate2;
    private javax.swing.JLabel flight;
    private javax.swing.JLabel flight2;
    private javax.swing.JLabel from;
    private javax.swing.JLabel from2;
    private javax.swing.JLabel myTicketDetails;
    private javax.swing.JLabel nameOfPasenger2;
    private javax.swing.JLabel nameOfPassenger;
    private javax.swing.JButton previous4;
    private javax.swing.JLabel to;
    private javax.swing.JLabel to2;
    private javax.swing.JLabel airline;
    private javax.swing.JLabel airline2;
    private javax.swing.JLabel seatNo;
    private javax.swing.JLabel seatNo2;
    private javax.swing.JLabel className;

    //Selected ticket
    private Ticket selectedTicket;

    //My Tickets Panel
    private JPanel myTicketsPanel;

    //MyAccountFrame
    private MyAccountFrame frame;

    public MyTicketDetailPanel(MyTicketsPanel myTicketsPanel, Ticket selectedTicket, MyAccountFrame frame) {
        super();

        this.frame = frame;
        this.myTicketsPanel = myTicketsPanel;
        this.selectedTicket = selectedTicket;

        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        myTicketDetails = new javax.swing.JLabel();
        previous4 = new javax.swing.JButton();
        to = new javax.swing.JLabel();
        arrivalTimeDate = new javax.swing.JLabel();
        flight = new javax.swing.JLabel();
        to2 = new javax.swing.JLabel();
        arrivalDateTime2 = new javax.swing.JLabel();
        flight2 = new javax.swing.JLabel();
        nameOfPassenger = new javax.swing.JLabel();
        nameOfPasenger2 = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        from2 = new javax.swing.JLabel();
        departureTimeDate = new javax.swing.JLabel();
        departureTimeDate2 = new javax.swing.JLabel();

        barcode = new javax.swing.JLabel();
        airline = new javax.swing.JLabel();
        airline2 = new javax.swing.JLabel();
        seatNo = new javax.swing.JLabel();
        seatNo2 = new javax.swing.JLabel();
        airline = new javax.swing.JLabel();
        className = new javax.swing.JLabel();

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        myTicketDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myTicketDetails.setForeground(new java.awt.Color(255, 255, 255));
        myTicketDetails.setText("My Ticket Details");
        this.add(myTicketDetails);

        myTicketDetails.setBounds(170, 10, 200, 40);

        previous4.setBackground(new java.awt.Color(255, 255, 255));
        previous4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous4.setText("Previous");
        previous4.setBorder(null);
        previous4.setBorderPainted(false);
        previous4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                myTicketsPanel.setVisible(true);

                setVisible(false);
                frame.setSize(530, 615);

            }
        }
        );

        departureTimeDate2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        departureTimeDate2.setForeground(new java.awt.Color(255, 255, 255));
        departureTimeDate2.setText(selectedTicket.getFlight().getDepartureDateTimeToString());
        this.add(departureTimeDate2);
        departureTimeDate2.setBounds(310, 204, 150, 20);

        to2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        to2.setForeground(new java.awt.Color(255, 255, 255));
        to2.setText((selectedTicket).getFlight().getArrivalAirport().getIdAirport());

        this.add(to2);
        to2.setBounds(60, 268, 70, 20);

        arrivalDateTime2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        arrivalDateTime2.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDateTime2.setText((selectedTicket).getFlight().getArrivalDateTimeToString());

        this.add(arrivalDateTime2);
        arrivalDateTime2.setBounds(310, 264, 150, 20);

        flight2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        flight2.setForeground(new java.awt.Color(255, 255, 255));
        flight2.setText(Integer.toString((selectedTicket).getFlight().getIdFlight()));

        this.add(flight2);
        flight2.setBounds(310, 134, 70, 20);

        this.add(previous4);
        previous4.setBounds(3, 555, 60, 20);

        to.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("To");
        this.add(to);
        to.setBounds(60, 244, 160, 30);

        arrivalTimeDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        arrivalTimeDate.setForeground(new java.awt.Color(255, 255, 255));
        arrivalTimeDate.setText("Arrival Date Time");
        this.add(arrivalTimeDate);
        arrivalTimeDate.setBounds(310, 240, 170, 30);

        flight.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        flight.setForeground(new java.awt.Color(255, 255, 255));
        flight.setText("Flight No");
        this.add(flight);
        flight.setBounds(310, 110, 90, 30);

        nameOfPassenger.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        nameOfPassenger.setForeground(new java.awt.Color(255, 255, 255));
        nameOfPassenger.setText("Name Of Passenger");
        this.add(nameOfPassenger);
        nameOfPassenger.setBounds(60, 110, 180, 30);

        from.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        this.add(from);
        from.setBounds(60, 180, 160, 30);

        departureTimeDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        departureTimeDate.setForeground(new java.awt.Color(255, 255, 255));
        departureTimeDate.setText("Departure Date Time");
        this.add(departureTimeDate);
        departureTimeDate.setBounds(310, 180, 200, 30);

        nameOfPasenger2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        nameOfPasenger2.setForeground(new java.awt.Color(255, 255, 255));

        nameOfPasenger2.setText(PassengerController.getLastNamePassengerByTicketNo(selectedTicket.getTicketNo()) + " " + PassengerController.getFirstNamePassengerByTicketNo(selectedTicket.getTicketNo()));

        this.add(nameOfPasenger2);
        nameOfPasenger2.setBounds(60, 134, 120, 20);

        from2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        from2.setForeground(new java.awt.Color(255, 255, 255));

        from2.setText((selectedTicket).getFlight().getDepartureAirport().getIdAirport());

        this.add(from2);
        from2.setBounds(60, 204, 70, 20);

        barcode.setIcon(new javax.swing.ImageIcon("img\\Tickets Barcodes\\" + selectedTicket.getTicketNo() + ".png"));
        this.add(barcode);
        barcode.setBounds(145, 385, 280, 150);

        airline.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        airline.setForeground(new java.awt.Color(255, 255, 255));
        airline.setText("Airline");
        this.add(airline);
        airline.setBounds(60, 308, 200, 30);

        airline2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        airline2.setForeground(new java.awt.Color(255, 255, 255));
        airline2.setText(selectedTicket.getFlight().getAirlineName());

        this.add(airline2);
        airline2.setBounds(60, 332, 150, 20);

        seatNo.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        seatNo.setForeground(new java.awt.Color(255, 255, 255));
        seatNo.setText("Seat");
        this.add(seatNo);
        seatNo.setBounds(310, 308, 160, 30);

        seatNo2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        seatNo2.setForeground(new java.awt.Color(255, 255, 255));
        seatNo2.setText(Integer.toString(selectedTicket.getSeat().getSeatNo()));
        seatNo2.setBounds(310, 332, 200, 20);
        this.add(seatNo2);

        className.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        className.setForeground(new java.awt.Color(255, 255, 255));
        className.setText(selectedTicket.getSeat().getClassName());
        this.add(className);
        className.setBounds(310, 346, 200, 20);

        this.setBounds(0, 0, 570, 580);
        this.setVisible(false);

    }

}
