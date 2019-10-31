package geeksforgeeks.tree;

import java.util.Scanner;
/*

input
In Order -- D B E A F C 
Post Order -- D E B F C A 

output
Pre Order -- A B D E C F 
In Order -- D B E A F C 
Post Order -- D E B F C A 

*/
public class ConstructTree_Inorder_Postorder {

	
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
		String[] postOrder = sc.nextLine().split("\\s+");
		
		int startIndex = 0;
		int endIndex = postOrder.length-1;
		index = endIndex;
		
		Node root = constructBinaryTree(inOrder,postOrder,startIndex,endIndex);
		
		System.out.print("Pre Order -- ");
		preOrderTraverse(root);
		System.out.print("\nIn Order -- ");
		inOrderTraversal(root);
		System.out.print("\nPost Order -- ");
		postOrderTraverse(root);
		
		sc.close();
		
	}

	private static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);

	}

	private static void postOrderTraverse(Node root) {
		if (root == null) {
			return;
		}
		
		postOrderTraverse(root.left);
		postOrderTraverse(root.right);
		System.out.print(root.data + " ");
		
	}

	private static void preOrderTraverse(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);

	}

	private static Node constructBinaryTree(String[] inOrder, String[] postOrder, int startIndex, int endIndex) {
		
		if(startIndex > endIndex) {
			return null;
		}
		
		Node node = new Node(postOrder[index]);
		index --;
		
		if(startIndex == endIndex) {
			return node;
		}
		
		int inOrderIndex = findIndexOfNodeFromInOrder(node.data,inOrder,startIndex,endIndex);
		
		node.right = constructBinaryTree(inOrder, postOrder, inOrderIndex+1, endIndex);
		node.left = constructBinaryTree(inOrder, postOrder, startIndex, inOrderIndex-1);
		
		
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
