public class StringConcatComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int n : sizes) {
            long start = System.nanoTime();
            String s = "";
            for (int i = 0; i < n; i++) s += "a";
            long stringTime = System.nanoTime() - start;
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append("a");
            long sbTime = System.nanoTime() - start;
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < n; i++) sbf.append("a");
            long sbfTime = System.nanoTime() - start;
            System.out.println(n + " " + stringTime / 1e6 + "ms " + sbTime / 1e6 + "ms " + sbfTime / 1e6 + "ms");
        }
    }
} 