/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Home;

import javax.ejb.Local;
import org.json.JSONObject;

/**
 *
 * @author Vizyan
 */
@Local
public interface HomeLocal {
    public JSONObject getAllBook();
    public JSONObject getBookById(int id);
    public String updateStok(int id, int stock);
}
