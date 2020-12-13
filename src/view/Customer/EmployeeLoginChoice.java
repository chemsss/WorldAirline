package view.Customer;

import controller.EmployeeLoginController;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.*;
import javax.swing.*;

public class EmployeeLoginChoice implements ActionListener {

    private EmployeeLogin frame;

    public EmployeeLoginChoice(EmployeeLogin f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

           case "Login": {
                String[] entry = frame.getEntry();
                
                if (new EmployeeLoginController().EmployeeLoginConnection(entry[0], getMD5Hash(entry[1])) == true) {
                   
                    System.out.println("oui");
                    frame.dispose();
                    
                }
                else{
                  JOptionPane.showMessageDialog(null, "Wrong email/password, please retry ", "", JOptionPane.ERROR_MESSAGE);
                        }
            }
            break;
        }

    }

    public static String getMD5Hash(String s) {

        String result = s;
        try {
            if (s != null) {
                MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1" 
                md.update(s.getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                result = hash.toString(16);
                while (result.length() < 32) { // 40 for SHA-1 
                    result = "0" + result;
                }
            }

        } catch (NoSuchAlgorithmException e) {

        }
        return result;

    }
}
