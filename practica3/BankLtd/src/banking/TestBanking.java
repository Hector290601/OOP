/* Esta clase es el programa para probar las clases neesarias de la aplicación bancaria.
Crea un nuevo objeto Customer con un saldo inicial y realiza una serie de transacciones 
con el objeto account del Customer. */
package banking;
import java.text.NumberFormat;
public class TestBanking {
   public static void main(String[] args) {
      Customer customer;
      Account account;
      boolean result = true;
      double amount = 0.0;
      NumberFormat formato = NumberFormat.getCurrencyInstance();
      // Crea una cuenta con $500.00 de saldo.
      System.out.println("Creando el cliente Jane Smith.");
      customer = new Customer("Jane", "Smith");
      System.out.println("Creando su cuenta con saldo de $500.00.");
      customer.setAccount(new Account(500.00));
      account = customer.getAccount();
      amount = 150.00;
      System.out.println("Intentando retiro de " + formato.format(amount));
      result = account.withdraw(amount);
      if (result) {
         System.out.println("Retiro de " + formato.format(amount) + " OK");
      } else {
         System.out.println("Retiro de " + formato.format(amount) + " inválido");
      }
      amount = 22.50;
      System.out.println("Depósito de " + formato.format(amount));
      account.deposit(amount);
      amount = 500.00;
      System.out.println("Intentando retiro de " + formato.format(amount));
      result = account.withdraw(amount);
      if (result) {
         System.out.println("Retiro de " + formato.format(amount) + " OK");
      } else {
         System.out.println("Retiro de " + formato.format(amount) + " inválido, fondos insuficientes");
      }
      // Despliega el saldo final de la cuenta.
      System.out.println("El cliente  [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de  " + formato.format(account.getBalance() ));
   }
}
