package view;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Flight;


public class PassengerView extends javax.swing.JFrame {

    private javax.swing.JLabel flightDetails;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    
    private javax.swing.JLabel arrival;
    private javax.swing.JLabel arrivalAirport;
    private javax.swing.JLabel arrivalDateTime;
    private javax.swing.JLabel departure;
    private javax.swing.JLabel departureAriport;
    private javax.swing.JLabel departureDateTime;
    private javax.swing.JLabel from;   
    private javax.swing.JLabel to;
    
    private javax.swing.JLabel arrival2;
    private javax.swing.JLabel arrivalAirport2;
    private javax.swing.JLabel arrivalDateTime2;
    private javax.swing.JLabel departure2;
    private javax.swing.JLabel departureAriport2;
    private javax.swing.JLabel departureDateTime2;
    private javax.swing.JLabel from2;   
    private javax.swing.JLabel to2;

    ArrayList<JLabel[]> labels = new ArrayList();
    ArrayList<JTextField[]> textFields = new ArrayList();
    ArrayList<JDateChooser> birthDates = new ArrayList();
   
  
    ArrayList<Flight> flights = new ArrayList();

    private int numberOfPassengers;
 
    public PassengerView(ArrayList<Flight> selectedFlight, int numberOfPassengers) {
        this.flights=selectedFlight;
        this.numberOfPassengers = numberOfPassengers;
        initComponents();
        this.setVisible(true);
        this.setSize(643, 815);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        flightDetails = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 112, 155));
        jPanel2.setLayout(null);

        flightDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        flightDetails.setText("Flight Details");
        flightDetails.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(flightDetails);
        flightDetails.setBounds(260, 0, 200, 40);

       
        //ONEWAY
        if(flights.size()==1)
        {
                    
        arrivalAirport = new javax.swing.JLabel();
        arrivalDateTime = new javax.swing.JLabel();
        arrival = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        departure = new javax.swing.JLabel();
        departureDateTime = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        departureAriport = new javax.swing.JLabel();
        
        arrivalAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        arrivalAirport.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAirport.setText(flights.get(0).getArrivalAirport().getIdAirport());
        jPanel2.add(arrivalAirport);
        arrivalAirport.setBounds(440, 170, 150, 30);

        arrivalDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        arrivalDateTime.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDateTime.setText(flights.get(0).getArrivalDateTimeToString());
        jPanel2.add(arrivalDateTime);
        arrivalDateTime.setBounds(90, 195, 130, 14);

        arrival.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        arrival.setForeground(new java.awt.Color(255, 255, 255));
        arrival.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        arrival.setText("Arrival");
        jPanel2.add(arrival);
        arrival.setBounds(50, 170, 160, 30);

        to.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("To");
        jPanel2.add(to);
        to.setBounds(310, 170, 50, 30);

        departure.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        departure.setForeground(new java.awt.Color(255, 255, 255));
        departure.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        departure.setText("Departure");
        jPanel2.add(departure);
        departure.setBounds(50, 100, 160, 30);

        departureDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        departureDateTime.setForeground(new java.awt.Color(255, 255, 255));
        departureDateTime.setText(flights.get(0).getDepartureDateTimeToString());
        jPanel2.add(departureDateTime);
        departureDateTime.setBounds(90, 125, 130, 14);

        from.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        jPanel2.add(from);
        from.setBounds(310, 100, 50, 30);

        departureAriport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        departureAriport.setForeground(new java.awt.Color(255, 255, 255));
        departureAriport.setText((flights.get(0).getDepartureAirport().getIdAirport()));
        jPanel2.add(departureAriport);
        departureAriport.setBounds(440, 100, 150, 30);
                jPanel2.setBounds(0, 0, 630, 290);

        }
        
        
        else if(flights.size()==2)
        {
                    
        arrivalAirport2 = new javax.swing.JLabel();
        arrivalDateTime2 = new javax.swing.JLabel();
        arrival2 = new javax.swing.JLabel();
        to2 = new javax.swing.JLabel();
        departure2 = new javax.swing.JLabel();
        departureDateTime2 = new javax.swing.JLabel();
        from2 = new javax.swing.JLabel();
        departureAriport2 = new javax.swing.JLabel();
        
        arrivalAirport2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        arrivalAirport2.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAirport2.setText(flights.get(1).getArrivalAirport().getIdAirport());
        jPanel2.add(arrivalAirport2);
        arrivalAirport2.setBounds(440, 250, 150, 30);

        arrivalDateTime2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        arrivalDateTime2.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDateTime2.setText(flights.get(1).getArrivalDateTimeToString());
        jPanel2.add(arrivalDateTime2);
        arrivalDateTime2.setBounds(90, 265, 130, 14);

        arrival2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        arrival2.setForeground(new java.awt.Color(255, 255, 255));
        arrival2.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        arrival2.setText("Arrival");
        jPanel2.add(arrival2);
        arrival2.setBounds(50, 240, 160, 30);

        to2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        to2.setForeground(new java.awt.Color(255, 255, 255));
        to2.setText("To");
        jPanel2.add(to2);
        to2.setBounds(310, 250, 50, 30);

        departure2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        departure2.setForeground(new java.awt.Color(255, 255, 255));
        departure2.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        departure2.setText("Departure");
        jPanel2.add(departure2);
        departure2.setBounds(50, 190, 160, 30);

        departureDateTime2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        departureDateTime2.setForeground(new java.awt.Color(255, 255, 255));
        departureDateTime2.setText(flights.get(1).getDepartureDateTimeToString());
        jPanel2.add(departureDateTime2);
        departureDateTime2.setBounds(90, 215, 130, 14);

        from2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        from2.setForeground(new java.awt.Color(255, 255, 255));
        from2.setText("From");
        jPanel2.add(from2);
        from2.setBounds(310, 190, 50, 30);

        departureAriport2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        departureAriport2.setForeground(new java.awt.Color(255, 255, 255));
        departureAriport2.setText((flights.get(1).getDepartureAirport().getIdAirport()));
        jPanel2.add(departureAriport2);
        departureAriport2.setBounds(440, 190, 150, 30);
        
        arrivalAirport = new javax.swing.JLabel();
        arrivalDateTime = new javax.swing.JLabel();
        arrival = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        departure = new javax.swing.JLabel();
        departureDateTime = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        departureAriport = new javax.swing.JLabel();
        
        
        arrivalAirport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        arrivalAirport.setForeground(new java.awt.Color(255, 255, 255));
        arrivalAirport.setText(flights.get(0).getArrivalAirport().getIdAirport());
        jPanel2.add(arrivalAirport);
        arrivalAirport.setBounds(440, 130, 150, 30);

        arrivalDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        arrivalDateTime.setForeground(new java.awt.Color(255, 255, 255));
        arrivalDateTime.setText(flights.get(0).getArrivalDateTimeToString());
        jPanel2.add(arrivalDateTime);
        arrivalDateTime.setBounds(90, 145, 130, 14);

        arrival.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        arrival.setForeground(new java.awt.Color(255, 255, 255));
        arrival.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        arrival.setText("Arrival");
        jPanel2.add(arrival);
        arrival.setBounds(50, 120, 160, 30);

        to.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("To");
        jPanel2.add(to);
        to.setBounds(310, 130, 50, 30);

        departure.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        departure.setForeground(new java.awt.Color(255, 255, 255));
        departure.setIcon(new javax.swing.ImageIcon("img\\output-onlinepngtools (7).png")); // NOI18N
        departure.setText("Departure");
        jPanel2.add(departure);
        departure.setBounds(50, 70, 160, 30);

        departureDateTime.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        departureDateTime.setForeground(new java.awt.Color(255, 255, 255));
        departureDateTime.setText(flights.get(0).getDepartureDateTimeToString());
        jPanel2.add(departureDateTime);
        departureDateTime.setBounds(90, 95, 130, 14);

        from.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        jPanel2.add(from);
        from.setBounds(310, 70, 50, 30);

        departureAriport.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        departureAriport.setForeground(new java.awt.Color(255, 255, 255));
        departureAriport.setText((flights.get(0).getDepartureAirport().getIdAirport()));
        jPanel2.add(departureAriport);
        departureAriport.setBounds(440, 70, 150, 30);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        jPanel2.setBounds(0, 0, 630, 300);
        }
        //STOP
        
        
        getContentPane().add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);
        jPanel3.setPreferredSize(new Dimension(100, 435 * numberOfPassengers));

        int y = 15;
        int y2 = 85;

        for (int i = 0; i < numberOfPassengers; i++) {

            JLabel[] label = new JLabel[9];
            JTextField[] text = new JTextField[7];

            for (int k = 0; k < 9; k++) {
                label[k] = new JLabel();
            }
            for (int k = 0; k < 7; k++) {
                text[k] = new JTextField();
            }

            label[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
            label[0].setText("Passenger " + (i + 1));
            label[0].setBounds(260, y, 130, 40);

            y += 70;
            label[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[1].setText("Email :");
            label[1].setBounds(30, y, 70, 20);

            y += 40;
            label[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[2].setText("First Name :");
            label[2].setBounds(30, y, 110, 20);

            y += 40;
            label[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[3].setText("Last Name :");
            label[3].setBounds(30, y, 110, 20);

            y += 40;
            label[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[4].setText("Address :");
            label[4].setBounds(30, y, 110, 20);

            y += 40;
            label[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[5].setText("Birth Date :");
            label[5].setBounds(30, y, 110, 20);

            y += 40;
            label[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[6].setText("Tel No :");
            label[6].setBounds(30, y, 110, 20);

            y += 40;
            label[7].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[7].setText("Nationality :");
            label[7].setBounds(30, y, 110, 20);

            y += 40;
            label[8].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
            label[8].setText("Passport No :");
            label[8].setBounds(30, y, 110, 20);

            y += 80;
            labels.add(label);
            JDateChooser birthDate = new JDateChooser();
            birthDate.setOpaque(false);
            birthDates.add(birthDate);

            text[0].setBounds(160, y2, 120, 20);
            text[0].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[1].setBounds(160, y2, 120, 20);
            text[1].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[2].setBounds(160, y2, 120, 20);
            text[2].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[3].setBounds(160, y2, 120, 20);
            text[3].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            birthDate.setBounds(160, y2, 120, 20);

            y2 += 40;
            text[4].setBounds(160, y2, 120, 20);
            text[4].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[5].setBounds(160, y2, 120, 20);
            text[5].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            text[6].setBounds(160, y2, 120, 20);
            text[6].setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N

            y2 += 40;
            textFields.add(text);

            System.out.println("Y+Y2 " + (y + y2));
            System.out.println("y2 " + y2);

            if (i == numberOfPassengers - 1) {

                JButton jButton1 = new JButton();

                jButton1.setBackground(new java.awt.Color(55, 112, 155));
                jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Next");
                jButton1.setBorderPainted(false);
                jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                jButton1.setFocusable(false);
                jButton1.setBounds(470, y2, 110, 30);

                jPanel3.add(jButton1);
            } else {
                y2 += 110;
            }
        }

        for (int i = 0; i < labels.size(); i++) {
            for (int j = 0; j < 9; j++) {
                jPanel3.add(labels.get(i)[j]);
            }

        }

        for (int i = 0; i < textFields.size(); i++) {
            for (int j = 0; j < 7; j++) {
                jPanel3.add(textFields.get(i)[j]);
            }

        }

        for (int i = 0; i < birthDates.size(); i++) {
            jPanel3.add(birthDates.get(i));
        }

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 290, 630, 490);
        pack();

    }

}
