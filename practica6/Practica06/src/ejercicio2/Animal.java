/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author hector
 */
public abstract class Animal {
    protected int legs = 0;
    public Animal(int piernas){
        this.legs = piernas;
    }
    public abstract void eat();
    public void walk(){
        System.out.println("Este animal camina en " + legs + " patas");
    }
}
