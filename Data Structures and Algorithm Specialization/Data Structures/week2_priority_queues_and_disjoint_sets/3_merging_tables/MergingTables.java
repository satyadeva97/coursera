import java.util.*;
public class MergingTables {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		int tables = in.nextInt();
		int max = Integer.MIN_VALUE;
		int operations = in.nextInt();
		int [] rows = new int[tables];
		for(int i = 0; i< tables ;i++) {
			rows[i] = in.nextInt();
				max = Math.max(max, rows[i]);	
		}
		int [] parent = new int[rows.length];
		for(int i =0; i< operations; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			rows = merge(rows,(x-1),(y-1),parent);
			max = Math.max(max, rows[y-1]);
			System.out.println(max);
	//		System.out.println(Arrays.toString(rows));
		}
	//	System.out.println(Arrays.toString(rows));
		
	}
	public static int[] merge(int[] rows, int x, int y, int[] parent) {
		if(x == y) return rows;
		if(parent[y] == 0) {
			parent[y] = -1;	
		}
		parent[x] = y;
		int temp = rows[x];
		rows[x] = 0;
		while(parent[x] != -1) {
			x = parent[x];
		}
		rows[x] += temp;
		return rows;
	}

}
