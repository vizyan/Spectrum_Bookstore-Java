/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Login;

import javax.ejb.Local;
import model.User;
import org.json.*;

/**
 *
 * @author Vizyan
 */
@Local
public interface LoginLocal {
    public JSONObject loginUser(User user);
}
