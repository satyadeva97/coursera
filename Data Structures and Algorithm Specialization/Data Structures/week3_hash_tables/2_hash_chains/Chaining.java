
import java.util.*;
public class Chaining {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int m = in.nextInt();
	ArrayList<String>[] table = new ArrayList[m];
	for (int i = 0; i < m; i++) { 
        table[i] = new ArrayList<String>(); 
    }
	int n = in.nextInt();
	for(int i = 0; i< n; i++) {
		String e = in.next();
		if( e.equals("add")) {
			add(in.next(), m, table);
		}
		else if( e.equals("del")) {
			del(in.next(), m, table);
		}
		else if( e.equals("find")) {
			System.out.println(find(in.next(), m, table));
		}
		else {
			check(in.nextInt(), table);
		}
		
	}
	
}
//public static int hashing( String s, int m) {
//	long hash = 0;
//	for(int i = 0; i< s.length(); i++) {
//		int t = s.charAt(i);
//		hash += ((((t * ((Math.pow(263, i)) % 1000000007)) % 1000000007) + 1000000007) % 1000000007);
//	}
//	hash = (hash % 1000000007);
//	int hash1 = (int) hash % m;
//	return hash1;
//}
private static int hashing(String s, int m) {
    long hash = 0;
    for (int i = s.length() - 1; i >= 0; --i)
        hash = (hash * 263 + s.charAt(i)) % 1000000007;
    return (int)hash % m;
}

public static void add(String s,int m, ArrayList<String>[] table) {
	int hash = hashing(s, m);
	if(table[hash].contains(s)) {
		return;
	}
	table[hash].add(0,s);
}

public static void del(String s,int m, ArrayList<String>[] table) {
	int hash = hashing(s, m);
	if(table[hash].contains(s)) {
		table[hash].remove(new String(s));
		return;
	}
	return;
}

public static String find(String s,int m, ArrayList<String>[] table) {
	int hash = hashing(s, m);
	if(table[hash].contains(s)) {
		return "yes";
	}
	return "no";
	}

public static void check(int i,ArrayList<String>[] table ) {
	List list = table[i];
	Iterator it = list.iterator();
	while(it.hasNext()) {
		System.out.print(it.next() + " ");
	}
	System. out. print("\n");
	return;
}
}


