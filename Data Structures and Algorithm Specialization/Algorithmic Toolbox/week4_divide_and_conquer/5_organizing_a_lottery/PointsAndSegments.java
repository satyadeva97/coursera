import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Arrays.sort(starts);
        Arrays.sort(ends);
        int k=0;
        for(int x: points) {
        	int i=0,j=0;
        	while( i<starts.length) {
        		if(starts[i]<=x) i++;
        		else break;
        	}
        	while(j<ends.length) {
        		if(ends[j]<=(x-1)) j++;
        		else break;
        	}
        	cnt[k]=i-j;
        	k++;
        }
        
        
        return cnt;
    }

 /*(   private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

