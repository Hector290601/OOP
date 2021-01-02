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
public class Spider extends Animal {
    public Spider(){
        super(8);
    }
    @Override
    public void eat(){
        System.out.println("Las arañas comen insectos que caen en sus telarañas");
    }
    @Override
    public void walk(){
        System.out.println("Nunca he observado el caminar de las arañas XDDDDDDDDDDDDDDDDDDDD");
    }
}
