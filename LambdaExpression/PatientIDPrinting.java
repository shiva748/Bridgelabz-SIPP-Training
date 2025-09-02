
import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList("P001", "P002", "P003");

        
        patientIDs.forEach(System.out::println);
    }
}
