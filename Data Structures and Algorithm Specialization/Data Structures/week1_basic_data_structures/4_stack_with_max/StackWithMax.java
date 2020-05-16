import java.util.*;
import java.io.*;

public class StackWithMax {
//    class FastScanner {
//        StringTokenizer tok = new StringTokenizer("");
//        BufferedReader in;
//
//        FastScanner() {
//            in = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() throws IOException {
//            while (!tok.hasMoreElements())
//                tok = new StringTokenizer(in.readLine());
//            return tok.nextToken();
//        }
//        int nextInt() throws IOException {
//            return Integer.parseInt(next());
//        }
//    }
    
    public void solve() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(0);
        
        for (int qi = 0; qi < queries; ++qi) {
        	
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
                if(value >= temp.peek()) {
  //              	max = value;
                	temp.push(value);
                }
            } else if ("pop".equals(operation)) {
            	if(stack.peek() == temp.peek()) {
            		temp.pop();
  //          		max = temp.peek();
            	}
                stack.pop();
                
                
            } else if ("max".equals(operation)) {
            	System.out.print("\n");
                System.out.print(temp.peek());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
