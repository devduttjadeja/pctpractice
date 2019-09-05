package pct.com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//4 2 6 3 5 7 1 -1
//7 5 8 3 12 23 9 27 55 33 2 -1
//5 2 12 1 3 9 17 15 19 -1
public class Lab4_Devdutt_Tree_AVL_PreOrder {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		String[] bstArray = line.split(" ");

		List<Integer> alData = new ArrayList<Integer>();
		
		for (String data : bstArray) {
			alData.add(Integer.parseInt(data));
		}
				
		Node root = null;
		
		/* constructing the BST */
		for (Integer data : alData) {
			
			if(data == -1) {
				break;
			}
			root = addNodeToTree(root,data);
		}
		
		
		
		if(isAVL(root)) {
			traversPreOrder(root);
			System.out.println(sb.toString());
		} else {
			System.out.println("NOT");
		}
		
		sc.close();
	}

	
	
	
	private static boolean isAVL(Node root) {

		if(root == null) {
			return true;
		}
		
		int leftSubTreeHeight = getHeight(root.left);
		int rightSubTreeHeight = getHeight(root.right);
		
		
		if(Math.abs(leftSubTreeHeight-rightSubTreeHeight) <= 1 
				&& isAVL(root.left) 
				&& isAVL(root.right) ) {
			return true;
		}
		
		return false;
	}




	private static int getHeight(Node node) {

		if(node == null) {
			return 0;
		}
		
		return 1 + Math.max(getHeight(node.left),getHeight(node.right));
	}




	private static void traversPreOrder(Node root) {

		if(root == null) {
			return;
		}else {
			//System.out.println(""+root.data+" ");
			sb.append(String.valueOf(root.data)+" ");
			traversPreOrder(root.left);
			traversPreOrder(root.right);
		}
	}




	private static Node addNodeToTree(Node node, int data) {

		if(node == null) {
			return new Node(data);
		}
		
		if(data < node.data) {
			node.left = addNodeToTree(node.left, data);
		} else if (data > node.data) {
			node.right = addNodeToTree(node.right, data);
		}
		
		return node;
		
	}
	
	
	
}


class Node {
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
	
}
