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

public class Fish extends Animal implements Pet {
    private String name;
    public Fish(){
        super(0);
    }
    public String getName(){
        return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void play(){
        System.out.println("Los peces no juegan, sólo son hermosos uwu");
    }
    @Override
    public void eat(){
        System.out.println("Pescado no come pescado .-.");
        System.out.println("¿O sí?");
    }
    @Override
    public void walk(){
        System.out.println("Los peces nadan c:");
    }
}