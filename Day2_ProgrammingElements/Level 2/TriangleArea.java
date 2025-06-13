
public class TriangleArea {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the base of the triangle in cm: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double height = scanner.nextDouble();

        double areaInCm2 = 0.5 * base * height;

        double areaInIn2 = areaInCm2 / (2.54 * 2.54);

        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n", areaInIn2, areaInCm2);

        scanner.close();
    }
}
