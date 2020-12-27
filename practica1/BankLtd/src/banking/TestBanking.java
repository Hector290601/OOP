/*
 * Esta clase crea una cuenta (tipo account) y prueba sus metodos
 */
package banking;

public class TestBanking {

  public static void main(String[] args) {
	
    Account  account;
		
		System.out.println("Creating an account with initial balance of 500.00");
		
		account = new Account(500.00);

    account.withdraw(150.00);
    account.deposit(22.50);
    account.withdraw(47.62);

    System.out.println("Account has a balance of " + account.getBalance());
		
  }
}
