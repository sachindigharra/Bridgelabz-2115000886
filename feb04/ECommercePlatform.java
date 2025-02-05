package feb04;

import java.util.*;

class ECommercePlatform {
    ArrayList<Customer> customers;

    public ECommercePlatform() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }
}

class Customer {
    String name;
    ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public Order placeOrder(ArrayList<Product> products) {
        Order order = new Order(this, products);
        this.orders.add(order);
        return order;
    }
}

class Order {
    Customer customer;
    ArrayList<Product> products;

    public Order(Customer customer, ArrayList<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void displayOrderDetails() {
        System.out.println("Order placed by " + customer.name + ":");
        for (Product product : products) {
            System.out.println("- " + product.name + " (" + product.price + ")");
        }
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}