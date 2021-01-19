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
public class Bank {
    private static Bank bank;
    private ArrayList<Customer> customers;
    public Bank(){
        customers = new ArrayList<>();
    }
    static {
        bank = new Bank();
    }
    public static Bank getBank(){
        return bank;
    }
    public void addCustomer(String firstName, String lastName){
        customers.add(new Customer(firstName, lastName));
    }
    public int getNumOfCustomers(){
        return customers.size();
    }
    public Customer getCustomer(int index){
        return customers.get(index);
    }
    public ListIterator getCustomers(){
        return customers.listIterator();
    }
}
