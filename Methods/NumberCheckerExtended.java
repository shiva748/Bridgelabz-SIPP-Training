import java.util.Arrays;

public class NumberCheckerExtended {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] digitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int number) {
        int[] digits = digitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int number) {
        int[] digits = digitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int number) {
        int[] digits = digitsArray(number);
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }
        int count = 0;
        for (int f : freq) {
            if (f > 0) count++;
        }
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int testNumber = 1729;

        System.out.println("Number: " + testNumber);
        System.out.println("Count of digits: " + countDigits(testNumber));
        System.out.println("Digits array: " + Arrays.toString(digitsArray(testNumber)));
        System.out.println("Sum of digits: " + sumOfDigits(testNumber));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(testNumber));
        System.out.println("Is Harshad number? " + isHarshadNumber(testNumber));

        int[][] freq = digitFrequency(testNumber);
        System.out.println("Digit frequencies:");
        for (int[] pair : freq) {
            System.out.println("Digit " + pair[0] + ": " + pair[1]);
        }
    }
}
