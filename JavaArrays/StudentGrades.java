import java.util.*;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];
        for (int i = 0; i < n; ) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Enter positive marks only");
                continue;
            }
            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
            i++;
        }
        for (int i = 0; i < n; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 80) {
                grade[i] = 'B';
            } else if (percentage[i] >= 70) {
                grade[i] = 'C';
            } else if (percentage[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Physics: " + physics[i] + ", Chemistry: " + chemistry[i] + ", Maths: " + maths[i] + ", Percentage: " + percentage[i] + ", Grade: " + grade[i]);
        }
        sc.close();
    }
}
