

import java.util.*;

public class common_substring {
	static long p1 = 1000000007;
	static long p2 = 1000000009;
	static int x = 2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		out:
		while (in.hasNext()) {
			String s1 = in.next();
			int n1 = s1.length();
			String s2 = in.next();
			int n2 = s2.length();
			int min = Math.min(n1, n2);
//			ArrayList<Long> p11 = new ArrayList<Long>();
//			ArrayList<Long> p12 = new ArrayList<Long>();
//			ArrayList<Long> p21 = new ArrayList<Long>();
//			ArrayList<Long> p22 = new ArrayList<Long>();
//			long p11[] = new long[n1];
//			long p12[] = new long[n1];
//			long p21[] = new long[n2];
//			long p22[] = new long[n2];
			int left = 0, right = min - 1;
			outer :
			while (left <= right) {
				int mid = (left + right) / 2;
				int actmid = mid + 1;
				long y = 1;
				long h11[] = new long[n1 - actmid + 1];
				long h12[] = new long[n1 - actmid + 1];
				long h21[] = new long[n2 - actmid + 1];
				long h22[] = new long[n2 - actmid + 1];
				h11[(n1 - actmid)] = hashing(s1.substring(n1 - actmid, n1), x, p1);
				h12[(n1 - actmid)] = hashing(s1.substring(n1 - actmid, n1), x, p2);
				h21[(n2 - actmid)] = hashing(s2.substring(n2 - actmid, n2), x, p1);
				h22[(n2 - actmid)] = hashing(s2.substring(n2 - actmid, n2), x, p2);
				for (int j = 0; j < actmid; j++) {
					y = ((y * x) % p1);
				}
				for (int i = (n1 - actmid) - 1; i >= 0; i--) {
					long prehash11 = ((product(h11[i + 1], x , p1) + s1.charAt(i) - (product(s1.charAt(i + actmid), y, p1)) % p1));
					while (prehash11 < 0) {
						prehash11 += p1;
					}
					h11[i] = prehash11 % p1;

					long prehash12 = ((product(h12[i + 1], x , p2) + s1.charAt(i) - (product(s1.charAt(i + actmid), y, p2)) % p2));
					while (prehash12 < 0) {
						prehash12 += p2;
					}
					h12[i] = prehash12 % p2;
					
				}

				for (int i = (n2 - actmid) - 1; i >= 0; i--) {
					long prehash21 = ((product(h21[i + 1], x , p1) + s2.charAt(i) - (product(s2.charAt(i + actmid), y, p1)) % p1));
					while (prehash21 < 0) {
						prehash21 += p1;
					}
					h21[i] = prehash21 % p1;

					long prehash22 = ((product(h22[i + 1], x , p2) + s2.charAt(i) - (product(s2.charAt(i + actmid), y, p2)) % p2));
					while (prehash22 < 0) {
						prehash22 += p2;
					}
					h22[i] = prehash22 % p2;
					
				}

				for (int i = 0; i < n1 - actmid + 1; i++) {
					for(int j =0; j < n2 - actmid + 1; j++) {
						if (h11[i] == h21[j] && h12[i] == h22[j]) {
							left = actmid;
							continue outer;
						}
					}
				}
				right = mid - 1;
			}
			int string_size = left;

			long y = 1;
			long h11[] = new long[n1 - string_size + 1];
			long h12[] = new long[n1 - string_size + 1];
			long h21[] = new long[n2 - string_size + 1];
			long h22[] = new long[n2 - string_size + 1];
			h11[n1 - string_size] = hashing(s1.substring(n1 - string_size, n1), x, p1);
			h12[n1 - string_size] = hashing(s1.substring(n1 - string_size, n1), x, p2);
			h21[n2 - string_size] = hashing(s2.substring(n2 - string_size, n2), x, p1);
			h22[n2 - string_size] = hashing(s2.substring(n2 - string_size, n2), x, p2);
			for (int j = 0; j < string_size; j++) {
				y = ((y * x) % p1);
			}
			for (int i = (n1 - string_size) - 1; i >= 0; i--) {
				long prehash11 = ((product(h11[i + 1], x , p1) + s1.charAt(i) - (product(s1.charAt(i + string_size), y, p1)) % p1));
				while (prehash11 < 0) {
					prehash11 += p1;
				}
				h11[i] = prehash11 % p1;

				long prehash12 = ((product(h12[i + 1], x , p2) + s1.charAt(i) - (product(s1.charAt(i + string_size), y, p2)) % p2));
				while (prehash12 < 0) {
					prehash12 += p2;
				}
				h12[i] = prehash12 % p2;
				
			}

			for (int i = (n2 - string_size) - 1; i >= 0; i--) {
				long prehash21 = ((product(h21[i + 1], x , p1) + s2.charAt(i) - (product(s2.charAt(i + string_size), y, p1)) % p1));
				while (prehash21 < 0) {
					prehash21 += p1;
				}
				h21[i] = prehash21 % p1;

				long prehash22 = ((product(h22[i + 1], x , p2) + s2.charAt(i) - (product(s2.charAt(i + string_size), y, p2)) % p2));
				while (prehash22 < 0) {
					prehash22 += p2;
				}
				h22[i] = prehash22 % p2;
				
			}

			for (int i = 0; i < n1 - string_size + 1 ; i++) {
				for (int j = 0; j < n2 - string_size + 1; j++) {
					if (h11[i] == h21[j] && h12[i] == h22[j]) {
						System.out.println(i + " " + j + " " + string_size);
						continue out;
					}
				}
			}
		}
	}

	private static long hashing(String s, int x, long p) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; --i)
			hash = (hash * x + s.charAt(i)) % p;
		return hash;
	}
	
	public static long product(long x, long y, long p) {
		long prod = ((x % p) * (y % p)) % p;
		return prod;
	}

}
