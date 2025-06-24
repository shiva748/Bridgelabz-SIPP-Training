public class Circle {
    double radius;
    Circle() {
        this(1);
    }
    Circle(double radius) {
        this.radius = radius;
    }
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        System.out.println(c1.radius);
        System.out.println(c2.radius);
    }
} 