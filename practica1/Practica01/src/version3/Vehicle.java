/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version3;

/**
 *
 * @author HectorRobles
 */
public class Vehicle {
    public double load;
    private double maxLoad;
    public Vehicle(double setMaxLoad){
        maxLoad = setMaxLoad;
    }
    public void setMaxLoad(double value) {
        maxLoad = value;
    }
    public double getLoad(){
        double kilos;
        kilos = kilosToNewtons(load);
        return kilos;
    }
    public double getMaxLoad(){
        double newtons;
        newtons = kilosToNewtons(maxLoad);
        return newtons;
    }
    public boolean addBox(double extraLoad){
        double totalNewLoad, newLoad, kilos;
        newLoad = kilosToNewtons(extraLoad);
        kilos = kilosToNewtons(load);
        totalNewLoad = kilos + extraLoad;
        return totalNewLoad <= maxLoad;
    }
    private double kilosToNewtons(double currentLoad){
        double newtons;
        newtons = currentLoad * 9.8;
        return newtons;
    }
    private double newtonsToKilos(double currentLoad){
        double kilos;
        kilos = currentLoad / 9.8;
        return kilos;
    }
}
