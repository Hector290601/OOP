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
public class Customer {
    private String fristName;
    private String lastName;
    private Account account;
    public Customer(String name, String surname){
        fristName = name;
        lastName = surname;
    }
    public String getFirstName(){
        return fristName;
    }
    public String getLastName(){
        return lastName;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
