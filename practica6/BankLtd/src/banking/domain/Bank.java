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
public class Bank {
    private static Bank bank;
    private Customer[] customers;
    private int numOfCustomers = 0;
    public Bank(){
        customers = new Customer[10];
    }
    static {
        bank = new Bank();
    }
    public static Bank getBank(){
        return bank;
    }
    public void addCustomer(String firstName, String lastName){
        Customer newCustomer = new Customer(firstName, lastName);
        customers[numOfCustomers] = newCustomer;
        numOfCustomers += 1;
    }
    public int getNumOfCustomers(){
        return numOfCustomers;
    }
    public Customer getCustomer(int index){
        return customers[index];
    }
}
