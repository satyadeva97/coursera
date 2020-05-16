import java.util.*;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
    	int l = exp.length();
    	int q=0;
    	int n = (l/2) + 1;
    	StringBuilder S= new StringBuilder();
    	int [] values = new int[n];
    	long [][] M = new long[n][n];
    	long [][] m = new long[n][n];
    	long [] a = new long[2];
    	for(int i=1;i<l;i+=2) {
    		S.append(exp.charAt(i));
    	}
//    	System.out.println(S);
//    	System.out.println(exp);
    	
    	for(int i=0;i<l;i+=2) {
    		values[q] = exp.charAt(i)-'0';
    		q++;
    	}
 //  	System.out.println(Arrays.toString(values));
    	for(int i=0;i<n;i++) {
    		M[i][i]=values[i];
    		m[i][i]=values[i];
    	}
    	
    	for(int s=1;s<=n-1;s++) {
    		for(int i = 0; i < n-s ; i++) {
    			int j = i+s;
//    			if(i == 0 && j == 3) {
//    				System.out.println("hi");
//    			};
    			a=maxMin(S, values, i ,j,M,m);
    			M[i][j] = a[0];
    			m[i][j] = a[1];
    			
    		}
    	}
    	
 //     System.out.println(Arrays.deepToString(M));
      return M[0][n-1];
    }
    private static long[] maxMin(StringBuilder S, int[] values, int i, int j, long[][] M, long[][] m) {
    	long [] temp = new long[2];
    	long min = Long.MAX_VALUE;
    	long max = Long.MIN_VALUE;
    	for(int k=i; k<j; k++) {
    		long a = eval((M[i][k]),M[k+1][j],S.charAt(k));
    		long b = eval((M[i][k]),m[k+1][j],S.charAt(k));
    		long c = eval((m[i][k]),M[k+1][j],S.charAt(k));
    		long d = eval((m[i][k]),m[k+1][j],S.charAt(k));
    		max = Math.max(a,Math.max(b,Math.max(c,Math.max(d,max))));
    		min = Math.min(a,Math.min(b,Math.min(c,Math.min(d,min))));
    		
    	}
    	temp[0] = max;
    	temp[1] = min;
    	return temp;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

