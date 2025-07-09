package Sorting;
class CountingSortStudentAges {
    public void countingSort(int[] arr) {
        int min = 10, max = 18;
        int[] count = new int[max - min + 1];
        for (int x : arr) count[x - min]++;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) arr[idx++] = i + min;
        }
    }
    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 12, 17};
        CountingSortStudentAges c = new CountingSortStudentAges();
        c.countingSort(ages);
        for (int x : ages) System.out.print(x + " ");
    }
} 