import java.util.Scanner;
import java.util.*;
public class LCM {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int n1 = in.nextInt();
int n2 = in.nextInt();

System.out.println(lcm(n1,n2));
}

public static long lcm(int x, int y) {
	
	long i=0;
	if(x<y) {
		int temp = y;
		y = x;
		x = temp;
	}
	while(true) {
		i++;
		long r = (x*i)%y;
		if (r == 0) break;
		
	}
	return x*i;
	
}
}