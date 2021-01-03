package banking;
/*
 * Este programa prueba las clases del sistema bancario.
 * Crea clientes con sus respectivas cuentas 
 * y genera un reporte con sus saldos.
 */
import banking.domain.*;
public class TestBanking {
   public static void main(String[] args) {
      Bank bank = Bank.getBank();
      Customer customer;
      Account account;
      // Crea dos clientes y sus cuentas.
      bank.addCustomer("Jane", "Simms");
      customer = bank.getCustomer(0);
      customer.addAccount(new SavingsAccount(500.00, 0.05));
      customer.addAccount(new CheckingAccount(500.00, 200.00));
      bank.addCustomer("Owen", "Bryant");
      customer = bank.getCustomer(1);
      customer.addAccount(new CheckingAccount(1000.00));
      // Prueba la checking account de Jane Simms con protección de sobregiro
      customer = bank.getCustomer(0);
      account = customer.getAccount(1);
      System.out.println("Cliente [" + customer.getLastName()
            + ", " + customer.getFirstName() + "]"
            + " tiene un saldo en cheques de $"
            + account.getBalance()
            + " con $200.00 de protección.");
      try {
         System.out.println("Checking Acct [Jane Simms] : retiro de $150.00");
         account.withdraw(150.00);
         System.out.println("Checking Acct [Jane Simms] : depósito de $22.50");
         account.deposit(22.50);
         System.out.println("Checking Acct [Jane Simms] : retiro de $147.62");
         account.withdraw(147.62);
         System.out.println("Checking Acct [Jane Simms] : retiro de $470.00");
         account.withdraw(470.00);
      } catch (OverdraftException e1) {
         System.out.println(e1.getMessage() + " déficit: $" + e1.getDeficit());
      } finally {
         System.out.println("Cliente [" + customer.getLastName()
               + ", " + customer.getFirstName() + "]"
               + " tiene un saldo en cheques de $"
               + account.getBalance() + " sin protección de sobregiro");
      }
      System.out.println();
      // Prueba la checking account de Owen Bryant sin protección de sobregiro
      customer = bank.getCustomer(1);
      account = customer.getAccount(0);
      System.out.println("Cliente [" + customer.getLastName()
            + ", " + customer.getFirstName() + "]"
            + " tiene un saldo en cheques de $"
            + account.getBalance());
      try {
         System.out.println("Checking Acct [Owen Bryant] : retiro de $100.00");
         account.withdraw(100.00);
         System.out.println("Checking Acct [Owen Bryant] : depósito de $25.00");
         account.deposit(25.00);
         System.out.println("Checking Acct [Owen Bryant] : retiro de $175.00");
         account.withdraw(175.00);
      } catch (OverdraftException e1) {
         System.out.println(e1.getMessage() + " déficit: " + e1.getDeficit());
      } finally {
         System.out.println("Cliente [" + customer.getLastName()
               + ", " + customer.getFirstName() + "]"
               + " tiene un saldo en cheques de $"
               + account.getBalance());
      }
   }
}