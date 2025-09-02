package StreamApi;

import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(150.25, 152.30, 151.75, 153.10, 152.80);

        System.out.println("Live Stock Prices:");
        stockPrices.forEach(price -> System.out.println("Stock price: $" + price));
    }
}
