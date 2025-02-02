package jan31;

class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance); // Call superclass constructor
        this.interestRate = interestRate;
    }

    public void calculateAndAddInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest of $" + interest + " added.");
    }

    public void displaySavingsAccountInfo() {
        displayAccountInfo(); // Accessing public and protected members
        System.out.println("Interest Rate: " + interestRate * 100 + "%");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(12345, "Alice", 1000);
        account1.displayAccountInfo();

        System.out.println("\nDepositing $500:");
        account1.deposit(500);
        account1.displayAccountInfo();

        System.out.println("\nWithdrawing $200:");
        account1.withdraw(200);
        account1.displayAccountInfo();

        SavingsAccount savingsAccount1 = new SavingsAccount(67890, "Bob", 5000, 0.05); // 5% interest
        System.out.println("\nSavings Account Information:");
        savingsAccount1.displaySavingsAccountInfo();

        System.out.println("\nCalculating and Adding Interest:");
        savingsAccount1.calculateAndAddInterest();
        savingsAccount1.displaySavingsAccountInfo();

        // Demonstrating access to public and protected members from subclass
        System.out.println("\nAccessing public and protected members from SavingsAccount:");
        System.out.println("Account Number: " + savingsAccount1.accountNumber); // Public
        System.out.println("Account Holder: " + savingsAccount1.accountHolder); // Protected

        // Trying to access private member directly (will cause a compile error)
        // System.out.println("Balance: " + savingsAccount1.balance); // This will not compile
    }
}