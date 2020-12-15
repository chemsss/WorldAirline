package worldairline;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.MainMenu;

public class WorldAirline {


    public static void main(String[] args) {
        
        try {


        new MainMenu();
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
            System.out.println(e.getMessage());
        }
    }

}
