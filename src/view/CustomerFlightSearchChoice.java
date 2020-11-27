package view;

import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import view.CustomerHomeFlightSearch;
import model.*;

public class CustomerFlightSearchChoice implements ActionListener {

    private CustomerHomeFlightSearch frame;

    public CustomerFlightSearchChoice(CustomerHomeFlightSearch f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Search": {
                
                
                if(frame.getOneWay().isSelected()) {
                    if(((Airport)frame.getFromDeparture().getSelectedItem()).getIdAirport().equals(((Airport)frame.getToArrival().getSelectedItem()).getIdAirport())) {
                        JOptionPane.showMessageDialog(null , "Please choose an arrival airport different from the departure airport", "Departure and arrival airports are the same", 0);
                        
                    }
                    
                }
                
                
            }
            break;
                
                
                
            
            case "Next":
                // new signUp();
                frame.dispose(); // on ferme la fenetre actuelle
                break;

        }

    }
    
}

