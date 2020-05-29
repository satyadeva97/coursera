import java.util.*;

class Node {
	long key;
	int left_index;
	int right_index;

	Node(long a, int b, int c) {
		this.key = a;
		this.left_index = b;
		this.right_index = c;
	}
}

public class Traversals {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_of_nodes = in.nextInt();
		Node[] tree = new Node[num_of_nodes];
		Node[] tree_temp1 = new Node[num_of_nodes];
		Node[] tree_temp2 = new Node[num_of_nodes];
		for (int i = 0; i < num_of_nodes; i++) {
			int key = in.nextInt();
			int left = in.nextInt();
			int right = in.nextInt();
			 
			tree[i] = new Node(key, left, right);
			tree_temp1[i] = new Node(key, left, right);
			tree_temp2[i] = new Node(key, left, right);
		}
		
		inorder_I(tree_temp1[0], tree_temp1);
		System.out.print("\n");
		preorder_I(tree_temp2[0], tree_temp2);
		System.out.print("\n");
		postorder_I(tree[0], tree);
	}

//	private static void inorder(Node node, Node[] tree) {
//
//		if (node.left_index != -1) {
//			inorder(tree[node.left_index], tree);
//		}
//		System.out.print(node.key + " ");
//		if (node.right_index != -1) {
//			inorder(tree[node.right_index], tree);
//		}
//	}
	
	private static void inorder_I(Node node, Node[] tree) {
		Node current = node;
		Stack< Node > st = new Stack< Node >();
		while(true) {
			if(current.left_index != -1) {
				st.add(current);
				current = tree[current.left_index];
			}
			else {
				System.out.print(current.key + " ");
				
				if( current.right_index != -1) {
					current = tree[current.right_index];
				}
				
				else {
					if (st.empty()) return;
					Node temp = st.pop();
					temp.left_index = -1;
					current = temp;
				}
				
			}
		}
	}
	
	private static void preorder_I(Node node, Node[] tree) {
		Node current = node;
		Stack< Node > st = new Stack< Node >();
		while(true) {
			System.out.print(current.key + " ");
			if(current.left_index != -1) {
				st.add(current);
				current = tree[current.left_index];
			}
			else {
				
				if( current.right_index != -1) {
					current = tree[current.right_index];
				}
				
				else {
					if (st.empty()) return;
					Node temp = st.pop();
					while( temp.right_index == -1) {
						if (st.empty()) return;
						temp = st.pop();
					}
					temp.left_index = -1;
					current = tree[temp.right_index];
				}
				
			}
		}
	}

//	private static void preorder(Node node, Node[] tree) {
//
//		System.out.print(node.key + " ");
//		if (node.left_index != -1) {
//			preorder(tree[node.left_index], tree);
//		}
//		if (node.right_index != -1) {
//			preorder(tree[node.right_index], tree);
//		}
//	}
	
	private static void postorder_I(Node node, Node[] tree) {
		Node current = node;
		Stack< Node > st = new Stack< Node >();
		while(true) {
			
			if(current.left_index != -1) {
				st.add(current);
				current = tree[current.left_index];
				st.peek().left_index = -1;
			}
			else {
				
				if( current.right_index != -1) {
					st.add(current);
					current = tree[current.right_index];
					st.peek().right_index = -1;
				}
				
				else {
					System.out.print(current.key + " ");
					if (st.empty()) return;
					if(st.peek().right_index != -1) {
						current = tree[st.peek().right_index];
						st.peek().right_index = -1;
					}
					else {
					Node temp = st.pop();
					current = temp;
					}
				}
				
			}
		}
	}
	

//	private static void postorder(Node node, Node[] tree) {
//
//		if (node.left_index != -1) {
//			postorder(tree[node.left_index], tree);
//		}
//		if (node.right_index != -1) {
//			postorder(tree[node.right_index], tree);
//		}
//		System.out.print(node.key + " ");
//	}

}
