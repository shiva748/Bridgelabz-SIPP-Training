import java.util.Arrays;

public class BinarySearchRotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12};
        int rotationPoint = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationPoint);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}