/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author Chems
 */
public class SignUpController {
    
    public boolean checkFields(String email, String password, String lastName, String firstName ) {
        String str = "";
        if(email.split("@").length!=2 || email.split("@")[1].split("\\.").length!=2) {
            str = str +"Your email has to be in the same format as the following example : email@hotmail.com";
        }
        else if (lastName.contains("1") || lastName.contains("2") ){
            
        }
                
        
        JOptionPane.showMessageDialog(null , str, "", 0);
        return false;
    }
    
}
