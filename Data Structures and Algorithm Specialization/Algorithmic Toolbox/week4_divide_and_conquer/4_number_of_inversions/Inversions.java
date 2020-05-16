import java.util.*;

public class Inversions {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] a=new int[n];
	int sum=0;
	ArrayList<Integer> b= new ArrayList<Integer>();
	for(int i=0;i<n;i++) {
		a[i] = in.nextInt();
	}
	inversion(a,0,n-1,b);
	for(int y : b) {
		sum=sum+y;
	}
	System.out.println(sum);
/*	for(int x : a) {
		System.out.print(x);
	}*/
	
	}
	

private static void inversion( int []a,int l,int r,ArrayList<Integer> b) {
	
	if(l>=r) {
		return;
	}
	int m=(r+l)/2;
	inversion(a,l,m,b);
	inversion(a,m+1,r,b);
	merge(a,m,l,r,b);
	
	
	
}

private static void  merge(int[] a, int m,int l, int r,ArrayList<Integer> b){
	int temp[] = new int[r-l+1];
	
	int left =l;
	int i =0;
	int right =m+1;
	while(left<=m && right<=r) {
		if(a[left]<=a[right]) {
			temp[i]=a[left];
			left++;
		}
		else {
			temp[i]=a[right];
			b.add(m-left+1);
			right++;
			
		}
		i++;	
	}
	while(left<=m) {
		temp[i]=a[left];
		left++;
		i++;
	}
	while(right<=r) {
		temp[i]=a[right];
		right++;
		i++;
	}
	for(int x : temp) {
		a[l]=x;
		l++;
	}
	
	
/*	ArrayList<Integer> t = new ArrayList<Integer>();
	
	int s =b.size();
	for(int i=l;i<r+1;i++) {
		t.add(a.get(i));
	}
	int rightStart =m+1;
	int left =l;
	int right =rightStart;
	int index = l;
	while(left<=m && rightStart <=r) {
		if(t.get(left)<=t.get(right)) {
			b.add(t.get(left));
			t.remove(left);
			a.remove(left);
			m--;
		}else {
			b.add(t.get(right));
			t.remove(right);
			a.remove(right);
			r--;
		}
	}
	for(int x: t) {
		b.add(x);
		}
	return;*/



		}
}

