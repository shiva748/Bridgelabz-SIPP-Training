package StackQueueHash;
import java.util.LinkedList;
import java.util.Queue;
class CircularTourProblem {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    public int findStart(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0, end = 1;
        int currPetrol = pumps[start].petrol - pumps[start].distance;
        while (start != end || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                currPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % n;
                if (start == 0) return -1;
            }
            currPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };
        CircularTourProblem c = new CircularTourProblem();
        System.out.println(c.findStart(pumps));
    }
} 