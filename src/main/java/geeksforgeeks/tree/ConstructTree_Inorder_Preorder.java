package geeksforgeeks.tree;

import java.util.Scanner;
/*

input 
Inorder sequence: D B E A F C
Preorder sequence: A B D E C F

output
Pre Order -- A B D E C F
In Order -- D B E A F C
Post Order -- B D E C F A 

*/
public class ConstructTree_Inorder_Preorder {

	
	private static int index = 0;
	
	private static class Node{
		
		String data;
		Node left;
		Node right;
		
		Node(String data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] inOrder = sc.nextLine().split("\\s+");
		String[] preOrder = sc.nextLine().split("\\s+");
		
		int startIndex = 0;
		int endIndex = preOrder.length-1;
		
		Node root = constructBinaryTree(inOrder,preOrder,startIndex,endIndex);
		
		System.out.print("Pre Order -- ");
		pre_OrderTraversal(root);
		System.out.print("\nIn Order -- ");
		in_OrderTraversal(root);
		System.out.print("\nPost Order -- ");
		post_OrderTraversal(root);
		
		sc.close();
		
	}

	private static void in_OrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		in_OrderTraversal(root.left);
		System.out.print(root.data + " ");
		in_OrderTraversal(root.right);

	}

	private static void post_OrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		post_OrderTraversal(root.left);
		post_OrderTraversal(root.right);
		System.out.print(root.data + " ");
		
	}

	private static void pre_OrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		pre_OrderTraversal(root.left);
		pre_OrderTraversal(root.right);

	}

	private static Node constructBinaryTree(String[] inOrder, String[] preOrder, int startIndex, int endIndex) {
		
		if(startIndex > endIndex) {
			return null;
		}
		
		Node node = new Node(preOrder[index]);
		index ++;
		
		if(startIndex == endIndex) {
			return node;
		}
		
		int inOrderIndex = findIndexOfNodeFromInOrder(node.data,inOrder,startIndex,endIndex);
		
		node.left = constructBinaryTree(inOrder, preOrder, startIndex, inOrderIndex-1);
		node.right = constructBinaryTree(inOrder, preOrder, inOrderIndex+1, endIndex);
		
		return node;
	}

	private static int findIndexOfNodeFromInOrder(String data, String[] inOrder, int startIndex, int endIndex) {
		
		
		for (int i = startIndex; i <= endIndex; i++) {
			
			if(data.equals(inOrder[i])) {
				return i;
			}
			
		}
		
		return 0;
	}

}
