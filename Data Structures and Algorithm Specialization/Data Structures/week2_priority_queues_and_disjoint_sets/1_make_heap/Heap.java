import java.util.*;
public class Heap {
	static int count = 0;
	static ArrayList<Integer> b = new ArrayList<Integer>();
	public static int[] siftDown(int [] a, int i) {
		if(right(i) <= a.length) {
		int min = i;
		if(a[left(i)] < a[min]) {
			min = left(i);
			
		}
		if(right(i) < a.length) {
		if(a[right(i)] < a[min]) {
			min = right(i);
			
		}
		}
		if(a[min] != a[i]) {
			swap(a, min , i);
			b.add(i);
			b.add(min);
			count++;
			siftDown(a , min);
		}
		}
		return a;
	}

	public static int left(int i) {
		return 2*i+1;
	}
	public static int right(int i) {
		return 2*i+2;
	}
	public static int[] swap(int [] a, int x, int y) {
		int temp = a[y];
		a[y] = a[x];
		a[x] = temp;
		return a;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++ ) {
			a[i] = in.nextInt();
		}
		int x = n%2 == 0 ? ((n-3)/2)+1 : (n-3)/2;
		for(int i = x; i>= 0; i--) {
			siftDown(a,i);
		}
		System.out.print(count);
		int s = b.size();
		for(int i = 0; i < s; i++) {
			if(i % 2 == 0) {
				System.out.print("\n");
			}
			System.out.print(b.get(i) + " ");
		}
		
		
	}
}
