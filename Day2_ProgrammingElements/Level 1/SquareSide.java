public class SquareSide {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();
        
        double side = perimeter / 4;
        
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        
        input.close();
    }
}