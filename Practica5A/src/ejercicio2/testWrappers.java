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
public class testWrappers {
    public static void main(String[] args) {
        int num1 = 12428;
        float num2 = 3.1416f;
        double num3 = 2.728E05;
        char c1 = 'c';
        Integer objNum1;
        Float objNum2;
        Double objNum3;
        Character objC1;
        objNum1 = new Integer(num1);
        objNum2 = new Float(num2);
        objNum3 = new Double(num3);
        objC1 = new Character(c1);
        System.out.println("objNum1 : " + objNum1);
        System.out.println("objNum2 : " + objNum2);
        System.out.println("objNum3 : " + objNum3);
        System.out.println("objC1 : " + objC1);
        objNum1 = num1;
        objNum2 = num2;
        objNum3 = num3;
        objC1 = c1;
        System.out.println("objNum1 : " + objNum1);
        System.out.println("objNum2 : " + objNum2);
        System.out.println("objNum3 : " + objNum3);
        System.out.println("objC1 : " + objC1);
        System.out.println("num1_2 : " + Integer.toBinaryString(num1));
        System.out.println("num2_16 : " + Float.toHexString(num2));
        System.out.println("num3_str : " + Double.toString(num3));
        System.out.println("c1 es mayúscula? : " + Character.isUpperCase(c1));
    }
}
