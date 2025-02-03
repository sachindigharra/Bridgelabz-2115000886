package feb3;

public class Product {
    static double discount = 0.0;

    final int productID;
    String productName;
    double price;
    int quantity;

    private static int productCounter = 1; // To generate unique IDs

    public Product(String productName, double price, int quantity) {
        this.productID = productCounter++; // Assign unique ID
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.0, 2);
        Product product2 = new Product("Mouse", 25.0, 5);

        if (product1 instanceof Product) {
            product1.displayProductDetails();
        }

        if (product2 instanceof Product) {
            product2.displayProductDetails();
        }

        Product.updateDiscount(10.0); // Update discount

        if (product1 instanceof Product) {
            product1.displayProductDetails(); // Display details with updated discount
        }
    }
}