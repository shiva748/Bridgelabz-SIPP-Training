import java.util.Scanner;

public class StudentVotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        
        int[] ages = generateStudentAges(count);
        String[][] votingStatus = checkVotingEligibility(ages);
        displayResults(votingStatus);
        
        scanner.close();
    }
    
    static int[] generateStudentAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = 10 + (int)(Math.random() * 90);
        }
        return ages;
    }
    
    static String[][] checkVotingEligibility(int[] ages) {
        String[][] status = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            status[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                status[i][1] = "false";
            } else {
                status[i][1] = ages[i] >= 18 ? "true" : "false";
            }
        }
        return status;
    }
    
    static void displayResults(String[][] status) {
        System.out.println("\nVoting Eligibility Status:");
        System.out.println("Age | Can Vote");
        System.out.println("----|----------");
        for (String[] student : status) {
            System.out.printf("%-4s| %s%n", student[0], student[1]);
        }
    }
}
