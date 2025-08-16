package bank;
public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current Account has no interest.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + overdraftLimit)) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}