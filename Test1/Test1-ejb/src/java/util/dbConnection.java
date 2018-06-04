package util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Vizyan
 */
@Stateless
@LocalBean
public class dbConnection {
    
    public static Connection createConnection()
    {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/assigment_rsbk_2018";
        String username = "root";
        String password = "";
        
        try 
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
            } 
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            
            con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
            System.out.println("Connection Success " +con);
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return con; 
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
