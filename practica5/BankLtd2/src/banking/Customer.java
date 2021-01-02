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
public class Customer {
    private String fristName;
    private String lastName;
    private Account[] accounts;
    protected int numberOfAccounts = 0;
    public Customer(String name, String surname){
        this.fristName = name;
        this.lastName = surname;
        accounts = new Account[5];
    }
    public String getFirstName(){
        return fristName;
    }
    public String getLastName(){
        return lastName;
    }
    public Account getAccount(int n){
        return accounts[n];
    }
    public void addAccount(Account account) {
        accounts[numberOfAccounts] = account;
        numberOfAccounts += 1;
    }
    public int getNumOfAccounts(){
        return numberOfAccounts;
    }
}
