package view;

import view.Employee.EmployeeLogin;
import view.Customer.LogInFrame;
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
                break;

            case "Book a Flight !":
                new LogInFrame(frame);  
                break;
            case "Admin":
                 new EmployeeLogin(frame);
                break;
        }

    }

}
