package test;

import controller.SearchFlightsTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Flight;
import controller.FlightController;

public class EmployeeSearchFlight extends JPanel {

    private javax.swing.JScrollPane DepartureScrollPane;
    private javax.swing.JLabel idFlight;
    private javax.swing.JButton search;
    private javax.swing.JTable searchDeapartureFlights;
    private javax.swing.JTextField textidFlight;
    private javax.swing.JLabel title1;
    private ArrayList<Flight> flight;
    private final int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public EmployeeSearchFlight() {
        super();
        initComponents();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBounds(0, 0, screenWidth, screenHeight);
        this.setBackground(new java.awt.Color(55, 112, 155));

    }

    private void initComponents() {

        flight = new ArrayList();
        title1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        textidFlight = new javax.swing.JTextField();
        idFlight = new javax.swing.JLabel();
        DepartureScrollPane = new javax.swing.JScrollPane();
        searchDeapartureFlights = new javax.swing.JTable();

        setLayout(null);

        title1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));

        title1.setText("Search Flight");
        add(title1);
        title1.setBounds((screenWidth / 2) - 100, 20, 300, 40);

        searchDeapartureFlights.setModel(new SearchFlightsTableModel(flight));

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        search.setText("Next");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 181, 204)));
        search.setBorderPainted(false);
        search.setBounds(550, 122, 90, 30);

        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (!textidFlight.getText().isEmpty()) {
                   
                    if (FlightController.checkFlight(Integer.parseInt(textidFlight.getText()))) {
                        flight.add(FlightController.getFlight(Integer.parseInt(textidFlight.getText())));


                        searchDeapartureFlights.setModel(new SearchFlightsTableModel(flight));
                                                                        flight = new ArrayList<Flight>();

                    }

                }

            }
        });
        add(search);

       
        add(textidFlight);
        textidFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        textidFlight.setBounds(380, 120, 150, 32);

        idFlight.setFont(new java.awt.Font("Yu Gothic UI light", 0, 20)); // NOI18N
        idFlight.setForeground(new java.awt.Color(255, 255, 255));
        idFlight.setText("Enter the flight Id: ");
        add(idFlight);
        idFlight.setBounds(200, 120, 300, 30);

        searchDeapartureFlights.setRowHeight(20);
        searchDeapartureFlights.setToolTipText("");
        searchDeapartureFlights.setSelectionBackground(new java.awt.Color(0, 204, 0));
        searchDeapartureFlights.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchDeapartureFlights.setShowGrid(true);
        searchDeapartureFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));

        DepartureScrollPane.setViewportView(searchDeapartureFlights);

        add(DepartureScrollPane);
        DepartureScrollPane.setBounds(200, 200, 1000, 500);

        //   searchDeapartureFlights.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setLayout(null);

    }

}
