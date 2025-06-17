import java.util.*;
public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] digits = new int[10];
        int index = 0;
        int temp = number;
        while (temp != 0) {
            digits[index++] = temp % 10;
            temp /= 10;
        }
        int[] reversed = new int[index];
        for (int i = 0; i < index; i++) {
            reversed[i] = digits[index - 1 - i];
        }
        for (int i = 0; i < index; i++) {
            System.out.print(reversed[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
