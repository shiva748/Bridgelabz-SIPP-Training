package Collections;
import java.util.*;

public class ExpiryDateComparator implements Comparator<InsurancePolicy> {
    public int compare(InsurancePolicy p1, InsurancePolicy p2) {
        return p1.expiryDate.compareTo(p2.expiryDate);
    }
}
