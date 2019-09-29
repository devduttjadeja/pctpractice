package geeksforgeeks;

public class LinkedList_Insertion {

	/*
	 * Driver program to test above functions. Ideally this function should be in a
	 * separate user class. It is kept here to keep code compact
	 */
	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedList llist = new LinkedList();

		// Insert 6. So linked list becomes 6->NUllist
		llist.insertLast(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.insertFirst(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.insertFirst(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.insertLast(4);

		llist.insertMiddle(llist.head, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();
	}

}
