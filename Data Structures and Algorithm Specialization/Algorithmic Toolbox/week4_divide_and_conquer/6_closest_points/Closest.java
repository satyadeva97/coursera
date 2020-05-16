import java.util.*;
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Closest {
	static  double min =Double.POSITIVE_INFINITY;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		List<Point> a = new ArrayList<Point>();
		for(int i=0;i<n;i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a.add(new Point(x,y));		
		}
		Collections.sort(a,(p,q)-> {
			return p.x-q.x;
	});
/*		Point mid =a.get(n/2);
		List<Point> strip = new ArrayList<Point>();*/
		
		cls(a,0,n-1);
/*		while((a.get(n/2).x-a.get((n/2)-i).x)<min) {
			i++;
		}
		while(a.get((n/2)+j).x-a.get(n/2).x<min) {
			j++;
		}
		i--;j--;
		for(int p=((n/2)-i);p<((n/2)+j);p++){
			strip.add(a.get(p));
		}*/
/*		for(Point p : a) {
			if(Math.abs(p.x-mid.x)<=min) {
				strip.add(p);
			}
		}
		Collections.sort(strip,(l,m)->{
			return l.y-m.y;
		});
		minstrip(strip,0,(strip.size()-1));*/
		System.out.println(min);
/*		Iterator<Point> z= strip.iterator();
		 while(z.hasNext()) {
		 Point b = z.next();
		 System.out.print(b.x);
		 System.out.println(" "+b.y);
		 }*/
		
	}
	public static double cls(List<Point> a,int l, int r) {
		double d1,d2,d;
		if((r-l)<=3) {
			return minimum(a,l,r);	
		};	
		int m= (l+r)/2;
		d1=cls(a,l,m);
		d=cls(a,m+1,r);
		Point mid =a.get(a.size()/2);
		List<Point> strip = new ArrayList<Point>();
		for(Point p : a) {
			if(Math.abs(p.x-mid.x)<=min) {
				strip.add(p);
			}
		}
		Collections.sort(strip,(s,t)->{
			return s.y-t.y;
		});
		minstrip(strip,0,(strip.size()-1));
			
	return d;
}
	public static double minimum(List<Point> a,int l, int r) {
		double d=0;
		int i=l,j=l;
		for(i=l;i<r;i++) {
			int x1 =a.get(i).x;
			int y1 =a.get(i).y;
			for(j=i+1;j<=r;j++) {
				int x2=a.get(j).x;
				int y2 =a.get(j).y;
				if(Math.abs(x1-x2)<=min && Math.abs(y1-y2)<=min ) {
					d=Math.hypot((x1-x2),(y1-y2));
					min=Math.min(min,d);
				}
			}
		}
		return min;
	}
	public static double minstrip(List<Point> strip,int l, int r) {
		double d=0;
		int i=l,j=l;
		for(i=l;i<r;i++) {
			int x1 =strip.get(i).x;
			int y1 =strip.get(i).y;
			for(j=i+1;j<=r;j++) {
				int x2=strip.get(j).x;
				int y2 =strip.get(j).y;
				if(Math.abs(x1-x2)<=min && Math.abs(y1-y2)<=min ) {
					d=Math.hypot((x1-x2),(y1-y2));
					min=Math.min(min,d);
				}
			}
		}
		return min;
	}
	
}

