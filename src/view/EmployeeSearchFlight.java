/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DataAcessObjectImpl.FlightDAOImpl;
import controller.SearchFlightsTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import model.Flight;
import DataAcessObjectImpl.*;
import controller.FlightController;

/**
 *
 * @author Chems
 */
public class EmployeeSearchFlight extends JPanel {
    
    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane DepartureScrollPane1;
    private javax.swing.JLabel idflight1;
    private javax.swing.JButton search1;
    private javax.swing.JTable searchDeapartureFlights1;
    private javax.swing.JTextField textidflight1;
    private javax.swing.JLabel title1;
    // End of variables declaration  
    
 
    
    public EmployeeSearchFlight() {
        super();
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int)screenSize.getWidth(),(int)screenSize.getHeight()));
        setBounds(0, 0, 1100, 570);
        
    }

    
    private void initComponents() {

        
        title1 = new javax.swing.JLabel();
        search1 = new javax.swing.JButton();
        textidflight1 = new javax.swing.JTextField();
        idflight1 = new javax.swing.JLabel();
        DepartureScrollPane1 = new javax.swing.JScrollPane();
        searchDeapartureFlights1 = new javax.swing.JTable();

        setLayout(null);

        title1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        title1.setText("Search Flight:");
        add(title1);
        title1.setBounds(370, 10, 110, 30);

        search1.setText("research");
        search1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!textidflight1.getText().isEmpty())
                {
                    ArrayList<Flight> flight= new ArrayList();
                    
                    flight.add(FlightController.getFlight(Integer.parseInt(textidflight1.getText())));
                    
                    searchDeapartureFlights1.setModel(new SearchFlightsTableModel(flight));
                    
                }
                
            }
        });
        add(search1);
        search1.setBounds(400, 60, 90, 23);

        textidflight1.setText("");
        textidflight1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        add(textidflight1);
        textidflight1.setBounds(220, 63, 150, 20);

        idflight1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        idflight1.setText("Enter the id of a flight: ");
        add(idflight1);
        idflight1.setBounds(40, 60, 156, 22);



        searchDeapartureFlights1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12));

        searchDeapartureFlights1.setFocusable(false);
        searchDeapartureFlights1.setGridColor(new java.awt.Color(0, 0, 0));
        searchDeapartureFlights1.setOpaque(false);
        searchDeapartureFlights1.setRowHeight(20);
        searchDeapartureFlights1.setSelectionBackground(new java.awt.Color(200, 191, 191));
        searchDeapartureFlights1.setShowHorizontalLines(false);
        searchDeapartureFlights1.setShowVerticalLines(false);
        searchDeapartureFlights1.getTableHeader().setReorderingAllowed(false);
        DepartureScrollPane1.setViewportView(searchDeapartureFlights1);

        add(DepartureScrollPane1);
        DepartureScrollPane1.setBounds(210, 140, 452, 402);

        this.setLayout(null);



    } 
    
    
}
