package pct.com.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 
input
6
1 2 5 3 6 4

output
1 2 5 3 6 4
 
 */
public class Find_Level_Order_Traversal {

	public static void levelOrder(Node root) {

		if (root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (q.peek() != null) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}
}
