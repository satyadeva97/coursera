import java.util.*;

public class ChangeDP {
    private static int getChange(int m) {
        int [][] a = new int[4][m+1];
        int[] b= {1,3,4};
        for(int i=0;i<m+1;i++) {
        	a[0][i]=i;
        }
        int p=0;
        for(int k=1;k<=3;k++) {
        	for(int j=1;j<=m;j++) {
        		if(j>=b[k-1]) {
        			a[k][j]=Math.min(a[k-1][j],(1+a[k][j-b[k-1]]));
        		}
        		else {
        			a[k][j]=a[k-1][j];
        		}
        	}
        }
        return a[3][m];
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

