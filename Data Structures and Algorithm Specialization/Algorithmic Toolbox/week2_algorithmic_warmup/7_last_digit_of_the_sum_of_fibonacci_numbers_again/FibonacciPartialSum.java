import java.util.*;
public class FibonacciPartialSum {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		long m = in.nextLong();
		long n = in.nextLong();
		
		System.out.println(sum(m,n));
}
	public static long sum(long a, long b) {
		long prev2 = 0l;
		long prev1 = 1l;
		long current,temp1 = 0,temp2 = 0,temp = 0;
		long sum=1;
		long i=2,quotient, quotient1, quotient2, remainder1,remainder2;
//		if(a<2) return a;
		
		quotient1 =  a/60;
		quotient2 =  b/60;
		quotient = quotient2-(quotient1+1);
		remainder1=  a%60;
		remainder2 = b%60;
		if(remainder2<2) {
			temp2 = remainder2;
		}
		if(remainder1<2) {
			temp = 0;
		}
		while(i<61) {
			current = prev1 + prev2;
			
			sum += current;
			if(i==(remainder1-1)) temp =sum;
			if(i==remainder2) temp2 =sum;	
			prev2 = prev1;
			prev1 = current;
			i++;
		}
		temp1 = sum-temp;
		return ((((sum%10)*quotient)%10)+(temp1%10)+(temp2%10))%10;		
	}
}
