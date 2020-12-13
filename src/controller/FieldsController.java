package controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.FlightSeat;


public class FieldsController {

    public static boolean checkSignUp(String email, String password, String lastName, String firstName, String telephoneNumber) {
        String str = "";
        if (email.split("@").length != 2 || email.split("@")[1].split("\\.").length != 2) {
            str = str + "Your email has to be in the same format as the following example : email@hotmail.com\n";
        }
        if (lastName.contains("1") || lastName.contains("2") || lastName.contains("3") || lastName.contains("4") || lastName.contains("5") || lastName.contains("6") || lastName.contains("7")
                || lastName.contains("8") || lastName.contains("9") || lastName.contains("0")
                || firstName.contains("1") || firstName.contains("2") || firstName.contains("3") || firstName.contains("4") || firstName.contains("5") || firstName.contains("6") || firstName.contains("7")
                || firstName.contains("8") || firstName.contains("9") || firstName.contains("0")) {

            str = str + "You can't have a number in your last or first name.\n";
        }

        if (telephoneNumber.charAt(0) != '+') {
            str += "You must type your phone number in the format + followed by the international calling code of your country then the rest of your number.\n";
        }
        String str2 = null;
        for (int i = 1; i < telephoneNumber.length(); ++i) {
            if (!Character.isDigit(telephoneNumber.charAt(i)) && telephoneNumber.charAt(i) != ' ') {
                str2 = "Your phone number can't contain letters.";
                System.out.println(telephoneNumber.charAt(i));
            }
        }
        if (str2 != null) {
            str += "Your phone number can't contain letters.";
        }

        if (!str.equals("")) {
            JOptionPane.showMessageDialog(null, str, "", 0);
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSeatNumbers(ArrayList<JComboBox<FlightSeat>> DepartAvailableSeatChoice, ArrayList<JComboBox<FlightSeat>> ReturnAvailableSeatChoice, int numberofpassengers) {

        if (numberofpassengers > 1) {
            for (int i = 0; i < DepartAvailableSeatChoice.size(); ++i) {
                for (int j = 0; j < DepartAvailableSeatChoice.size(); ++j) {
                    if (i != j) {
                        if (((FlightSeat) DepartAvailableSeatChoice.get(i).getSelectedItem()).getSeatNo() == ((FlightSeat) DepartAvailableSeatChoice.get(j).getSelectedItem()).getSeatNo()) {
                            return false;
                        }
                    }
                }
            }
            if (ReturnAvailableSeatChoice.size() > 0) {
                for (int i = 0; i < ReturnAvailableSeatChoice.size(); ++i) {
                    for (int j = 0; j < ReturnAvailableSeatChoice.size(); ++j) {
                        if (i != j) {
                            if (((FlightSeat) ReturnAvailableSeatChoice.get(i).getSelectedItem()).getSeatNo() == ((FlightSeat) ReturnAvailableSeatChoice.get(j).getSelectedItem()).getSeatNo()) {
                                return false;
                            }
                        }
                    }
                }
            }

        }

        return true;
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

    public static boolean checkPassengerInfo(String email, String password, String lastName, String firstName, String telephoneNumber, String nationality, String passportNo) {
        String str = "";
        if (email.split("@").length != 2 || email.split("@")[1].split("\\.").length != 2) {
            str = str + "Your email has to be in the same format as the following example : email@hotmail.com\n";
        }
        if (lastName.contains("1") || lastName.contains("2") || lastName.contains("3") || lastName.contains("4") || lastName.contains("5") || lastName.contains("6") || lastName.contains("7")
                || lastName.contains("8") || lastName.contains("9") || lastName.contains("0")
                || firstName.contains("1") || firstName.contains("2") || firstName.contains("3") || firstName.contains("4") || firstName.contains("5") || firstName.contains("6") || firstName.contains("7")
                || firstName.contains("8") || firstName.contains("9") || firstName.contains("0")) {

            str = str + "You can't have a number in your last or first name.\n";
        }

        if (telephoneNumber.charAt(0) != '+') {
            str += "You must type your phone number in the format + followed by the international calling code of your country then the rest of your number.\n";
        }
        String str2 = null;
        for (int i = 1; i < telephoneNumber.length(); ++i) {
            if (!Character.isDigit(telephoneNumber.charAt(i)) && telephoneNumber.charAt(i) != ' ') {
                str2 = "Your phone number can't contain letters.";
                System.out.println(telephoneNumber.charAt(i));
            }
        }
        if (str2 != null) {
            str += "Your phone number can't contain letters.";
        }

        String str3 = null;
        for (int i = 0; i < nationality.length(); ++i) {
            if (Character.isDigit(nationality.charAt(i))) {
                str3 = "Your nationality can't contain digits.";
                System.out.println(nationality.charAt(i));
            }
        }
        if (str3 != null) {
            str += "Your phone number can't contain letters.";
        }

        if (!str.equals("")) {
            JOptionPane.showMessageDialog(null, str, "", 0);
            return false;
        } else {
            return true;
        }
    }

}
