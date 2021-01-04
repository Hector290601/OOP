package banking;
/* Este clase es el programa para probar las otras clases del proyecto BankLtd,
 * Crea algunos clientes y sus cuentas y genera un reporte
 * con los saldos de las cuentas.
 */
import banking.domain.*;
import banking.reports.CustomerReport;
public class TestBanking {
   public static void main(String[] args) {
      Bank bank = Bank.getBank();
      Customer customer;
      CustomerReport report = new CustomerReport();
      // Crea algunos clientes y sus cuentas.
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
      report.generateReport();
   }
}