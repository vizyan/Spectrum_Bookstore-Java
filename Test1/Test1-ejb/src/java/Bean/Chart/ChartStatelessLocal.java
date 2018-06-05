/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Chart;

import javax.ejb.Local;

/**
 *
 * @author Vizyan
 */
@Local
public interface ChartStatelessLocal {
    public double add(double value);
    public double mul(double value, double value2);
    public double clear(double value);
    public double getTotal();
    public double setTotal(double value);
}
