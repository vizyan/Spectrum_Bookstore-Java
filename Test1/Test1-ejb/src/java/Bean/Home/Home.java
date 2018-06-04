/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.ejb.Stateless;
import org.json.*;
import util.dbConnection;

/**
 *
 * @author Vizyan
 */
@Stateless
public class Home implements HomeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public JSONObject getAllBook(){
        JSONObject data = new JSONObject();
        
        JSONArray array = new JSONArray();
        Connection con;
        PreparedStatement preparedStatement;
        
        try {
            con = dbConnection.createConnection();
            String query = "SELECT * FROM book";
            preparedStatement = con.prepareStatement(query);
      
            ResultSet result = preparedStatement.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            while(result.next()) {
                JSONObject obj = new JSONObject();
                int count = rsmd.getColumnCount();
                for (int i=1; i<=count; i++) {
                    String column = rsmd.getColumnName(i);
                    obj.put(column, result.getObject(column));
                }
                array.put(obj);
            }  
            
            data.put("message", "success");
            data.put("data", array);
        } catch(SQLException | JSONException e)
        {
            try {
                data.put("message", e.getMessage());
            } catch (JSONException ex) {}
        }
        
        return data;
    }
}
