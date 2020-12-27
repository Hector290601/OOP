/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package principal;

/**
 *
 * @author hrmha
 */
public class TestMyPoint {
    public static void main(String[] args){
        MyPoint start;
        MyPoint end;
        MyPoint stray;
        start = new MyPoint();
        end = new MyPoint();
        start.x = 10;
        start.y = 10;
        end.x = 20;
        end.y = 30;
        System.out.println("####################################################");
        System.out.println("El valor se Start.x: " + start.x);
        System.out.println("El valor se Start.y: " + start.y);
        System.out.println("El valor se End.x: " + end.x);
        System.out.println("El valor se End.y: " + end.y);
        stray = end;
        System.out.println("####################################################");
        System.out.println("El valor se End.x: " + end.x);
        System.out.println("El valor se End.y: " + end.y);
        System.out.println("El valor se Stray.x: " + stray.x);
        System.out.println("El valor se Stray.y: " + stray.y);
        start.x = 610;
        start.y = 910;
        end.x = 200;
        end.y = 303;
        stray.x = 100;
        stray.y = 1000;
        System.out.println("####################################################");
        System.out.println("El valor se Start.x: " + start.x);
        System.out.println("El valor se Start.y: " + start.y);
        System.out.println("El valor se End.x: " + end.x);
        System.out.println("El valor se End.y: " + end.y);
        System.out.println("El valor se Stray.x: " + stray.x);
        System.out.println("El valor se Stray.y: " + stray.y);
    }
}
