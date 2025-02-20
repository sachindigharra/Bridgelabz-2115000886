import java.util.*;

public class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + account);
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(101, 1500.0);
        bank.addAccount(102, 3000.0);
        bank.addAccount(103, 2000.0);
        bank.requestWithdrawal(101);
        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}
