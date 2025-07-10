package Sorting;
class SelectionSortExamScores {
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] scores = {88, 75, 92, 60, 85};
        SelectionSortExamScores s = new SelectionSortExamScores();
        s.selectionSort(scores);
        for (int x : scores) System.out.print(x + " ");
    }
} 