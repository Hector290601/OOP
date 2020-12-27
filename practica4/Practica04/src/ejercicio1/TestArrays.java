/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author hrmha
 */
public class TestArrays {
    public static void main(String[] args){
        int array1[] = {2, 3, 5, 7, 11, 13, 17, 19};
        int array2[];
        int matrix[][];
        matrix = new int[5][5];
        System.out.print('<');
        for (int i = 0; i < array1.length; i++){
                System.out.print(array1[i]);
                if ((i + 1) < array1.length) {
                        System.out.print(", ");
                }
        }
        System.out.println('>');
        array2 = array1;
        for(int i = 0; i < array2.length; i++){
            if(i % 2 == 0){
                array2[i] = i;
            }
        }
        System.out.print('<');
        for (int i = 0; i < array1.length; i++){
                System.out.print(array1[i]);
                if ((i + 1) < array1.length) {
                        System.out.print(", ");
                }
        }
        System.out.println('>');
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = new int[i];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = i * j;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            System.out.print("matrix[" + i + "] es <");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                if(j +1 < matrix[i].length){
                    System.out.print(", ");
                }
            }
            System.out.println(">");
        }
    }
}