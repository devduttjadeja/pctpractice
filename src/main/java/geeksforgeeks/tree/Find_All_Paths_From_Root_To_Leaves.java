package geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
input
A B C D E F G

output

*/
public class Find_All_Paths_From_Root_To_Leaves {

	private static List<String> path = new ArrayList<>();
	
	
	private static class Node {

		String data;
		Node left;
		Node right;

		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		Node root = constructBinaryTree(line);
		
		findAllPathsFromToLeaves(root); // same as pre order
		
		
		sc.close();

	}

	private static void findAllPathsFromToLeaves(Node node) {

		if(node == null) {
			return;
		}
		
		path.add(node.data);

		
		/* if you find the leaf node then 
		 * 1) print the path
		 */ 
		if(node.left == null && node.right == null) {
			System.out.println(path);
		}
		
		findAllPathsFromToLeaves(node.left);
		findAllPathsFromToLeaves(node.right);
		
		path.remove(node.data); // remove node while backtracking
		
	}

	private static Node constructBinaryTree(String line) {

		String[] parts = line.split("\\s+");
		
		String data = parts[0];
		Node root = new Node(data);
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		int index = 1;
		
		while(!queue.isEmpty()) {
			
			Node node = queue.remove();
			
			if(index == parts.length) {
				break;
			}
			
			data = parts[index];
			index++;
			node.left = new Node(data);
			queue.add(node.left);
			
			if(index == parts.length) {
				break;
			}
			
			data = parts[index];
			index++;
			node.right = new Node(data);
			queue.add(node.right);
			
		}
		
		
		return root;
	}

}
