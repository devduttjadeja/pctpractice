package geeksforgeeks;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String args[]) {

        // Creating empty priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pq.add(100);
        pq.add(20);
        pq.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pq.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pq.poll());

        // Printing the top element again
        System.out.println(pq.peek());

    }

}
