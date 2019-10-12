package pct.com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
input
8
Motilal Jawahar
Jawahar Indira
Motilal Kamala
Indira Sanjay
Sanjay Varun
Indira Rajiv
Rajiv Priyanka
Rajiv Rahul
6
Motilal child Jawahar
Varun descendant Indira
Priyanka sibling Varun
Sanjay child Indira
Sanjay ancestor Varun
Kamala ancestor Rahul

output
F T F T T F
Motilal Jawahar Indira Sanjay Varun Rajiv Priyanka Rahul Kamala
 

input
9
Prithviraj Raj
Shashi Sanjana
Prithviraj Shashi
Raj Randhir
Rishi Ranveer
Randhir Bebo
Randhir Lolo
Raj Rishi
Rishi Ridhima
7
Bebo descendant Shashi
Raj sibling Shashi
Prithviraj ancestor Ridhima
Lolo sibling Ridhima
Bebo ancestor Shashi
Prithviraj ancestor Raj
Rishi descendant Raj

output
F T T F F T T
Prithviraj Raj Randhir Bebo Lolo Rishi Ridhima Shashi

*/


public class Lab7_Devdutt_Family_Tree {

	
	static Map<String,ArrayList<String>> map = new LinkedHashMap<>();
	//static boolean ancestorFound;
	//static boolean descendantFound;
	static StringBuilder sbPreorderString = new StringBuilder();
	static Set<String> allnodes = new HashSet<>();
	static List<String> childList = new ArrayList<>();
	static boolean isrelated;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String rootnode = null;
		int numberOfInputs = Integer.parseInt(sc.nextLine());
		StringBuilder sbBoolen = new StringBuilder();
		
		
		// create family map
		for(int i = 0; i < numberOfInputs; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			if(i == 0) {
				rootnode = strings[0];
				allnodes.add(strings[0]);
				allnodes.add(strings[1]);
			}
			
			addToFamilyMap(strings[0],strings[1],map);
			
			
		}
		
		// print map
		//System.out.println(map);
		
		
		// create family tree
		Node7 root = new Node7(rootnode);
		createFamilyTree(root,map);

		
		int numberOfRelations = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numberOfRelations; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			String strBoolean = checkRelation(strings[0],strings[1],strings[2],root,map);
			sbBoolen.append(strBoolean).append(" ");
		}
		
		
		System.out.println(sbBoolen.toString().trim());
		
		preOrderTraverse(root);
		
		System.out.println(sbPreorderString.toString().trim());
		
		sc.close();
		
	}

	
	
	
	private static void preOrderTraverse(Node7 root) {

		if(root == null) {
			return;
		}else {

			sbPreorderString.append(root.data).append(" ");
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
			
		}
		
		
	}




	private static String checkRelation(String strA, String relation, String strB, Node7 root,
			Map<String, ArrayList<String>> map) {
		
		String strBoolean = "F";

		// Motilal child Jawahar
		if(relation.equals("child")) {
			
			for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
				if(entry.getKey().equalsIgnoreCase(strB) 
						&& entry.getValue().contains(strA)) {
					
					strBoolean = "T";
				}
			}
			
		} else if(relation.equals("sibling")){
			//Priyanka sibling Varun
			
			for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
				
				ArrayList<String> arrayList = entry.getValue();
				
				if(arrayList.contains(strA) 
						&& arrayList.contains(strB)) {
					strBoolean = "T";
				}
				
			}
		} else if(relation.equals("descendant")){
			//Varun descendant Indira
			preorderTraverse(strA,strB,root);
			childList.clear();
			
			if(isrelated) {
				strBoolean = "T";
				isrelated = false;
			}
			
		} else if(relation.equals("ancestor")){
			
			preorderTraverse(strB,strA,root);
			childList.clear();
			
			if(isrelated) {
				strBoolean = "T";
				isrelated = false;
			}
		}
		
		return strBoolean;
	}




	private static void preorderTraverse(String descendant, String ancestor, Node7 root) {

		if(root == null) {
			return;
		}else {
			
			if(ancestor.equals(root.data)) {
				
				getAllChildOfAncestor(root);
				
				if(childList.contains(descendant)) {
					isrelated = true;
				}
			}
			
			preorderTraverse(descendant, ancestor, root.left);
			preorderTraverse(descendant, ancestor, root.right);
		}
	}




	private static void getAllChildOfAncestor(Node7 root) {

		if(root == null) {
			return;
		}else {

			childList.add(root.data);
			getAllChildOfAncestor(root.left);
			getAllChildOfAncestor(root.right);
			
		}
		
	}




	private static void createFamilyTree(Node7 root, Map<String, ArrayList<String>> map) {

		if(root == null) {
			return;
		}
		
		if(map.containsKey(root.data)) {
			
			ArrayList<String> child = map.get(root.data);
			
			if(child.size() == 1) {
				root.left = new Node7(child.get(0));
			}else {
				root.left = new Node7(child.get(0));
				root.right = new Node7(child.get(1));
			}
			
			createFamilyTree(root.left, map);
			createFamilyTree(root.right, map);
			
		}
		
		
		
	}

	
	
	
	private static void addToFamilyMap(String string0, String string1, Map<String, ArrayList<String>> map) {
		
		if(map.containsKey(string0)) {
			
			map.get(string0).add(string1);
			allnodes.add(string1);
		}else {
			
			if(allnodes.contains(string0)) {
				ArrayList<String> al = new ArrayList<String>();
				al.add(string1);
				map.put(string0,al);
				allnodes.add(string1);
			}
			
		}
	}
	
	
}


class Node7 {
	
	String data;
	Node7 left;
	Node7 right;
	
	Node7(String data){
		this.data = data;
		left = null;
		right = null;
	}
	
}