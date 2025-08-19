package bank;

import javax.swing.*;
import java.awt.event.*;

public class JFrameForBank {

    public static void main(String[] args) {
        // Create a test account (you can later let the user choose account type)
        Account account = new SavingsAccount("SA123", 5000, 5);

        // Create frame
        JFrame frame = new JFrame("Bank Management System");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons
        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(120, 50, 150, 40);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(120, 110, 150, 40);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(120, 170, 150, 40);

        JButton interestBtn = new JButton("Calculate Interest");
        interestBtn.setBounds(120, 230, 150, 40);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(120, 290, 150, 40);

        // Deposit Action
        depositBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        account.deposit(amount);
                        JOptionPane.showMessageDialog(frame, "Deposit successful!\nNew Balance: " + account.getBalance());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid amount!");
                    }
                }
            }
        });

        // Withdraw Action
        withdrawBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                if (amountStr != null) {
                    try {
                        double amount = Double.parseDouble(amountStr);
                        account.withdraw(amount);
                        JOptionPane.showMessageDialog(frame, "Transaction complete!\nNew Balance: " + account.getBalance());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid amount!");
                    }
                }
            }
        });

        // Balance Action
        balanceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Current Balance: " + account.getBalance());
            }
        });

        // Interest Action
        interestBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.calculateInterest();
                // For SavingsAccount, prints to console. Show dialog instead:
                if (account instanceof SavingsAccount) {
                    double interest = account.getBalance() * 5 / 100; // using fixed rate
                    JOptionPane.showMessageDialog(frame, "Calculated Interest: " + interest);
                } else {
                    JOptionPane.showMessageDialog(frame, "Current Account has no interest.");
                }
            }
        });

        // Exit Action
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Add buttons
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(balanceBtn);
        frame.add(interestBtn);
        frame.add(exitBtn);

        // Show frame
        frame.setVisible(true);
    }
}
