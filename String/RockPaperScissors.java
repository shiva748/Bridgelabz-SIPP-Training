import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int games = scanner.nextInt();
        
        int userWins = 0;
        int computerWins = 0;
        String[][] gameResults = new String[games][3];
        
        for (int i = 0; i < games; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.next().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = determineWinner(userChoice, computerChoice);
            
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            
            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }
        
        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(gameResults, stats);
        scanner.close();
    }
    
    static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        return choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors";
    }
    
    static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Tie";
        }
        
        if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "User";
        }
        
        return "Computer";
    }
    
    static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][2];
        double userPercentage = (userWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;
        
        stats[0][0] = "User";
        stats[0][1] = String.format("%.2f%%", userPercentage);
        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f%%", computerPercentage);
        
        return stats;
    }
    
    static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game | User     | Computer | Winner");
        System.out.println("-----|----------|----------|--------");
        
        for (int i = 0; i < gameResults.length; i++) {
            System.out.printf("%-5d| %-9s| %-9s| %s%n",
                i + 1, gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }
        
        System.out.println("\nWinning Statistics:");
        System.out.println("Player   | Win Percentage");
        System.out.println("---------|---------------");
        
        for (String[] row : stats) {
            System.out.printf("%-9s| %s%n", row[0], row[1]);
        }
    }
}
