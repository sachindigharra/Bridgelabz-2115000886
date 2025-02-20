import java.util.*;
public class VotingSystem {
    private HashMap<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
        sortedVotes.put(candidate, votes.get(candidate));
    }

    public void displayResults() {
        System.out.println("Votes (Order of Voting): " + voteOrder);
        System.out.println("Votes (Sorted): " + sortedVotes);
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.displayResults();
    }
} 