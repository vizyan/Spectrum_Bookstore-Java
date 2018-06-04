/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Login;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.User;
import org.json.*;
import util.dbConnection;

/**
 *
 * @author Vizyan
 */
@Stateless
public class Login implements LoginLocal {
    
    @Override
    public JSONObject loginUser(User user){
        
        String username = user.getUsername();
        String password = user.getPassword();
        JSONObject data = new JSONObject();
        JSONObject obj = new JSONObject();
        
        Connection con;
        PreparedStatement preparedStatement;
        
        try
        {
            con = dbConnection.createConnection();
            String query = "SELECT * FROM user WHERE username = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            
            ResultSet result = preparedStatement.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            while(result.next()) {
                int count = rsmd.getColumnCount();
                for (int i=1; i<=count; i++) {
                    String column = rsmd.getColumnName(i);
                    obj.put(column, result.getObject(column));
                }
            }
            
            if(password.equals(obj.get("password").toString())){
                data.put("message", "success");
                data.put("data", obj);
            } else {
                data.put("message", "failed");
            }
        }
        catch(SQLException | JSONException e)
        {
            try {
                data.put("message", e.getMessage().toString());
            } catch (JSONException ex) {}
        }
        
        return data;
    }
}
