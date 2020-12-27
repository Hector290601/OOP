/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author HectorRobles
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
    public void withdraw(double getFromBalance){
        balance -= getFromBalance;
    }
}
