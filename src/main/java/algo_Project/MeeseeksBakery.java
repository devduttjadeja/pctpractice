package algo_Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MeeseeksBakery {

	private static ArrayList<LinkedList<Integer>> queueIDList;
	private static int minPatientLevel;
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		long start = System.currentTimeMillis();
		
		int count = 0;
		queueIDList = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			
			String[] data = sc.nextLine().split("\\s+");
			
			int sizeOfQueue = Integer.parseInt(data[0]);
			LinkedList<Integer> queue = new LinkedList<>();
					
			for (int j = 1; j <= sizeOfQueue; j++) {
				
				int patientlevel = Integer.parseInt(data[j]);
				queue.add(patientlevel);
				
			}
			
			queueIDList.add(queue);
			
		}

		sc.close();

		
		while(!queueIDList.isEmpty()) {
			
			LinkedList<Integer> queue = findQueueHavingCustomerWithMinimumPatienceLevel();
			
			if(count >= minPatientLevel) {
				break;
			}
			
			count++;
			
			queue.removeFirst();

			if(queue.isEmpty()) {
				queueIDList.remove(queue);
			}
			
		}
		
		
		System.out.println(count);
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}

	
	private static LinkedList<Integer> findQueueHavingCustomerWithMinimumPatienceLevel() {

		minPatientLevel = Integer.MAX_VALUE;
		int minQueueID = 0;
		
		for (LinkedList<Integer> queue : queueIDList) {
			
			int min = Collections.min(queue);
			
				if(min < minPatientLevel) {
					minPatientLevel = min;
					minQueueID = queueIDList.indexOf(queue);
				}
			
		}

		return queueIDList.get(minQueueID);
	}
	
	

	
	
	
}
