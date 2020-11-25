package view;

import controller.CustomerLoginController;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class CustomerLoginChoice implements ActionListener {

    private CustomerLogin frame;

    public CustomerLoginChoice(CustomerLogin f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Login": {
                String[] entry = frame.getEntry(); 
                System.out.println("test");
                if(new CustomerLoginController().CustomerLoginConnection(entry[0],getMD5Hash(entry[1]))==true)
                    System.out.println("oui");
                else{
                  JOptionPane.showMessageDialog(null, "wrong email/password", "", JOptionPane.ERROR_MESSAGE);

                        }

            }
            break;

            case "sign up":
                // new signUp();
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
