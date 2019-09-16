package pct.com.practice;

import java.util.Scanner;

public class Lab11_Devdutt_Binary_Tree_Perfect_OR_Not {

	private static int countLeaf = 0;

	/*
	 * 
	 * A Binary tree is Perfect Binary Tree if 
	 * 1) it should have exactly 2^height leaves
	 * 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		
		int numberofNodes = Integer.parseInt(sc.nextLine());
		
		String[] strings = sc.nextLine().split("\\s+");
		
		Node root = null;
		
		for (String data : strings) {
			root = insertNodeIntoTree(root,Integer.parseInt(data));
		}
		
		int heightroot = getHeight(root);
		
		preOrderTraversalToCountLeaves(root);
		
		if(Math.pow(2, heightroot) == countLeaf) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		System.out.println(numberofNodes);
		
		sc.close();
		
	}
	
	



	private static void preOrderTraversalToCountLeaves(Node node) {

		if(node == null) {
			return;
		}
		
		if(isLeaf(node)) {
			countLeaf++;
		}
		
		preOrderTraversalToCountLeaves(node.left);
		preOrderTraversalToCountLeaves(node.right);
		
	}


	private static int getHeight(Node node) {
		
		if(node == null) {
			return -1;
		}
		
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private static boolean isLeaf(Node node) {
		
		return node.left==null && node.right==null;
	}

	private static Node insertNodeIntoTree(Node node, int data) {

		if(node == null) {
			return new Node(data);
		}else {
			
			if(data < node.data) {
				node.left = insertNodeIntoTree(node.left, data);
			}
			if(data > node.data) {
				node.right = insertNodeIntoTree(node.right, data);
			}
			
		}
		
		return node;
	}

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}

}
