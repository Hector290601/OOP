/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author HectorRobles
 */
public class FooBarBoz {
    void FooBarBoz(){
        for( int i = 0; i <= 50; i++){
            System.out.print(i);
            if(i != 0){
                if(i % 3 == 0){
                    System.out.print(" Foo");
                }
                if(i % 5 == 0){
                    System.out.print(" Bar");
                }
                if(i % 7 == 0){
                    System.out.print(" Baz");
                }
            }
            System.out.println("");
        }
    }
}
