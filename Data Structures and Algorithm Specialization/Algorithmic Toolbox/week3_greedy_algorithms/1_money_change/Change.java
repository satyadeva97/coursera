import java.util.*;
public class Change {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	System.out.println(coins(n));
}
public static long coins(long x) {
	long count=0;
	count += (x/10)+((x%10)/5)+(x%10)%5;
	return count;
}
}

