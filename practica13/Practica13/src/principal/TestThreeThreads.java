/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author hector
 */
public class TestThreeThreads {
    public static void main(String[] args){
        Runnable prog = new PrintMe();
        Thread t1 = new Thread(prog);
        Thread t2 = new Thread(prog);
        Thread t3 = new Thread(prog);
        t1.setName("Hector");
        t2.setName("Karla");
        t3.setName("Dani");
        t1.setPriority(10);
        t2.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
    }
}
