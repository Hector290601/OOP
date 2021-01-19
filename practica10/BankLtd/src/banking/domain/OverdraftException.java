/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.domain;

/**
 *
 * @author hector
 */
public class OverdraftException extends Exception{
    private double deficit;
    public OverdraftException(String message, double deficit){
        super(message);
        this.deficit = deficit;
    }
    public double getDeficit(){
        return deficit;
    }
}
