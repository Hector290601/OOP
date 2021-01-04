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
public class CheckingAccount extends Account{
    double overdraftProtection;
    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double balance, double protect){
        super(balance);
        this.overdraftProtection = protect;
    }
    @Override
    public void withdraw(double amount) throws OverdraftException{
        if(balance < amount){
            System.out.println("No hay fondos suficientes");
            System.out.println("Intentando con overdraft protection");
            if((balance + overdraftProtection) < amount){
                throw new OverdraftException("No tiene dinero suficiente ni con la protección", amount - balance);
            }else{
                System.out.println("Overdraft protection tiene fondos suficientes");
                overdraftProtection = (balance + overdraftProtection) - amount;
                balance = 0.0;
            }
        }else{
            balance -= amount;
        }
    }
}
