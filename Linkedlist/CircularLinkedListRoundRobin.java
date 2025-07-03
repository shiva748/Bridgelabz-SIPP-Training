package Linkedlist;
class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }
}
class CircularLinkedListRoundRobin {
    private ProcessNode tail;
    private int size;
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(processId, burstTime, priority);
        if (tail == null) {
            tail = node;
            node.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void removeProcess(int processId) {
        if (tail == null) return;
        ProcessNode curr = tail.next, prev = tail;
        do {
            if (curr.processId == processId) {
                if (curr == tail) {
                    if (tail == tail.next) tail = null;
                    else { prev.next = curr.next; tail = prev; }
                } else {
                    prev.next = curr.next;
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
    }
    public void displayProcesses() {
        if (tail == null) return;
        ProcessNode curr = tail.next;
        do {
            System.out.println(curr.processId + " " + curr.burstTime + " " + curr.priority + " " + curr.remainingTime);
            curr = curr.next;
        } while (curr != tail.next);
    }
    public void simulate(int timeQuantum) {
        if (tail == null) return;
        int time = 0;
        int completed = 0;
        int[] waiting = new int[size];
        int[] turnaround = new int[size];
        int[] burst = new int[size];
        int[] pid = new int[size];
        int idx = 0;
        ProcessNode curr = tail.next;
        do {
            burst[idx] = curr.burstTime;
            pid[idx] = curr.processId;
            idx++;
            curr = curr.next;
        } while (curr != tail.next);
        while (completed < size) {
            curr = tail.next;
            do {
                if (curr.remainingTime > 0) {
                    int exec = Math.min(timeQuantum, curr.remainingTime);
                    curr.remainingTime -= exec;
                    time += exec;
                    if (curr.remainingTime == 0) {
                        for (int i = 0; i < size; i++) {
                            if (pid[i] == curr.processId) {
                                turnaround[i] = time;
                                waiting[i] = time - burst[i];
                                completed++;
                                break;
                            }
                        }
                        removeProcess(curr.processId);
                        break;
                    }
                }
                curr = curr.next;
            } while (curr != tail.next);
            displayProcesses();
        }
        double avgWait = 0, avgTurn = 0;
        for (int i = 0; i < size; i++) {
            avgWait += waiting[i];
            avgTurn += turnaround[i];
        }
        if (size > 0) {
            avgWait /= size;
            avgTurn /= size;
        }
        System.out.println("Average Waiting Time: " + avgWait);
        System.out.println("Average Turnaround Time: " + avgTurn);
    }
    public static void main(String[] args) {
        CircularLinkedListRoundRobin rr = new CircularLinkedListRoundRobin();
        rr.addProcess(1, 5, 1);
        rr.addProcess(2, 3, 2);
        rr.addProcess(3, 8, 1);
        rr.addProcess(4, 6, 3);
        rr.displayProcesses();
        rr.simulate(2);
    }
} 