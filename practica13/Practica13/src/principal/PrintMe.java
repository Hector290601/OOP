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
public class PrintMe implements Runnable {
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " has priority " + Thread.currentThread().getPriority());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
            }
        }
    }
}
