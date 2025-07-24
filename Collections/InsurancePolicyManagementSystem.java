package Collections;
import java.util.*;

public class InsurancePolicyManagementSystem {
    public Set<InsurancePolicy> hashSet = new HashSet<>();
    public Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    public Set<InsurancePolicy> treeSet = new TreeSet<>(new ExpiryDateComparator());
    public Map<String, InsurancePolicy> hashMap = new HashMap<>();
    public Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
    public Map<Date, InsurancePolicy> treeMap = new TreeMap<>();

    public void addPolicy(InsurancePolicy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
        hashMap.put(p.policyNumber, p);
        linkedHashMap.put(p.policyNumber, p);
        treeMap.put(p.expiryDate, p);
    }

    public List<InsurancePolicy> getAllUniquePolicies() {
        return new ArrayList<>(hashSet);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> soon = new ArrayList<>();
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, 30);
        Date in30 = cal.getTime();
        for (InsurancePolicy p : hashSet) if (p.expiryDate.after(now) && p.expiryDate.before(in30)) soon.add(p);
        return soon;
    }

    public List<InsurancePolicy> getPoliciesByCoverage(String type) {
        List<InsurancePolicy> res = new ArrayList<>();
        for (InsurancePolicy p : hashSet) if (p.coverageType.equals(type)) res.add(p);
        return res;
    }

    public List<InsurancePolicy> getDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        List<InsurancePolicy> dup = new ArrayList<>();
        for (InsurancePolicy p : hashSet) if (!seen.add(p.policyNumber)) dup.add(p);
        return dup;
    }

    public void removeExpiredPolicies() {
        Date now = new Date();
        hashSet.removeIf(p -> p.expiryDate.before(now));
        linkedHashSet.removeIf(p -> p.expiryDate.before(now));
        treeSet.removeIf(p -> p.expiryDate.before(now));
        hashMap.values().removeIf(p -> p.expiryDate.before(now));
        linkedHashMap.values().removeIf(p -> p.expiryDate.before(now));
        treeMap.values().removeIf(p -> p.expiryDate.before(now));
    }
}
