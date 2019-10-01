package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

class LinkedList {

	// head of list
	Node head;

	/* Inserts a new Node at front of the list. */
	public void insertFirst(int data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node newNode = new Node(data);

		/* 3. Make next of new Node as head */
		newNode.next = head;

		/* 4. Move the head to point to new Node */
		head = newNode;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertMiddle(Node prev_node, int data) {
		/* 1. Check if the given Node is null */
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		/*
		 * 2 & 3: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}

	/*
	 * Appends a new node at the end. This method is defined inside LinkedList class
	 * shown above
	 */
	public void insertLast(int data) {
		
		// If the Linked List is empty, then make the new node as head
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		// Allocate the Node & 2. Put in the data 3. Set next as null
		Node new_node = new Node(data);

		// 5. Else traverse till the last node
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		
		/* 6. Change the next of last node */
		last.next = new_node;
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
	
	public void deleteNode(int data) {

		Node temp = head;
		Node previous = null;
		
		// if the head contains data
		if (temp != null && temp.data == data) {
			head = temp.next;
			temp = null;
			return;
		}
		
		// if the data is in middle node
		while(temp != null && temp.data != data) {
			previous = temp;
			temp = temp.next;
		}

		// if data not present in LinkedList
		if(temp == null) {
			System.out.println(data+"not present in LinkedList");
			return;
		}
		
		// if data found at temp.next
		if(temp.data == data) {
			previous.next = temp.next;
			temp = null;		
		}
		
		
	}
	
	
	public void deleteNodeAt(int position) {
		
		if(head == null) {
			return;
		}
		
		Node temp = head;
		Node previous = null;
		
		// if position = 0 , remove head
		if(position == 0) {
			head = temp.next;
			temp = null;
			return;
		}
		
		// if position > 0
		while(temp != null && position > 0) {
			previous = temp;
			temp = temp.next;
			position--;
		}
		
		// if entire list is traversed but still position is not 0 then array index out of bound
		if(temp == null) {
			System.out.println("array index out of bound");
			return;
		}
		
		if(temp != null) {
			previous.next = temp.next;
			temp = null;
		}
		
	}
	
	public int size() {
		
		int length = 0;
		Node temp = head;
		
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		
		return length;
	}
	
	
	public boolean detectLoop() {
		
		List<Integer> al = new ArrayList<>();
		
		Node temp = head;
		
		while(temp != null) {
			
			if(al.contains(temp.data)) {
				return true;
			}
			al.add(temp.data);
			temp = temp.next;
			
		}
		
		
		return false;
	}
	
	
	
	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

}
