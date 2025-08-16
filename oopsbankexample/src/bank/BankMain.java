package bank;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Account Type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();

        Account account = null;

        if (choice == 1) {
            System.out.print("Enter Account Number: ");
            String accNum = sc.next();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            System.out.print("Enter Interest Rate (%): ");
            double rate = sc.nextDouble();

            account = new SavingsAccount(accNum, balance, rate);

        } else if (choice == 2) {
            System.out.print("Enter Account Number: ");
            String accNum = sc.next();
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            System.out.print("Enter Overdraft Limit: ");
            double limit = sc.nextDouble();

            account = new CurrentAccount(accNum, balance, limit);
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    System.out.println("Account Balance: " + account.getBalance());
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the bank system!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}