/*
 * Esta clase es para probar las clases del proyecto BankLtd.
 * Crea un nuevo Bank y algunos clientes con diferentes tipos de cuenta
 * y realiza algunas transacciones.
 */
package banking;
public class TestBanking {
   public static void main(String[] args) {
      Bank bank = new Bank();
      Customer customer;
      Account account;
      //
      // Crea algunos clientes y sus cuentas.
      //
      System.out.println("Creando el cliente Jane Smith.");
      bank.addCustomer("Jane", "Simms");
      customer = bank.getCustomer(0);
      System.out.println("Creando su Savings Account con $500.00 de saldo y 3% de interés.");
      customer.setAccount(new SavingsAccount(500.00, 0.03));
      System.out.println("Creando el cliente Owen Bryant.");
      bank.addCustomer("Owen", "Bryant");
      customer = bank.getCustomer(1);
      System.out.println("Creando su Checking Account con $500.00 de saldo y sin protección.");
      customer.setAccount(new CheckingAccount(500.00));
      System.out.println("Creando el cliente Tim Soley.");
      bank.addCustomer("Tim", "Soley");
      customer = bank.getCustomer(2);
      System.out.println("Creando su Checking Account con $500.00 de saldo y $500.00 de protección.");
      customer.setAccount(new CheckingAccount(500.00, 500.00));
      System.out.println("Creando el cliente Maria Soley.");
      bank.addCustomer("Maria", "Soley");
      customer = bank.getCustomer(3);
      System.out.println("Maria comparte su Checking Account con su esposo Tim Soley.");
      customer.setAccount(bank.getCustomer(2).getAccount());
      System.out.println();
      //
      // Demuestra el comportamiento de diversas cuentas
      //
      // Probar una Savings Account standard
      System.out.println("Accesando el cliente Jane Smith.");
      customer = bank.getCustomer(0);
      account = customer.getAccount();
      // Hacer algunas transacciones
      System.out.println("Retirar $150.00: " + account.withdraw(150.00));
      System.out.println("Depositar $22.50: " + account.deposit(22.50));
      System.out.println("Retirar $47.62: " + account.withdraw(47.62));
      System.out.println("Retirar $400.00: " + account.withdraw(400.00));
      // Desplegar el saldo
      System.out.println("Customer [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de $" + account.getBalance());
      System.out.println();
      // Prubar una Checking Account sin protección de sobregiro
      System.out.println("Accesando el cliente Owen Bryant y su  Checking Account sin protección de sobregiro.");
      customer = bank.getCustomer(1);
      account = customer.getAccount();
      // Hacer algunas transacciones
      System.out.println("Retirar $150.00: " + account.withdraw(150.00));
      System.out.println("Depositar $22.50: " + account.deposit(22.50));
      System.out.println("Retirar $47.62: " + account.withdraw(47.62));
      System.out.println("Retirar $400.00: " + account.withdraw(400.00));
      // Desplegar el saldo
      System.out.println("Customer [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de $" + account.getBalance());
      System.out.println();
      // Probar una Checking Account con protección de sobregiro.
      System.out.println("Obteniendo el cliente Tim Soley y su Checking Account con protección de sobregiro.");
      customer = bank.getCustomer(2);
      account = customer.getAccount();
      // Hacer algunas transacciones
      System.out.println("Retirar $150.00: " + account.withdraw(150.00));
      System.out.println("Depositar $22.50: " + account.deposit(22.50));
      System.out.println("Retirar $47.62: " + account.withdraw(47.62));
      System.out.println("Retirar $400.00: " + account.withdraw(400.00));
      // Desplegar el saldo
      System.out.println("Customer [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de $" + account.getBalance());
      System.out.println();
      // Probar una Checking Account con protección de sobregiro
      System.out.println("Obteniendo el cliente Maria Soley con su Checking Account compartida.");
      customer = bank.getCustomer(3);
      account = customer.getAccount();
      // Hacer algunas transacciones
      System.out.println("Depositar $150.00: " + account.deposit(150.00));
      System.out.println("Retirar $750.00: " + account.withdraw(750.00));
      // Desplegar el saldo final de la cuenta
      System.out.println("Customer [" + customer.getLastName()
            + ", " + customer.getFirstName()
            + "] tiene un saldo de $" + account.getBalance());
   }
}