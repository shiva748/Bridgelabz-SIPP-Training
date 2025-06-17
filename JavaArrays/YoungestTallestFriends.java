import java.util.*;
public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0;i<3;i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }
        int youngestIndex = 0;
        for (int i = 1;i<3;i++) {
            if (ages[i]<ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        int tallestIndex = 0;
        for (int i = 1;i<3;i++) {
            if (heights[i]>heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("The youngest friend is " + friends[youngestIndex]);
        System.out.println("The tallest friend is " + friends[tallestIndex]);
        sc.close();
    }
}
