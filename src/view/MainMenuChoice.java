package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuChoice implements ActionListener {

    private MainMenu frame;

    public MainMenuChoice(MainMenu f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Contacts":
                new Contact();  
                break;

            case "Subscribe":
             //   new CustomerLogin();
                //  frame.dispose(); // on ferme la fenetre actuelle
                break;

            case "Book a Flight !":
                new CustomerLogin(frame);
                //frame.dispose(); // on ferme la fenetre actuelle
                break;
            case "Admin":
                 new EmployeeLogin();
               //  frame.dispose(); // on ferme la fenetre actuelle
                break;
        }

    }

}
