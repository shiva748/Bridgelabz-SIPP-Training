package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;

    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
 
public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000.0),
                new Claim("Auto", 2500.0),
                new Claim("Home", 8000.0),
                new Claim("Health", 3000.0),
                new Claim("Auto", 1500.0),
                new Claim("Home", 6000.0),
                new Claim("Health", 4000.0));

        Map<String, Double> averageClaims = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getType,
                        Collectors.averagingDouble(Claim::getAmount)));

        System.out.println("Average claim amount by type:");
        averageClaims.forEach((type, avg) -> System.out.println(type + ": $" + String.format("%.2f", avg)));
    }
}
