package bank;

public abstract class Account{
	private String accountNumber;
	private double balance;
	
	public Account(String accountNumber,double balance)
	{
		this.accountNumber=accountNumber;
		this.balance=balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
	    if (amount > 0) {
	        balance += amount;
	        System.out.println("Deposited: " + amount);
	        System.out.println("New Balance: " + balance);
	    } else {
	        System.out.println("Deposit amount must be positive!");
	    }
	}

	public void withdraw(double amount)
	{
		if(amount>0)
		{		balance=balance-amount;
		System.out.println("Withdrawn: "+amount);
	    }
		else
			System.out.println("Insufficient balance!!!");
	}
	
	public abstract void calculateInterest();
}