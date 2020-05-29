
import java.util.*;
public class HashSubstring {
	static int x = 10000077;
	static int p = 10000007;
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String req = in.next();
		int n = req.length();
		String tab = in.next();
		int m = tab.length();
		long y = 1;
		long hashr = hashing(req, x, p);
		long [] hasht = new long[m-n+1];
		String subs = tab.substring(m-n, m);
		hasht[(m-n)] = hashing(subs, x, p);
		for(int j = 0; j < n; j++) {
			 y = ((y * x) % p);
		}
		for(int i = (m-n)-1; i >= 0; i--) {			
			long prehash = hasht[i+1]*x + tab.charAt(i) - (tab.charAt(i + n) * (int)y) ;
			while(prehash < 0) {
				prehash += p;
			}
			hasht[i] = prehash % p;
		}
		for(int i = 0; i<= m-n; i++) {
			if(hasht[i] == hashr) {
				if(req.equals(tab.substring(i, i+n))) {
					System.out.print(i + " ");				
				}
			}
		}	
	}
	
	private static long hashing(String s, int x, int p) {
	    long hash = 0;
	    for (int i = s.length() - 1; i >= 0; --i)
	        hash = (hash * x + s.charAt(i)) % p;
	    return hash;
	}
	
	
}
