/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author hector
 */
public class testEmployee {
    public static void main(String[] args) {
        employee emp1 = new employee("Héctor Robles", "Sistemas", 10000);
        //employee emp2 = new employee("Héctor Robles", "Sistemas", 10000);
        employee emp2 = new employee("Daniela Robles", "Medicina", 10000);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("¿emp1 = emp2? " +  emp1.equals(emp2) );
        employee emp3 = new employee("Karla Mateos", "Fisica", 10000);
        System.out.println("¿emp1 = emp3? " +  emp1.equals(emp3) );
        System.out.println("emp1 hashcode es: " +  emp1.hashCode() );
        System.out.println("emp2 hashcode es: " +  emp2.hashCode() );
        System.out.println("emp3 hashcode es: " +  emp3.hashCode() );
    }
}
