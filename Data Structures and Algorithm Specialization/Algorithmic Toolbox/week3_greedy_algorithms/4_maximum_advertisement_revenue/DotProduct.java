import java.util.*;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
//        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        } 
        
        System.out.println(maxDotProduct(a, b));
    }
}

