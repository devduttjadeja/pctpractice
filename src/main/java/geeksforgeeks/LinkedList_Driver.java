package geeksforgeeks;

public class LinkedList_Driver {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();

		list.insertLast(6);
		list.insertFirst(7);
		list.insertFirst(1);
		list.insertLast(4);
		list.insertLast(9);
		list.insertLast(10);
		list.insertLast(11);
		// list = 1 > 7 > 6 > 4
		
		//list.deleteNode(1); // after deleteNode(1) list = 7 > 6 > 4
		
		//list.deleteNode(6); // after deleteNode(6) list = 7 > 4
		
		//list.deleteNodeAt(4); // array index out of bound
		
		
		System.out.println(list.size());
		
		list.printList();
		
		System.out.println(list.detectLoop());

		
	}

}
