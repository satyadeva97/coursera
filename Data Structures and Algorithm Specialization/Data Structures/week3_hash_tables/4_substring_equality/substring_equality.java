

import java.util.*;

public class substring_equality {
	static long p1 = 1000000007;
	static long p2 = 1000000009;
	static long x = 2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = s.length();
		long[] h1 = new long[n];
		long[] h2 = new long[n];
//		h1[0] = s.charAt(0); h2[0] = s.charAt(0);
		h1[0] = 0;
		h2[0] = 0;
		for (int i = 1; i < n; i++) {
//			h1[i] = hashing(s.substring(1,i+1), x, p1);
//			h2[i] = hashing(s.substring(0,i), x, p2);
			h1[i] = ((h1[i - 1] * x) + s.charAt(i)) % p1;
			h2[i] = ((h2[i - 1] * x) + s.charAt(i)) % p2;
		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt() - 1;
			long y1 = 1;
			long y2 = 1;
			for (int j = 1; j <= (l + 1); j++) {
				y1 = (y1 * x) % p1;
				y2 = (y2 * x) % p2;
			}
			
			//checking for a =0 and b = 0 because as we are checking h[a-1] it will throw error. hence 4 different conditions
			if (a != 0 && b != 0) {
				long h1t1 = (h1[a + l] - product(y1, h1[a - 1], p1)) % p1;
				while (h1t1 < 0) {
					h1t1 = h1t1 + p1;
				}
				h1t1 = h1t1 % p1;
				long h1t2 = (h1[b + l] - product(y1, h1[b - 1], p1)) % p1;
				while (h1t2 < 0) {
					h1t2 = h1t2 + p1;
				}
				h1t1 = h1t1 % p1;
				long h2t1 = (h2[a + l] - product(y2, h2[a - 1], p2)) % p2;
				while (h2t1 < 0) {
					h2t1 = h2t1 + p2;
				}
				h2t1 = h2t1 % p2;
				long h2t2 = (h2[b + l] - product(y2, h2[b - 1], p2)) % p2;
				while (h2t2 < 0) {
					h2t2 = h2t2 + p2;
				}
				h2t2 = h2t2 % p2;
				if (h1t1 == h1t2 && h2t1 == h2t2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}

			else if (a == 0 && b != 0) {
				long h1t1 = h1[a + l] % p1;
				while (h1t1 < 0) {
					h1t1 = h1t1 + p1;
				}
				h1t1 = h1t1 % p1;
				long h1t2 = (h1[b + l] - product((y1 / x), h1[b], p1)) % p1;
				while (h1t2 < 0) {
					h1t2 = h1t2 + p1;
				}
				h1t2 = h1t2 % p1;
				long h2t1 = h2[a + l] % p2;
				while (h2t1 < 0) {
					h2t1 = h2t1 + p2;
				}
				h2t1 = h2t1 % p2;
				long h2t2 = (h2[b + l] - product((y2 / x), h2[b], p2)) % p2;
				while (h2t2 < 0) {
					h2t2 = h2t2 + p2;
				}
				h2t2 = h2t2 % p2;
				if (h1t1 == h1t2 && h2t1 == h2t2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}

			else if (a != 0 && b == 0) {
				long h1t1 = (h1[a + l] - product((y1 / x), h1[a], p1)) % p1;
				while (h1t1 < 0) {
					h1t1 = h1t1 + p1;
				}
				h1t1 = h1t1 % p1;
				long h1t2 = h1[b + l] % p1;
				while (h1t2 < 0) {
					h1t2 = h1t2 + p1;
				}
				h1t2 = h1t2 % p1;
				long h2t1 = (h2[a + l] - product((y2 / x), h2[a], p2)) % p2;
				while (h2t1 < 0) {
					h2t1 = h2t1 + p2;
				}
				h2t1 = h2t1 % p2;
				long h2t2 = h2[b + l] % p2;
				while (h2t2 < 0) {
					h2t2 = h2t2 + p2;
				}
				h2t2 = h2t2 % p2;
				if (h1t1 == h1t2 && h2t1 == h2t2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}

			else {
				long h1t1 = h1[a + l] % p1;
				while (h1t1 < 0) {
					h1t1 = h1t1 + p1;
				}
				h1t1 = h1t1 % p1;
				long h1t2 = h1[b + l] % p1;
				while (h1t2 < 0) {
					h1t2 = h1t2 + p1;
				}
				h1t2 = h1t2 % p1;
				long h2t1 = h2[a + l] % p2;
				while (h2t1 < 0) {
					h2t1 = h2t1 + p2;
				}
				h2t1 = h2t1 % p2;
				long h2t2 = h2[b + l] % p2;
				while (h2t2 < 0) {
					h2t2 = h2t2 + p2;
				}
				h2t2 = h2t2 % p2;
				if (h1t1 == h1t2 && h2t1 == h2t2) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}

	}

//	private static long hashing(String s, int x, int p) {
//	    long hash = 0;
//	    for (int i = 0; i <=s.length() - 1; i++)
//	        hash = (hash * x + s.charAt(i)) % p;
//	    return hash;
//	}
	public static long product(long x, long y, long p) {
		long prod = ((x % p) * (y % p)) % p;
		return prod;
	}

}
