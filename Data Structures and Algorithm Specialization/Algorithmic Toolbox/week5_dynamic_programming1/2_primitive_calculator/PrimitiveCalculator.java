import java.util.Scanner;

public class PrimitiveCalculator {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getMin(m));

	}
	private static int getMin(int m) {
		int [][] a= new int[4][m+1];
		for(int k=0;k<=m;k++) {
			a[0][k] = k;
			a[1][k] = k-1;
		}
		a[1][0]=1;
		a[2][0]=2;
		a[3][0]=3;
		for(int i=2;i<4;i++ ) {
			
			for(int j=2;j<=m;j++) {
				
				if(j>=a[i][0]) {
					int c=Math.min((a[i][j/i]+(j%i)+1),a[i-1][j]);
					if(i>2) {
						c=Math.min(c,(a[i][j/(i-1)]+(j%(i-1))+1));
					}
					a[i][j]=c;
				}
				else {
					a[i][j]=a[i-1][j];
				}
					
				}
			}
		return a[3][m];
		}
		
		
	}


