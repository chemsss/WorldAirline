package controller;

import java.awt.event.*;
import java.math.BigInteger;
import view.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EmployeeLoginController implements ActionListener {

    private EmployeeLogin frame;

    public EmployeeLoginController(EmployeeLogin f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "login": {
                String[] saisi = frame.getSaisi();
                
                
            //   if(saisi[0] )

            }
            break;

            case "sign up":
                // new CustomerLogin();
                frame.dispose(); // on ferme la fenetre actuelle
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
