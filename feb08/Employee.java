
import java.util.ArrayList;
import java.util.List;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;  // 15% discount for electronics
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;  // 18% tax for electronics
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;  // 20% discount for clothing
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12;  // 12% tax for clothing
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;  // 5% discount for groceries
    }
}

// Main class to demonstrate functionality
public class Employee {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Smartphone", 50000));
        products.add(new Clothing(2, "Jacket", 3000));
        products.add(new Groceries(3, "Rice (5kg)", 500));

        for (Product product : products) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------");
        }
    }
}



