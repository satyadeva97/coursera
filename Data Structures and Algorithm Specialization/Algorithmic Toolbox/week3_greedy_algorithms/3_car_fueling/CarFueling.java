import java.util.*;
import java.io.*;
public class CarFueling {

    static long computeMinRefills(long dist, long tank,int n, long[] stops) {
    	long start = 0l,count=0l;
    	int i = 0;
    	if(stops[i]>tank || (dist-stops[n-1])>tank) return -1;
    	for(int j=1;j<n;j++) {
    		if((stops[j]-stops[j-1])>tank) return -1;
    	}
    	outer:
    	while(dist>tank) {
    	 if((stops[i]-start)>tank) {
    		 count++;
    		 start = stops[i-1];
    		 dist -= (stops[i]-start);
    		 }
    	 else {
    		 i++;
    		 if(i==n-1) {
    			 count++;
    			 break outer;
    			 
    	 }
       }
    	}
    	return count;
    	
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long dist = scanner.nextLong();
        long tank = scanner.nextLong();
        int n = scanner.nextInt();
        long stops[] = new long[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextLong();
        }

        System.out.println(computeMinRefills(dist, tank, n,stops));
    }
}
