import java.util.*;
import java.lang.Math;
//import java.lang.*;
public class FractionalKnapsack{
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double capacity = in.nextDouble();
		double [] values = new double[n];
		double [] weights = new double[n];
		for(int i=0;i<n;i++) {
			values[i] = in.nextDouble();
			weights[i] = in.nextDouble();
		}
		System.out.println(max(n,capacity,values,weights));
		
	}
	public static double max(int n, double capacity,double [] values,double [] weights) {
		int j=0;
		double[] a= new double[n];
		double value=0;
		for(int i=0;i<n;i++) {
			a[i] = values[i]/weights[i];
		}
		Arrays.sort(a);
		while(capacity!=0) {
			j++;
			if(j>n) {
				break;
			}
			outer:
			for(int i=0;i<n;i++) {
				if((values[i]/weights[i])==a[n-j]) {
					values[i]=0;
					double min = Math.min(capacity,weights[i]);
					capacity-=min;
					value +=min*a[n-j];
					break outer;
				}
				
			}
			
		}
		return value;
	}
}

		
		

