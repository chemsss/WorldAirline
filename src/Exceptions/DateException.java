/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.time.*;
import java.time.chrono.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Chems
 */

public class DateException extends Exception {
    
    public DateException(String str){
        super(str);
        JOptionPane.showMessageDialog(null , str, "", 0);
    }
    
    
}
