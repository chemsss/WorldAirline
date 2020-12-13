package view;

import Exceptions.EmptyFields;
import com.toedter.calendar.JDateChooser;
import controller.FieldsController;
import controller.FlightController;
import controller.FlightSeatsController;
import controller.TicketController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.*;
import model.Booking;
import model.CustomerAccount;
import model.Flight;
import model.FlightSeat;
import model.Passenger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class EmployeeAddTicket extends javax.swing.JFrame {

    //Passengers Details
    private javax.swing.JButton jButton1;
    JDateChooser birthDate = new JDateChooser();
    JLabel[] label = new JLabel[10];
    JTextField[] text = new JTextField[7];
    JComboBox<FlightSeat> availableSeatChoice = new JComboBox();
    private javax.swing.JPanel passengersPanel;
    JLabel flightId = new JLabel();
    JTextField flightIdField = new JTextField();
    private ButtonGroup className = new ButtonGroup();
    private JRadioButton classEconomy = new JRadioButton("Economy Class");
    private JRadioButton classBusiness = new JRadioButton("Business Class");
    private JRadioButton classFirst = new JRadioButton("First Class");

    //Selected flight(s)
    ArrayList<Flight> flights = new ArrayList();

    private Booking booking;
    private int idFlight;

    public EmployeeAddTicket(Booking booking, int idFlight) {
        super();
        this.booking = booking;
        this.idFlight = idFlight;
        initComponents();
        setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
        
    }

    private void initComponents() {

        passengersPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        passengersPanel.setBackground(new java.awt.Color(255, 255, 255));
        passengersPanel.setForeground(new java.awt.Color(255, 255, 255));
        passengersPanel.setLayout(null);
        

        int y = 30;
        int y2 = 98;

        for (int k = 0; k < label.length; k++) {
            label[k] = new JLabel();
        }
        for (int k = 0; k < text.length; k++) {
            text[k] = new JTextField();
        }

        className.add(classEconomy);
        className.add(classBusiness);
        className.add(classFirst);

        flightId.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        flightId.setText("Enter idFlight :");
        flightId.setBounds(30, 15, 70, 20);

        flightIdField.setBounds(195, 15, 130, 32);
        flightIdField.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        jButton1 = new JButton();

        label[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        label[0].setText("Passenger ");
        label[0].setBounds(260, y, 130, 40);

        y += 70;
        label[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[1].setText("Email :");
        label[1].setBounds(30, y, 70, 20);

        y += 40;
        label[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[2].setText("First Name :");
        label[2].setBounds(30, y, 110, 20);

        y += 40;
        label[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[3].setText("Last Name :");
        label[3].setBounds(30, y, 110, 20);

        y += 40;
        label[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[4].setText("Address :");
        label[4].setBounds(30, y, 110, 20);

        y += 40;
        label[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[5].setText("Birth Date :");
        label[5].setBounds(30, y, 110, 20);

        y += 40;
        label[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[6].setText("Tel No :");
        label[6].setBounds(30, y, 110, 20);

        y += 40;
        label[7].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[7].setText("Nationality :");
        label[7].setBounds(30, y, 110, 25);

        y += 40;
        label[8].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[8].setText("Passport No :");
        label[8].setBounds(30, y, 200, 25);
        
        y += 40;
        
        
        JLabel classNameLabel = new JLabel("Class Name :");
        classNameLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20));
        classNameLabel.setBounds(30, y, 110, 30);
        passengersPanel.add(classNameLabel);
        classEconomy.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15));
        classEconomy.setBounds(195, y, 120, 25);
        classEconomy.setContentAreaFilled(false);
        classEconomy.setFocusable(false);
        
        classEconomy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (classEconomy.isSelected())
                {
                    availableSeatChoice.setVisible(true);
                availableSeatChoice.setModel(new DefaultComboBoxModel(FlightSeatsController.getAvailableSeats(idFlight, "Economy Class")));
                }
                
                
            }
        });
        passengersPanel.add(classEconomy);
        y += 30;
        classBusiness.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15));
        classBusiness.setBounds(195, y, 120, 25);
        classBusiness.setContentAreaFilled(false);
        classBusiness.setFocusable(false);
        classBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (classBusiness.isSelected())
                {
                availableSeatChoice.setVisible(true);
                availableSeatChoice.setModel(new DefaultComboBoxModel(FlightSeatsController.getAvailableSeats(idFlight, "Business Class")));
                }
               
                

            }
        });
        passengersPanel.add(classBusiness);

        y += 30;
        classFirst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15));
        classFirst.setBounds(195, y, 120, 25);
        classFirst.setContentAreaFilled(false);
        classFirst.setFocusable(false);
        classFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (classFirst.isSelected())
                {
                    availableSeatChoice.setVisible(true);
                availableSeatChoice.setModel(new DefaultComboBoxModel(FlightSeatsController.getAvailableSeats(idFlight, "First Class")));
                }
                
                

            }
        });
        passengersPanel.add(classFirst);
        

        y += 40;
        label[9].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        label[9].setText("Seat No :");
        label[9].setBounds(30, y, 200, 25);
        availableSeatChoice.setBounds(195, y, 130, 32);
        availableSeatChoice.setVisible(false);
        AutoCompleteDecorator.decorate(availableSeatChoice);

        passengersPanel.add(availableSeatChoice);
        

        y += 80;
        birthDate.setOpaque(false);

        text[0].setBounds(195, y2, 130, 32);
        text[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;
        text[1].setBounds(195, y2, 130, 32);
        text[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;
        text[2].setBounds(195, y2, 130, 32);
        text[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        JComboBox<FlightSeat> seatChoice = new JComboBox();
       
        seatChoice.setOpaque(false);
        availableSeatChoice.add(seatChoice);

        y2 += 40;
        text[3].setBounds(195, y2, 130, 32);
        text[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;
        birthDate.setBounds(195, y2, 130, 32);

        y2 += 40;
        text[4].setBounds(195, y2, 130, 32);
        text[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;
        text[5].setBounds(195, y2, 130, 32);
        text[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;
        text[6].setBounds(195, y2, 130, 32);
        text[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

        y2 += 40;

        jButton1.setBackground(new java.awt.Color(55, 112, 155));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setBounds(260, 600, 110, 30);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    for (int i = 0; i < text.length; i++) {

                        if (text[i].getText().isEmpty()) {
                            throw new EmptyFields();
                        }

                    }
                    
                    if (birthDate.getDate() == null) {
                        throw new EmptyFields();

                    }
                   if( (classEconomy.isSelected())||(classBusiness.isSelected())||(classFirst.isSelected()))
                   {
                       
                       java.util.Date birthDateUtil = ((JDateChooser) birthDate).getDate();
                        java.sql.Date birthDateSql = new java.sql.Date(birthDateUtil.getTime());
                       //String email, String firstName, String lastName, String address, Date dateOfBirth, String telephoneNumber, String nationality, String passportNo, ArrayList<Ticket> tickets
                       Passenger passenger= new Passenger(text[0].getText(),text[1].getText(),text[2].getText(),text[3].getText(), birthDateSql,text[4].getText(),text[5].getText(),text[6].getText());
                       TicketController.addTicketToBooking(booking.getBookingNo(), passenger, ((FlightSeat)availableSeatChoice.getSelectedItem()).getSeatNo() , idFlight);
                      
                   }else
                   {
                       JOptionPane.showMessageDialog(null, "Please, select a class");
                   }
 

                } catch (EmptyFields exception) {
                    System.out.println(exception.getMessage());
                }

            }

        });

        passengersPanel.add(jButton1);

        for (int i = 0; i < label.length; i++) {

            passengersPanel.add(label[i]);

        }

        for (int i = 0; i < text.length; i++) {

            passengersPanel.add(text[i]);

        }

        passengersPanel.add(birthDate);

        
        
        
        getContentPane().add(passengersPanel);
        passengersPanel.setBounds(0,0,643, 815);

      
        pack();

    }

    public JPanel getPassengersPanel() {
        return passengersPanel;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

}
