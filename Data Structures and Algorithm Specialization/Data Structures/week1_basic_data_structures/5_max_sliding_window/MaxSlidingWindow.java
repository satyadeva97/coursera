import java.util.*;
public class MaxSlidingWindow {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Deque<Integer> que = new LinkedList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			temp.add(input.nextInt());
		}
		int p = input.nextInt();
		int i=0;
		for( i=0;i<p;i++) {
			while(que.size()>0 && temp.get(i)>temp.get(que.peekLast())) {
				que.removeLast();
			}
			que.addLast(i);
		}
		for(; i<n; i++) {
			System.out.print(temp.get(que.peekFirst())+" ");
			while(que.size() > 0 && que.peek() <= (i-p)) {
				que.removeFirst();
			}
			while(que.size()>0 && temp.get(i)>temp.get(que.peekLast())) {
				que.removeLast();
			}
		que.addLast(i);
		}
		System.out.println(temp.get(que.peekFirst()));
		

	}

}
