package Exceptions;

import javax.swing.JOptionPane;

public class EmptyFields extends Exception {

    public EmptyFields() throws EmptyFields{
        super("They are one or more empty fields");
        JOptionPane.showMessageDialog(null, "They are one or more empty fields", "Empty field(s)", JOptionPane.ERROR_MESSAGE);
    }

}
