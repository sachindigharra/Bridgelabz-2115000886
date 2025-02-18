package Feb17;

import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + name + ": $" + price;
    }
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }
}

class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }
}

class Marketplace {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new Book("Java Programming", 50));
        bookCatalog.addProduct(new Book("Design Patterns", 60));

        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new Clothing("T-Shirt", 20));
        clothingCatalog.addProduct(new Clothing("Jeans", 40));

        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new Gadget("Smartphone", 500));
        gadgetCatalog.addProduct(new Gadget("Smartwatch", 200));

        System.out.println("Before Discount:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book);
            Marketplace.applyDiscount(book, 10);
        }

        System.out.println("\nAfter Discount:");
        for (Book book : bookCatalog.getProducts()) {
            System.out.println(book);
        }
    }
}
