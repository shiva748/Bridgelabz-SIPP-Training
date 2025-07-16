import java.util.Arrays;

public class LinearSearchFirstNegative {
    public static void main(String[] args) {
        int[] numbers = {3, 5, -1, 2, 4};
        int index = findFirstNegative(numbers);
        System.out.println(index);
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}