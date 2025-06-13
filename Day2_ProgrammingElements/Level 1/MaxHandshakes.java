
public class MaxHandshakes {

    public static void main(String[] args) {
        int numberOfStudents = 10;
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("The maximum number of possible handshakes among " + numberOfStudents + " students is " + maxHandshakes);
    }
}
