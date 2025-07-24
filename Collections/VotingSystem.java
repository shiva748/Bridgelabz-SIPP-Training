package Collections;
import java.util.*;

public class VotingSystem {
    public Map<String, Integer> votes = new HashMap<>();
    public Map<String, Integer> linkedVotes = new LinkedHashMap<>();
    public Map<String, Integer> sortedVotes = new TreeMap<>();

    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        linkedVotes.put(candidate, linkedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getResultsHashMap() { return votes; }
    public Map<String, Integer> getResultsLinkedHashMap() { return linkedVotes; }
    public Map<String, Integer> getResultsTreeMap() { return sortedVotes; }
}
