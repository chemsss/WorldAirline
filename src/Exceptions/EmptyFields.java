/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author Unknow
 */
public class EmptyFields extends Exception {

    public EmptyFields() throws EmptyFields{
        super("They are one or more empty fields");
        JOptionPane.showMessageDialog(null, "They are one or more empty fields", "Empty field(s)", JOptionPane.ERROR_MESSAGE);
    }

}
