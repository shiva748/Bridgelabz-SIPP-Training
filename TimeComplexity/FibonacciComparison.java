public class FibonacciComparison {
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        if (n == 0) return 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] ns = {10, 30, 50};
        for (int n : ns) {
            long start = System.nanoTime();
            if (n <= 30) fibonacciRecursive(n);
            long recTime = System.nanoTime() - start;
            start = System.nanoTime();
            fibonacciIterative(n);
            long iterTime = System.nanoTime() - start;
            System.out.println(n+" " + recTime/1e6 + "ms " + iterTime/1e6 + "ms");
        }
    }
} 