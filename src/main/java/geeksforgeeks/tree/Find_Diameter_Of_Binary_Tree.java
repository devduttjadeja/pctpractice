package geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*

input 
1 2 3 4 5 6 7 8 9 10 11

output
6

 */
public class Find_Diameter_Of_Binary_Tree {

	private static class Node {

		@SuppressWarnings("unused")
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		Node root = constructBinaryTree(line);

		int diameter = getDiameter(root);
		
		System.out.println(diameter);
		
		sc.close();
	}

	private static int getDiameter(Node root) {

		if(root == null) {
			return 0;
		}
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		int leftDiameter = getDiameter(root.left);
		int rightDiameter = getDiameter(root.right);
		
		int maxDiameter = Math.max(leftDiameter, rightDiameter);
		
		return Math.max(leftHeight + rightHeight + 1, maxDiameter);
	}



	private static int getHeight(Node root) {

		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		
	}

	private static Node constructBinaryTree(String input) {

		String[] parts = input.split("\\s+");
		String data = parts[0];

		Queue<Node> nodeQueue = new LinkedList<>();
		Node root = new Node(Integer.parseInt(data));
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {

			Node node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			data = parts[index];
			index++;
			node.left = new Node(Integer.parseInt(data));
			nodeQueue.add(node.left);

			if (index == parts.length) {
				break;
			}

			data = parts[index];
			index++;
			node.right = new Node(Integer.parseInt(data));
			nodeQueue.add(node.right);

		}

		return root;
	}

}
