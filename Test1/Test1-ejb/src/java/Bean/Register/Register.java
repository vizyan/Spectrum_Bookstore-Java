package Bean.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.ejb.Stateless;
import model.User;
import org.json.JSONException;
import org.json.JSONObject;
import util.dbConnection;

/**
 *
 * @author Vizyan
 */
@Stateless
public class Register implements RegisterLocal {
    
    @Override
    public JSONObject registerUser(User user)
    {
        String name = user.getName();
        String username = user.getUsername();
        String password = user.getPassword();
        String address = user.getAddress();
        
        JSONObject data = new JSONObject();
        
        Connection con;
        PreparedStatement preparedStatement;
        
        try
        {
            con = dbConnection.createConnection();
            String query = "INSERT INTO user (name, username, password, address) VALUES (?, ?, ?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, address);
            
            int result = preparedStatement.executeUpdate();
            
            if (result!=0){
                data.put("message", "success");
            } else {
                data.put("message", "failed");
            }
        }
        catch(SQLException | JSONException e)
        {
            try {
                data.put("message", e.getMessage());
            } catch (JSONException ex) {}
        }
        
        return data;
    }
}
