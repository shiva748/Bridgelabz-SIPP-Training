import java.util.*;
public class Store_multvalinarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] multTable = new int[10];
        for (int i = 1; i <= 10; i++) {
            multTable[i - 1] = number * i;
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multTable[i - 1]);
        }
        sc.close();
    }
}
