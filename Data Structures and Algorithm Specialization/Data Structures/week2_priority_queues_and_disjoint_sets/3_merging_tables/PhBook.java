import java.util.*;
public class PhBook {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in); 	
	int n = in.nextInt();
	Map<Integer , String> h = new HashMap<Integer, String >();
	for(int i = 0; i < n; i++) {
		String input = in.next();
		if(input.equals("add")) {
			h.put(in.nextInt(), in.next());
		}
		else if(input.equals("find")) {
			int inp1 = in.nextInt();
			if(h.containsKey(inp1)) {
				 System.out.println(h.get(inp1)); 
			}
			else {
				System.out.println("not found");
			}
		}
		else {
			int inp2 = in.nextInt();
			if(h.containsKey(inp2)) {
				 h.remove(inp2); 
			}		
		}
	}
	}

}
