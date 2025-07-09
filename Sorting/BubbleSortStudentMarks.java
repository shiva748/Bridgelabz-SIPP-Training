package Sorting;
class BubbleSortStudentMarks {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    public static void main(String[] args) {
        int[] marks = {78, 55, 89, 62, 90, 45};
        BubbleSortStudentMarks b = new BubbleSortStudentMarks();
        b.bubbleSort(marks);
        for (int x : marks) System.out.print(x + " ");
    }
} 