import java.util.*;
public class FibonacciHuge {
public static void main(String [] args) {
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	long m = in.nextLong();
	System.out.println(modulo(n,m));
}
public static long modulo(long x, long y) {
	ArrayList<Long> md = new ArrayList<Long>();
	long prev2=0;
	long prev1=1;
	long current;
	int i=2;
	long pisano;
	md.add(0l);
	md.add(1l);
	long r;
	
	while(true) {
		
		current = prev1%y+prev2%y;
/*		if(i==1499) {
			System.out.println("I am the fucker");
		}*/
		
//		System.out.println(current);
		md.add(current%y);
		if(md.get(i)==1 && md.get(i-1)==0)
		{
			 break;
			
		}
		prev2 = prev1;
		prev1 = current;
		i++;
	}
	pisano = i-1;
	if(x>pisano) {
	r =md.get((int)((x%pisano)));
	return r;
	}
	else { return md.get((int)(x));}
}
}