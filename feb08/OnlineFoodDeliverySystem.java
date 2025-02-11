// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double discountPercentage);
    void getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        double discount = (calculateTotalPrice() * discountPercentage) / 100;
        return calculateTotalPrice() - discount;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: Available on special occasions.");
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 20.0;  // Additional charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE;
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        double discount = (calculateTotalPrice() * discountPercentage) / 100;
        return calculateTotalPrice() - discount;
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: 10% off on weekends.");
    }
}

// Main class to demonstrate the functionality
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Paneer Butter Masala", 250.0, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 300.0, 1);

        System.out.println("Veg Item Details:");
        vegItem.getItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());

        System.out.println("\nNon-Veg Item Details:");
        nonVegItem.getItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());

        System.out.println("\nProcessing Discounts...");
        Discountable discountableVeg = (Discountable) vegItem;
        Discountable discountableNonVeg = (Discountable) nonVegItem;

        System.out.println("Veg Item Final Price after 10% discount: " + discountableVeg.applyDiscount(10));
        discountableVeg.getDiscountDetails();

        System.out.println("Non-Veg Item Final Price after 15% discount: " + discountableNonVeg.applyDiscount(15));
        discountableNonVeg.getDiscountDetails();
    }
}