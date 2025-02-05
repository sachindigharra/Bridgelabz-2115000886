package feb04;

import java.util.*;

class Bank{
    String name;
    ArrayList<Customer> customer;
    public Bank(String name){
        this.name = name;
        customer = new ArrayList<>();
    }
    public void add_Customer(Customer customer){
        this.customer.add(customer);
        System.out.println(customer.name+"opened Account At "+this.name);
    }

}
class Customer {
    String name;
    Bank bank;
    public void setBankName(Bank bank){
        this.bank = bank;
        
    }
    public Customer(String name){
        this.name = name;
    }
    public void viewBalance() {
        if (bank != null) {
            System.out.println(name + "'s balance at " + bank.name + " (Simulated): $100"); // Simplified balance
        } else {
            System.out.println(name + " doesn't have an account yet.");
        }

    }
    
}

public class AssociationExample {
    public static void main(String[] args) {
        Customer c1 = new Customer("Sachin");
        Bank b1 = new Bank("SBI");
        Bank b2 = new Bank("ICICI");
        Customer c2 = new Customer("rajeev");
        Customer c3 = new Customer("rajeev");
        c1.setBankName(b1);
        c2.setBankName(b2);
        c3.setBankName(b1);
        b1.add_Customer(c3);
        b1.add_Customer(c1);
        b2.add_Customer(c2);
        c1.viewBalance();
        c2.viewBalance();
    }
}
