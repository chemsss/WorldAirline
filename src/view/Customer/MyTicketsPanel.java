package view.Customer;

import controller.SearchTicketsTableModel;
import controller.TicketController;
import javax.swing.JPanel;
import model.Booking;
import model.Ticket;

public class MyTicketsPanel extends javax.swing.JPanel {

    // My Tickets                
    private javax.swing.JLabel myTickets;
    private javax.swing.JScrollPane myTicketsScrollPane;
    private javax.swing.JTable myTicketsTable;
    private javax.swing.JButton previous3;
    private javax.swing.JButton viewTicket;

    //Selected ticket
    private Ticket selectedTicket;
    //Selected Booking
    private Booking selectedBooking;

    //My Booking Panel
    private JPanel myBookingsPanel;
    
    //My Ticket Panel
    private JPanel myTicketDetailPanel;
    
        //MyAccountFrame
  private MyAccountFrame frame ;

    public MyTicketsPanel(MyBookingsPanel myBookingsPanel, Booking selectedBooking,MyAccountFrame frame) {
        super();
        this.frame=frame;
        this.selectedBooking = selectedBooking;

        this.myBookingsPanel = myBookingsPanel;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        myTickets = new javax.swing.JLabel();
        previous3 = new javax.swing.JButton();
        myTicketsScrollPane = new javax.swing.JScrollPane();
        myTicketsTable = new javax.swing.JTable();
        viewTicket = new javax.swing.JButton();

        setBackground(new java.awt.Color(55, 112, 155));

        this.setBackground(new java.awt.Color(55, 112, 155));
        this.setLayout(null);

        myTickets.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        myTickets.setForeground(new java.awt.Color(255, 255, 255));
        myTickets.setText("My Tickets");
        this.add(myTickets);
        myTickets.setBounds(200, 10, 140, 40);

        previous3.setBackground(new java.awt.Color(255, 255, 255));
        previous3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        previous3.setText("Previous");
        previous3.setBorder(null);
        previous3.setBorderPainted(false);
        previous3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        previous3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myBookingsPanel.setVisible(true);

                setVisible(false);
                frame.setSize(530,615);

            }
        });
        this.add(previous3);
        previous3.setBounds(3, 555, 60, 20);

        myTicketsTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        SearchTicketsTableModel model2 = new SearchTicketsTableModel(selectedBooking.getBookingNo());

        myTicketsTable.setModel(model2);
        myTicketsTable.setRowHeight(20);

        myTicketsTable.setToolTipText("");
        myTicketsTable.setSelectionBackground(new java.awt.Color(0, 204, 0));
        myTicketsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myTicketsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myTicketsTable.setShowGrid(true);
        myTicketsScrollPane.setViewportView(myTicketsTable);

        this.add(myTicketsScrollPane);
        myTicketsScrollPane.setBounds(20, 90, 480, 390);

        viewTicket.setBackground(new java.awt.Color(255, 255, 255));
        viewTicket.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        viewTicket.setText("Ticket Details");
        viewTicket.setBorder(null);
        viewTicket.setBorderPainted(false);
        viewTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JPanel myPanel=this;
        viewTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //If a Ticket is selected
                if (!myTicketsTable.getSelectionModel().isSelectionEmpty()) {
                    String stringTicketNo = myTicketsTable.getValueAt(myTicketsTable.getSelectedRow(), 0).toString();

                    int TicketNo = Integer.parseInt(stringTicketNo);

                    selectedTicket = TicketController.getTicket(TicketNo);
                    System.out.println(selectedTicket);

                  
                    setVisible(false);
                    myTicketDetailPanel = new MyTicketDetailPanel((MyTicketsPanel) myPanel,selectedTicket,frame);
                    myTicketDetailPanel.setVisible(true);
                    frame.getContentPane().add(myTicketDetailPanel);     
                    frame.setSize(550,615);

               
                }

            }
        });

        this.add(viewTicket);
        viewTicket.setBounds(170, 520, 190, 30);

        this.setBounds(0, 0, 530, 580);
        this.setVisible(false);

    }

}
