package assignment2;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: $" + amount);
     } else {
         System.out.println("Invalid deposit amount");
     }
 }


 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: $" + amount);
     } else {
         System.out.println("Invalid withdrawal amount or insufficient funds");
     }
 }


 public double getBalance() {
     return balance;
 }
}


class SavingsAccount extends BankAccount {
 private static final double WITHDRAWAL_LIMIT = 2000.0;
 private static final double WITHDRAWAL_FEE = 2.0;

 public SavingsAccount(double initialBalance) {
     super(initialBalance);
 }

 @Override
 public void withdraw(double amount) {
     if (amount > WITHDRAWAL_LIMIT) {
         System.out.println("Withdrawal amount exceeds the limit of $" + WITHDRAWAL_LIMIT);
     } else if (amount + WITHDRAWAL_FEE > getBalance()) {
         System.out.println("Insufficient funds for withdrawal and fee");
     } else {
         super.withdraw(amount + WITHDRAWAL_FEE);
         System.out.println("Fee of $" + WITHDRAWAL_FEE + " applied");
     }
 }
}

class CheckingAccount extends BankAccount {
 private static final double WITHDRAWAL_LIMIT = 500.0;
 private static final double WITHDRAWAL_FEE = 6.0;

 
 public CheckingAccount(double initialBalance) {
     super(initialBalance);
 }

 
 @Override
 public void withdraw(double amount) {
     if (amount > WITHDRAWAL_LIMIT) {
         System.out.println("Withdrawal amount exceeds the limit of $" + WITHDRAWAL_LIMIT);
     } else if (amount + WITHDRAWAL_FEE > getBalance()) {
         System.out.println("Insufficient funds for withdrawal and fee");
     } else {
         super.withdraw(amount + WITHDRAWAL_FEE);
         System.out.println("Fee of $" + WITHDRAWAL_FEE + " applied");
     }
 }
}

public class BankAccountTest {
 public static void main(String[] args) {
     
     SavingsAccount savings = new SavingsAccount(1200.0);
     System.out.println("Savings Account Balance: $" + savings.getBalance());
     savings.deposit(500.0);
     System.out.println("Savings Account Balance after deposit: $" + savings.getBalance());
     savings.withdraw(200.0);
     System.out.println("Savings Account Balance after withdrawal: $" + savings.getBalance());
     CheckingAccount checking = new CheckingAccount(800.0);
     System.out.println("\nChecking Account Balance: $" + checking.getBalance());
     checking.deposit(500.0);
     System.out.println("Checking Account Balance after deposit: $" + checking.getBalance());
     checking.withdraw(200.0);
     System.out.println("Checking Account Balance after withdrawal: $" + checking.getBalance());
 }
}
