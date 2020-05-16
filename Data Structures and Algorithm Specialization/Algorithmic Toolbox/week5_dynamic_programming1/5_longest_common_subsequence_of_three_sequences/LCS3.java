import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
    	
    	int m = a.length;
    	int n = b.length;
    	int o = c.length;
    	
    	int [][][] arr = new int[m+1][n+1][o+1];
    	
        for(int i = 1;i <= m; i++) {
        	for(int j = 1;j <= n; j++) {
        		for(int k = 1;k <= o; k++) {
	        		if((a[i - 1] == b[j - 1]) && (b[j - 1] == c[k - 1])) {
	        			arr[i][j][k] = arr[i - 1][j - 1][k - 1] + 1;
	        		}
	        		else {
	        			arr[i][j][k] = Math.max(arr[i - 1][j][k], Math.max(arr[i][j - 1][k], arr[i][j][k - 1]));
	        		}
        		}
        	}
        }
        
        int i = m, j = n, k = o;
        int[] y= new int[arr[m][n][o]];
        
        int l = y.length;
        
        while((i >= 1) && (j >= 1) && (k >= 1)) {
        	if((a[i - 1] == b[j - 1]) && (b[j - 1] == c[k - 1]) && (arr[i][j][k] == (arr[i - 1][j - 1][k - 1] + 1))) {
        		y[--l] = a[i - 1];
        		i -= 1;
        		j -= 1;
        		k -= 1;
        	} else if(arr[i][j][k] == arr[i][j][k - 1]) {
        		k -= 1;
        	} else if(arr[i][j][k] == arr[i][j - 1][k]) {
        		j -= 1;
        	} else {
        		i -= 1;
        	}
        }


        
        // System.out.println(Arrays.deepToString(arr));
        
        
        // System.out.println(Arrays.toString(y));

        return arr[m][n][o];
    }
    


    private static int lcs2(int[] a, int[] b) {
    	
    	int m = a.length;
    	int n = b.length;

    	int [][] arr = new int[m+1][n+1];
    	
        for(int i = 1;i <= m; i++) {
        	for(int j = 1;j <= n; j++) {
        		if((a[i - 1] == b[j - 1])) {
        			arr[i][j] = arr[i - 1][j - 1] + 1;
        		}
        		else {
        			arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
        		}
        	}
        }
        
        int i = m, j = n;
        int[] y= new int[arr[m][n]];
        
        int l = y.length;
        
        while((i >= 1) && (j >= 1)) {
        	if((a[i - 1] == b[j - 1]) && (arr[i][j] == (arr[i - 1][j - 1] + 1))) {
        		y[--l] = a[i - 1];
        		i -= 1;
        		j -= 1;
        	} else if(arr[i][j] == arr[i - 1][j]) {
        		i -= 1;
        	} else if(arr[i][j] == arr[i][j - 1]) {
        		j -= 1;
        	}
        }


        // System.out.println(Arrays.deepToString(arr));
        
        
        // System.out.println(Arrays.toString(y));

        return arr[m][n];
    }


    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        
        int o = scanner.nextInt();
        int[] c = new int[o];
        for (int i = 0; i < o; i++) {
            c[i] = scanner.nextInt();
        }

       //int s1=lcs2(lcs2(a, b), lcs2(b, c)).length;
       //int s2=lcs2(lcs2(b,a),c).length;

       //System.out.println(Math.max(s1, s2));
       System.out.println(lcs3(a, b, c));

       //System.out.println(lcs2(a, b));
        
      
    }
}

