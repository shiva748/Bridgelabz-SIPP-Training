package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

public class TransformingNames {
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
                "john doe",
                "alice smith",
                "bob johnson",
                "carol williams",
                "dave brown");

        List<String> transformedNames = customerNames.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Customer names in uppercase (alphabetical order):");
        transformedNames.forEach(System.out::println);
    }
} 
