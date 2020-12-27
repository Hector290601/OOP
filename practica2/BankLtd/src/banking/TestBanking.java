/*
Esta clase es el programa para probar las clases necesarias de la aplicación BankLtd.
Crea un nuevo objeto Customer con un saldo inicial y realiza una serie de transacciones 
con el objeto account del Customer.
 */
package banking;
public class TestBanking {

  public static void main(String[] args) {
    Customer customer;
    Account  account;

   // Crea una cuenta con $500.00 de saldo.

    System.out.println("Creando el cliente Jane Smith.");
    customer = new Customer("Jane", "Smith");
    System.out.println("Creando su cuenta con saldo de $500.00");
    customer.setAccount(new Account(500.00));
    account = customer.getAccount();

    System.out.println("Retiro de $150.00");
    account.withdraw(150.00);

    System.out.println("Depósito de $22.50");
    account.deposit(22.50);

    System.out.println("Retiro de $47.62");
    account.withdraw(47.62);

    // Despliega el saldo final de la cuenta.
      System.out.println("El cliente  [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de  $" + account.getBalance());
   }
}
