import java.util.*;

class request1{
	int start_t;
	int process_t;
//	int end_t;
	public request1(int start_t , int process_t){
		this.start_t = start_t;
		this.process_t = process_t;
//		this.end_t = start_t + process_t;
	}
}

public class process_packages {
	static int t=0,u=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int n = in.nextInt();
		ArrayList<request1> input = new ArrayList<request1>();
		for(int i=0 ; i<n ; i++) {
			int start_t = in.nextInt();
			int process_t = in.nextInt();
			input.add(new request1(start_t,process_t));		
		}
		ArrayList<Integer> end = new ArrayList<Integer>();
//		for(u=0;u<size;u++) {
//			que.add(input.get(u));
//		}
		
//		int et = input.get(n-1).end_t;
//		if (et == 0) {
//			for(int i=0; i<n ;i++) {
//				System.out.println(0);
//			}
//			return;
//		}
		
		for(int j =0; j<n ; j++) {
			t = Math.max(input.get(j).start_t, t) ;
		 
		while(!end.isEmpty()) {
				if(end.get(0) <= input.get(j).start_t) {
					end.remove(0);
				}
				else {
					break;
				}
			
			}
		if(end.size() == size) {
			System.out.println(-1);
			continue;
		}
		if(end.isEmpty()) {
			end.add(input.get(j).start_t + input.get(j).process_t);
			System.out.println(t);
			t += input.get(j).process_t;
			continue;
		}
		int last_elem = end.get(end.size()-1);
		end.add(last_elem + input.get(j).process_t);
		System.out.println(t);
		t += input.get(j).process_t;
			
	}
		return;
	}

}
