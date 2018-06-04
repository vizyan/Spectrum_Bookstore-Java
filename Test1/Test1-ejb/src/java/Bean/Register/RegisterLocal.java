/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Register;

import javax.ejb.Local;
import model.User;
import org.json.JSONObject;

/**
 *
 * @author Vizyan
 */
@Local
public interface RegisterLocal {
    public JSONObject registerUser(User user);
}
