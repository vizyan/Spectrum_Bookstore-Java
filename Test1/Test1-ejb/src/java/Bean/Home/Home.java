package Bean.Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.json.*;
import util.dbConnection;

/**
 *
 * @author Vizyan
 */
@Stateless
public class Home implements HomeLocal {

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
    
    @Override
    public JSONObject getBookById(int id){
        JSONObject data = new JSONObject();
        JSONObject object = new JSONObject();
        Connection con;
        PreparedStatement preparedStatement;
        
        try {
            con = dbConnection.createConnection();
            String query = "SELECT * FROM book WHERE id = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
      
            ResultSet result = preparedStatement.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            while(result.next()) {
                int count = rsmd.getColumnCount();
                for (int i=1; i<=count; i++) {
                    String column = rsmd.getColumnName(i);
                    object.put(column, result.getObject(column));
                }
            }
            
            data.put("message", "success");
            data.put("data", object);
            
        } catch (SQLException | JSONException ex){
            try {
                data.put("message", ex.getMessage());
            } catch (JSONException ex1) {}
        } 
        
        return data;
    }
}
