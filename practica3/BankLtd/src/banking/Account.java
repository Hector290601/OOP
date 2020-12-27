/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author hrmha
 */
public class Account {
    private double balance;
    
    public Account(double initBalance){
        balance = initBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double addedToBalance){
        balance += addedToBalance;
    }
    public boolean withdraw(double getFromBalance){
        if(getFromBalance <= balance){
            balance -= getFromBalance;
            return true;
        }else{
            return false;
        }
    }
    public boolean deposit(){
        return true;
    }
}
