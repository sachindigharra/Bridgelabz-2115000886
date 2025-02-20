import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Double> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedCart = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, price);
        sortedCart.put(price, product);
    }

    public void displayCart() {
        System.out.println("Cart (Added Order): " + cart);
        System.out.println("Cart (Sorted by Price): " + sortedCart);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.0);
        cart.addProduct("Phone", 500.0);
        cart.addProduct("Tablet", 750.0);
        cart.displayCart();
    }
} 
