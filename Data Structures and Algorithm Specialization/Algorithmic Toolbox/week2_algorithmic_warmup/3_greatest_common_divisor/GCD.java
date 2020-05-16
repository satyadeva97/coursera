import java.util.Scanner;
public class GCD {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n1 = in.nextInt();
	int n2 = in.nextInt();
	System.out.println(gcd(n1,n2));
	
}
public static int gcd(int x, int y) {
	int r=1;
	while(true) {
		r = x%y;
		if(r == 0) break;
		x=y;
		y=r;
		
	}
	return y;
	
}
}