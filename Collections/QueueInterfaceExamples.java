package Collections;
import java.util.*;

public class QueueInterfaceExamples {
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) stack.push(queue.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());
        return queue;
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String s = q.remove();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }

    public static class Patient implements Comparable<Patient> {
        String name;
        int severity;
        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
        public int compareTo(Patient o) {
            return Integer.compare(o.severity, this.severity);
        }
    }

    public static List<String> hospitalTriage(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(patients);
        List<String> order = new ArrayList<>();
        while (!pq.isEmpty()) order.add(pq.poll().name);
        return order;
    }

    public static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) q2.add(q1.remove());
            Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
        }
        public int pop() { return q1.remove(); }
        public int top() { return q1.peek(); }
        public boolean empty() { return q1.isEmpty(); }
    }

    public static class CircularBuffer {
        int[] arr;
        int size, start, count;
        public CircularBuffer(int k) {
            arr = new int[k];
            size = k; start = 0; count = 0;
        }
        public void insert(int x) {
            arr[(start + count) % size] = x;
            if (count < size) count++;
            else start = (start + 1) % size;
        }
        public List<Integer> getBuffer() {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < count; i++) res.add(arr[(start + i) % size]);
            return res;
        }
    }
}
