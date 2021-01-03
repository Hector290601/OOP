/*
 * Esta clase es el  programa de prueba del sistema bancario.
 * Creaun grupo de clientes del banco con algunas cuentas cada uno
 * y genera un reporte de clientes con los saldos de sus cuentas.
 */

package banking;
import banking.domain.*;
import banking.reports.*;

public class TestBanking {

  public static void main(String[] args) {
    Bank     bank = Bank.getBank();
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

    // Genera el reporte.
    report.generateReport();
  }
}
