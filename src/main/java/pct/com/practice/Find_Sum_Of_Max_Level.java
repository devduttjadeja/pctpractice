package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


/*
 
input
9
1 2 5 3 6 4 -10 7 8

level traversal : 1 -10 2 5 3 6 4 7 8 
maps of height and nodes : {1=[8], 2=[4, 7], 3=[3, 6], 4=[5], 5=[-10, 2], 6=[1]}

output
11
 
 */
public class Find_Sum_Of_Max_Level {

	private static int maxSum = 0;
	private static Map<Integer,ArrayList<Integer>> mapHeightNodes = new HashMap<>();

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		Node root = null;
		
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		
		levelOrder(root);
		
		int height = getHeight(root);
		
		preOrderTraversalAndCreateMapHeightNodes(height,root);
		
		System.out.println(mapHeightNodes);
			
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : mapHeightNodes.entrySet()) {
			
			entry.getKey();
			int sum = findSum(entry.getValue());
			
			if(sum > maxSum) {
				maxSum = sum;
			}
			
		}
		
		System.out.println(maxSum);
		
		scan.close();
		
	}



	
	private static int findSum(ArrayList<Integer> values) {

		int sum = 0;
		
		for (Integer integer : values) {
			
			sum = sum + integer;
		}
		
		return sum;
	}




	private static void preOrderTraversalAndCreateMapHeightNodes(int height, Node node) {

		if(node == null) {
			return;
		} else {
			
			if(mapHeightNodes.containsKey(height)) {
				mapHeightNodes.get(height).add(node.data);
			}else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(node.data);
				mapHeightNodes.put(height,al);
			}
				
			
			preOrderTraversalAndCreateMapHeightNodes(height-1, node.left);
			preOrderTraversalAndCreateMapHeightNodes(height-1, node.right);
			
			
		}
		
		
		
	}

	private static void levelOrder(Node root) {
	
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

	private static int getHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		
	}

	private static Node insert(Node root, int data) {
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
}
