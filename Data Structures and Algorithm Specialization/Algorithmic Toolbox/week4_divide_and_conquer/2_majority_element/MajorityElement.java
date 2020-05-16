import java.util.*;
import java.lang.*;
import java.io.*;
 
 
public class MajorityElement {
 
	public static void main (String[] args) throws java.lang.Exception {
 
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.println(containsMajorityElement(a) ? 1 : 0);
 
	}
 
	public static boolean containsMajorityElement(int a[]) {
		int i = 0, m = a[0], j = 0, n = a.length;
		while(j < n) {
			if (i == 0) {
				m = a[j];
				i = 1;
			} else if (m == a[j]) {
				i += 1;
			} else {
				i -= 1;
			}
			j += 1;
		}
 
		j = 0;
		i = 0;
		while (j < n) {
			if (a[j] == m) {
				i += 1;
			}
			j += 1;
		}
 
		return i > (n / 2);
	}
 
}
