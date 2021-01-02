/*
 * Esta clase prueba las clases del proyecto BankLtd.
 * Crea clientes con algunas cuentas cada uno,  y genera un reporte de las cuentas con sus saldos.
 */
package banking;
import java.text.NumberFormat;
public class TestBanking {
   public static void main(String[] args) {
      NumberFormat cf = NumberFormat.getCurrencyInstance();			// usado para formatear el saldo de la cuenta
      Bank bank = new Bank();
      Customer customer;
      // Crea varios clientes con sus cuentas.
      bank.addCustomer("Jane", "Simms");
      customer = bank.getCustomer(0);
      customer.addAccount(new SavingsAccount(500.00, 0.05));
      customer.addAccount(new CheckingAccount(200.00, 400.00));
      bank.addCustomer("Owen", "Bryant");
      customer = bank.getCustomer(1);
      customer.addAccount(new CheckingAccount(200.00));
      bank.addCustomer("Tim", "Soley");
      customer = bank.getCustomer(2);
      customer.addAccount(new SavingsAccount(1500.00, 0.05));
      customer.addAccount(new CheckingAccount(200.00));
      bank.addCustomer("Maria", "Soley");
      customer = bank.getCustomer(3);
      customer.addAccount(bank.getCustomer(2).getAccount(1));
      customer.addAccount(new SavingsAccount(150.00, 0.05));
      // Generate a report
      System.out.println("\t\t\tReporte de Clientes");
      System.out.println("\t\t\t===================");
      for (int custIdx = 0; custIdx < bank.getNumOfCustomers(); custIdx++) {
         customer = bank.getCustomer(custIdx);
         System.out.println();
         System.out.println("Cliente: " + customer.getLastName() + ", " + customer.getFirstName());
         for (int acctIdx = 0; acctIdx < customer.getNumOfAccounts(); acctIdx++) {
            Account account = customer.getAccount(acctIdx);
            String accountType = "Desconocida";
            // Paso 1. Determine el tipo de cuenta
            /**
             *** Use el operador instanceof para determinar qué tipo de cuenta
             *** tenemos y ponga en el valor de la variable accountType un
             *** texto adecuado  como "Savings Account" o "Checking Account".
             */
            if (account instanceof SavingsAccount) {
               accountType = "Savings Account";
            }
            if (account instanceof CheckingAccount) {
               accountType = "Checking Account";
            }
            //  Paso 2. Despliegue el saldo actual de la cuenta.
            /**
             ***  Despliegue el tipo de cuenta y su saldo. ***
             ***  Formatee el saldo usando el método format del formato cf definido
             ***  al principio. 
             */
            System.out.println("Su " + accountType + " tiene un saldo de " 
                  + cf.format(account.getBalance() ) );
         }
      }
   }
}