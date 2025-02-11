abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Holder Name: " + holderName + ", Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    boolean applyForLoan(double loanAmount);
    boolean calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public boolean applyForLoan(double loanAmount) {
        System.out.println("Savings account loan applied for: " + loanAmount);
        return true;
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;  // Eligible if balance is at least 5000
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0;  // No interest for current accounts
    }

    @Override
    public boolean applyForLoan(double loanAmount) {
        System.out.println("Current account loan applied for: " + loanAmount);
        return true;
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 10000;  // Eligible if balance + overdraft is at least 10000
    }
}

// Main class to demonstrate functionality
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV123", "John Doe", 10000, 4.5);
        BankAccount current = new CurrentAccount("CUR456", "Jane Smith", 5000, 2000);

        savings.displayDetails();
        System.out.println("Interest: " + savings.calculateInterest());

        current.displayDetails();
        System.out.println("Interest: " + current.calculateInterest());

        Loanable loanSavings = (Loanable) savings;
        loanSavings.applyForLoan(20000);
        System.out.println("Loan Eligibility: " + loanSavings.calculateLoanEligibility());

        Loanable loanCurrent = (Loanable) current;
        loanCurrent.applyForLoan(30000);
        System.out.println("Loan Eligibility: " + loanCurrent.calculateLoanEligibility());
    }
}