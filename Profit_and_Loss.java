public class Profit_and_Loss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profit_Percentage = (profit/costPrice) * 100;
        System.out.println("The Cost Price is INR "+129 +" and Selling Price is INR "+sellingPrice);
        System.out.println("The Profit is INR "+profit+" and the Profit Percentage is "+profit_Percentage);
    }
}
