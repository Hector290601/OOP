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
public class SavingsAccount extends Account{
    private double interestRate;
    public SavingsAccount(double balance, double interestRate){
        interestRate = interestRate;
        super.balance = balance;
    }
}
