/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

/**
 *
 * @author hrmha
 */



public class Vehicle{
    public double load;
    private double maxLoad;
    public Vehicle(double setMaxLoad){
        maxLoad = setMaxLoad;
    }
    public void setMaxLoad(double value) {
        maxLoad = value;
    }
    public double getLoad(){
        return load;
    }
    public double getMaxLoad(){
        return maxLoad;
    }
}
