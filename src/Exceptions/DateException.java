package Exceptions;
import javax.swing.JOptionPane;
public class DateException extends Exception {
    
    public DateException(String str) {
        super(str);
        JOptionPane.showMessageDialog(null , str, "", 0);
    }
    
    
}
