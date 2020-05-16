import java.util.*;
public class FibonacciSumLastDigit {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.println(sum(n));
}
	public static long sum(long a) {
		long prev2 = 0l;
		long prev1 = 1l;
		long current,lastdigit,temp = 0;
		long sum=1;
		long i=2,quotient,remainder;
		if(a<2) return a;
		
		quotient =  a/60;
		remainder=  a%60;
		while(i<61) {
			current = prev1%10 + prev2%10;
			sum += current%10;
			if(i==remainder) temp =sum;
			if(i==a) return sum%10;		
			prev2 = prev1;
			prev1 = current;
			i++;
		}
		return ((sum*quotient)+temp)%10;		
	}
}
