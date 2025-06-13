
public class HeightConverter {

    public static void main(String[] args) {
        double heightInCm = 170;
        double heightInInches = heightInCm / 2.54;
        double heightInFeet = heightInInches / 12;

        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f%n", heightInCm, heightInFeet, heightInInches);
    }
}
