import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        
        int[][] scores = generateScores(count);
        double[][] calculations = calculateStats(scores);
        String[][] grades = calculateGrades(calculations);
        
        displayScorecard(scores, calculations, grades);
        scanner.close();
    }
    
    static int[][] generateScores(int count) {
        int[][] scores = new int[count][3];
        for (int i = 0; i < count; i++) {
            scores[i][0] = (int)(Math.random() * 51) + 50;
            scores[i][1] = (int)(Math.random() * 51) + 50;
            scores[i][2] = (int)(Math.random() * 51) + 50;
        }
        return scores;
    }
    
    static double[][] calculateStats(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total * 100.0) / 300;
            
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }
    
    static String[][] calculateGrades(double[][] calculations) {
        String[][] grades = new String[calculations.length][2];
        for (int i = 0; i < calculations.length; i++) {
            double percentage = calculations[i][2];
            grades[i][0] = String.valueOf(i + 1);
            
            if (percentage >= 90) {
                grades[i][1] = "A+";
            } else if (percentage >= 80) {
                grades[i][1] = "A";
            } else if (percentage >= 70) {
                grades[i][1] = "B";
            } else if (percentage >= 60) {
                grades[i][1] = "C";
            } else if (percentage >= 50) {
                grades[i][1] = "D";
            } else {
                grades[i][1] = "F";
            }
        }
        return grades;
    }
    
    static void displayScorecard(int[][] scores, double[][] calculations, String[][] grades) {
        System.out.println("\nStudent Scorecard:");
        System.out.println("ID | Physics | Chemistry | Math | Total | Average | Percentage | Grade");
        System.out.println("---|---------|-----------|------|--------|----------|------------|-------");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-3s| %-8d| %-10d| %-5d| %-7.2f| %-9.2f| %-11.2f| %s%n",
                grades[i][0], scores[i][0], scores[i][1], scores[i][2],
                calculations[i][0], calculations[i][1], calculations[i][2],
                grades[i][1]);
        }
    }
}
