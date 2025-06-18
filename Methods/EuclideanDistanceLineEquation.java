import java.util.Scanner;

public class EuclideanDistanceLineEquation {

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double slope;
        if (x2 - x1 == 0) {
            throw new IllegalArgumentException("Slope is undefined for vertical line.");
        } else {
            slope = (y2 - y1) / (x2 - x1);
        }
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance between points: " + distance);

        double[] line = lineEquation(x1, y1, x2, y2);
        System.out.printf("Line equation: y = %.2fx + %.2f\n", line[0], line[1]);

        scanner.close();
    }
}
