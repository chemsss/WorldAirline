package DataAcessObjectImpl;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Unknow
 */
public class DatabaseConnection {

    private static Connection con = null;

    public static Connection getInstance() {

        if (con == null) {
            try {
                // 1. Load the properties file
                Properties props = new Properties();
                props.load(new FileInputStream("demo.properties"));

                // 2. Read the props
                String theUser = props.getProperty("user");
                String thePassword = props.getProperty("password");
                String theDburl = props.getProperty("dburl");

                System.out.println("Connecting to database...");
                System.out.println("Database URL: " + theDburl);
                System.out.println("User: " + theUser);

                // 3. Get a connection to database
                con = DriverManager.getConnection(theDburl, theUser, thePassword);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }

        }
        return con;
    }

}
