/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.domain;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author HectorRobles
 */
public class Customer {
    private String fristName;
    private String lastName;
    private ArrayList<Account> accounts;
    public Customer(String name, String surname){
        this.fristName = name;
        this.lastName = surname;
        accounts = new ArrayList <>();
    }
    public String getFirstName(){
        return fristName;
    }
    public String getLastName(){
        return lastName;
    }
    public Account getAccount(int n){
        return accounts.get(n);
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public int getNumOfAccounts(){
        return accounts.size();
    }
    public ListIterator getAccounts(){
        return accounts.listIterator();
    }
}
