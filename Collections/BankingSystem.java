package Collections;
import java.util.*;

public class BankingSystem {
    public Map<String, Integer> accounts = new HashMap<>();
    public TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();
    public Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String acc, int balance) {
        accounts.put(acc, balance);
        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(acc);
    }

    public void requestWithdrawal(String acc) {
        withdrawalQueue.add(acc);
    }

    public String processWithdrawal() {
        return withdrawalQueue.poll();
    }

    public Map<String, Integer> getAccounts() { return accounts; }
    public Map<Integer, List<String>> getSortedByBalance() { return sortedByBalance; }
    public Queue<String> getWithdrawalQueue() { return withdrawalQueue; }
}
