import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
    	int n=w.length;
        int [][] a=new int[ n+1 ][W+1 ];
        for(int i=1;i<=n;i++) {
        	for(int j=1; j<=W; j++) {
        		if(j>=w[i-1]) {
        			a[i][j]=Math.max(a[i-1][j-w[i-1]]+w[i-1],a[i-1][j]);
        		}
        		else {
        			a[i][j]=a[i-1][j];
        		}
        	}
        }
//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
        return a[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

