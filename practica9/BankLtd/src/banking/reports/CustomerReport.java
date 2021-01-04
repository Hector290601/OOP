package banking.reports;
import banking.domain.*;
import java.text.NumberFormat;
import java.util.ListIterator;
public class CustomerReport {
   public void generateReport() {
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
      /**
       * * Paso1: obtenga el objeto bank **
       */
      Bank bank = Bank.getBank();
      Customer customer;
      ListIterator bankIte = bank.getCustomers();
      System.out.println("\t\t\tREPORTE DE CLIENTES");
      System.out.println("\t\t\t===================");
      while(bankIte.hasNext()){
          customer = (Customer) bankIte.next();
          System.out.println("");
          System.out.println("Client " + customer.getLastName() + " " + customer.getFirstName());
          Account account;
          ListIterator custIte = customer.getAccounts();
          while(custIte.hasNext()){
              account = (Account) custIte.next();
              String accountType = "Unknow Account Type";
              if(account instanceof SavingsAccount){
                  accountType = "Savings Account";
              }else if(account instanceof CheckingAccount){
                  accountType = "Checking Account";
              }
              System.out.println("\t" + accountType + " -> su saldo es de " + currencyFormat.format(account.getBalance()));
          }
      }
   }
}
