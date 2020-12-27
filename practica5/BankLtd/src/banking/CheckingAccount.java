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
public class CheckingAccount extends Account{
    double overdraftProtection;
    double balance1 = super.balance;
    public CheckingAccount(double balance2){
        balance = balance2;
    }
    public CheckingAccount(double balance, double overDraftProtection){
        super.balance = balance;
        overdraftProtection = overDraftProtection;
    }
    @Override
    public boolean withdraw(double getFromBalance){
        double delta;
        delta = balance1 - getFromBalance;
        if(delta >= 0){
            balance -= getFromBalance;
            return true;
        }else if((delta + overdraftProtection) >= 0){
            balance -= getFromBalance;
            return true;
        }else{
            return false;
        }
    }
}
