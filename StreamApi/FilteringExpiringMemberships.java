package StreamApi;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Member {
    String name;
    LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return name + " - Expires: " + expiryDate;
    }
}

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        List<Member> members = Arrays.asList(
                new Member("John", today.plusDays(15)),
                new Member("Alice", today.plusDays(45)),
                new Member("Bob", today.plusDays(25)),
                new Member("Carol", today.plusDays(60)),
                new Member("Dave", today.plusDays(10)));

        List<Member> expiringMembers = members.stream()
                .filter(member -> member.getExpiryDate().isBefore(today.plusDays(31)))
                .collect(Collectors.toList());

        System.out.println("Members with membership expiring within 30 days:");
        expiringMembers.forEach(System.out::println);
    }
}
