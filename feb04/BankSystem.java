//package feb04;
import java.util.*;

class Bank {
    String name;
    String Accno;
    String IFSC;
    String Mobileno;
    int balance;
    int initialAmt;
    ArrayList<Customer> customers;

    public Bank(String name, String Accno, String IFSC, String Mobileno, int balance, int initialAmt) {
        if(initialChecker( initialAmt, balance)){
            System.out.println("Your intial desposit is less then terms and conditions please cerdit amount more than: "+initialAmt);

            System.out.println(
            );

            System.out.println("we cant open your account");
        }else{
            this.name = name;
            this.Accno = Accno;
            this.IFSC = IFSC;
            this.Mobileno = Mobileno;
            this.balance = balance;
            this.initialAmt = initialAmt;
            this.customers = new ArrayList<>();  
        }
          
        
       
    }

    public void addCustomer(Customer c1) {
        this.customers.add(c1);
    }
    public boolean initialChecker(int initialAmt,int balance ){
        if(initialAmt>balance){
            //System.out.println("Your intial desposit is then terms and conditions please cerdit amount more than: "+initialAmt);
            return true;
        }else{
            return false;
        }
    }
}

class SaveAccount extends Bank {
    int limit;
    int currBalance;

    public SaveAccount(String name, int limit, String Accno, String IFSC, String Mobileno, int balance, int initialAmt) {
        
        super(name, Accno, IFSC, Mobileno, balance, initialAmt);
        this.limit = limit;
        this.currBalance = balance;  
    }

    public void withdrawal(int amount) {
        if (this.currBalance < amount) {
            System.out.println("Insufficient balance");
        } else {
            this.currBalance -= amount;
            System.out.println(amount + " debited from your acc: " + this.Accno);
            System.out.println("Current Balance: " + this.currBalance);
        }
    }

    public void balanceCheck() {
        System.out.println("Balance: " + this.currBalance);
        
    }

    // show minimum amount deposit
    public void initialDeposit() {
        System.out.println("Your initial deposit should be: " + this.initialAmt);
    }
   
}

class Customer {
    String name;
    SaveAccount bank;

    public Customer(String name) {
        this.name = name;
    }

    public void addBank(SaveAccount b) {
        this.bank = b;
    }

    public void showBankDetails() {
        if (bank != null) {
            System.out.println("Bank Name: " + bank.name);
            System.out.println("Account No: " + bank.Accno);
            System.out.println("IFSC Code: " + bank.IFSC);
            System.out.println("Mobile No: " + bank.Mobileno);
            System.out.println("Balance: " + bank.currBalance);
        } else {
            System.out.println("No bank account linked!");
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
       
        Customer c1 = new Customer("Sachin");


       
        SaveAccount SBI = new SaveAccount("SBI", 100000, "31941", "SBI000991", "8979945139", 1000, 5000);

        
        c1.addBank(SBI);

       
        //c1.showBankDetails();

        
        //c1.bank.withdrawal(11000);

       
        c1.bank.balanceCheck();
        //System.out.println(c1.bank.initialChecker());
    }
}
