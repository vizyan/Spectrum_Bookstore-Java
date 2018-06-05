/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.Chart;

import javax.ejb.Stateless;

/**
 *
 * @author Vizyan
 */
@Stateless
public class ChartStateless implements ChartStatelessLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private double total;    
    private double hasil;
    
    @Override     
    public double add(double value) {         
        total += value;         
        return total;     
    }     
    
    @Override
    public double mul(double value, double value2) {
        hasil = value * value2;  
        return hasil;
    }
    
    @Override     
    public double getTotal() {         
        return total;     
    }

    @Override
    public double clear(double value) {
        return this.total = value;
    }

    @Override
    public double setTotal(double value) {
        return this.total = value;
    }
}
