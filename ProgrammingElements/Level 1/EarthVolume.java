
public class EarthVolume {

    public static void main(String[] args) {
        double radius = 6378;
        double pi = Math.PI;

        double volumeKm3 = (4.0 / 3.0) * pi * Math.pow(radius, 3);
        double volumeMiles3 = volumeKm3 / Math.pow(1.6, 3);

        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f%n", volumeKm3, volumeMiles3);
    }
}
