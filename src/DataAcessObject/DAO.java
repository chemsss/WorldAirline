package DataAcessObject;
import java.sql.Connection;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class DAO<T> {

    
    private Connection con;
    private String user;
    private String password;
    private String url;
    
    public DAO() {
        
        try {
            con = null;
            
            Properties props = new Properties();
            //props.load(new FileInputStream("demo.properties"));
            props.load(new FileInputStream("C:\\Users\\Chems\\Documents\\GitHub\\worldAirline\\sql/demo.properties"));
            
            user = props.getProperty("user");
            password = props.getProperty("password");
            url = props.getProperty("password");
            
        } catch(Exception e) {
            System.out.println("File problem");
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract void find(int id);
    
    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    //public abstract T create(T obj);
    
    /**
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     */
    //public abstract T update(T obj);
    
    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     * @return 
     */
    //public abstract void delete(T obj);
    
    
    
    
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
