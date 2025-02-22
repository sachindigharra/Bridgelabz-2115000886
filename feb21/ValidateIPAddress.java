
public class ValidateIPAddress {
    public static boolean isValidIP(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|[0-1]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[0-1]?\\d\\d?)$";
        return ip.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1")); // true
        System.out.println(isValidIP("999.999.999.999")); // false
    }
}

