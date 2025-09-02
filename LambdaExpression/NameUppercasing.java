
import java.util.*;
import java.util.stream.Collectors;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Alice", "Bob", "Charlie");

        List<String> upperCaseNames = employees.stream()
                .map(String::toUpperCase) // method reference
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);
    }
}
 