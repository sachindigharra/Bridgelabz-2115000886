import java.util.*;

public class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber, holderName, coverageType;
    Date expiryDate;
    double premium;

    public InsurancePolicy(String number, String name, Date expiry, String coverage, double premium) {
        this.policyNumber = number;
        this.holderName = name;
        this.expiryDate = expiry;
        this.coverageType = coverage;
        this.premium = premium;
    }

    @Override
    public int compareTo(InsurancePolicy o) {
        return this.expiryDate.compareTo(o.expiryDate);
    }
} 
class PolicyManagement {
    public static void main(String[] args) {
        Set<InsurancePolicy> policies = new TreeSet<>();
        policies.add(new InsurancePolicy("123", "Alice", new Date(2025, 5, 20), "Health", 5000));
        policies.add(new InsurancePolicy("456", "Bob", new Date(2024, 7, 15), "Auto", 7000));
        policies.forEach(p -> System.out.println(p.policyNumber + " " + p.holderName));
    }
}
