/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.domain;

/**
 *
 * @author HectorRobles
 */
public class Account {
    protected double balance;
    
    public Account(double initBalance){
        balance = initBalance;
    }
    public double getBalance(){
        return balance;
    }
    public boolean deposit(double addedToBalance){
        balance += addedToBalance;
        return true;
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
