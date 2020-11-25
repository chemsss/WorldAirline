package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

public class MainMenuController implements ActionListener {

    private MainMenu frame;

    public MainMenuController(MainMenu f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Contacts":
                new CustomerLogin();
                frame.dispose(); // on femre la fenetre actuelle
                break;

            case "Subscribe":
                new CustomerLogin();
                frame.dispose(); // on ferme la fenetre actuelle
                break;

            case "Book a Flight !":
                
                new CustomerLogin();
                //frame.dispose(); // on ferme la fenetre actuelle
                break;
            case "Admin":
                 new EmployeeLogin();
                //frame.dispose(); // on ferme la fenetre actuelle
                break;
        }

    }

}
