import java.util.*;

class Node {
	long key;
	int left;
	int right;

	Node(long a, int b, int c) {
		this.key = a;
		this.left = b;
		this.right = c;
	}
}

public class Check_BST {
	
	static long prev = Long.MIN_VALUE;
	private static void inorder(Node node, Node[] tree) {
		Node current = node;
		Stack< Node > st = new Stack< Node >();
		while(true) {
			if(current.left != -1) {
				st.add(current);
				if( current.key == tree[current.left].key) {
					System.out.println("INCORRECT");
					return;
				}
				current = tree[current.left];
				st.peek().left = -1;
			}
			else {
//				System.out.print(current.key + " ");
				if(current.key >= prev) prev = current.key;
				else {
					System.out.println("INCORRECT");
					return;
				}
				
				if( current.right != -1) {
					current = tree[current.right];
				}
				
				else {
					if (st.empty()) {
						System.out.println("CORRECT");
						return;
					}
					Node temp = st.pop();
//					temp.left_index = -1;
					current = temp;
				}
				
			}
		}
	}
	
//	private  boolean inorder(Node node, Node[] tree) {
//       
//		if (node.left != -1) {
//			
//			if(!inorder(tree[node.left], tree)){
//				return false;
//			};
//		}
//		if(node.key > prev) {
//			prev = node.key;
//		}
//		else {
////			System.out.println("INCORRECT");
//			return false;
//		}
//		
//		if (node.right != -1) {
//			return inorder(tree[node.right], tree);
//		}
//		return true;
//        
//     
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_of_nodes = in.nextInt();
		if(num_of_nodes == 0) {
			System.out.println("CORRECT");
			return;
		}
		Node[] tree = new Node[num_of_nodes];
		for (int i = 0; i < num_of_nodes; i++) {
			tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
		}
		Check_BST obj = new Check_BST();
		inorder(tree[0], tree);
//		if(obj.inorder(tree[0], tree)) {
//			System.out.println("CORRECT");
//		}
//		else {
//			System.out.println("INCORRECT");
//		}
	}
}
