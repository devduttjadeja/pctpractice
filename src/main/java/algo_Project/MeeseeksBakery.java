package algo_Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeeseeksBakery {

	private static ArrayList<ArrayList<Integer>> queueIDList;
	private static int minPatientLevel;
	private static int count = 0;
	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		queueIDList = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++) {
			
			String[] data = sc.nextLine().split("\\s+");
			
			int sizeOfQueue = Integer.parseInt(data[0]);
			ArrayList<Integer> queue = new ArrayList<>(sizeOfQueue);
					
			for (int j = 1; j <= sizeOfQueue; j++) {
				
				int patientlevel = Integer.parseInt(data[j]);
				queue.add(patientlevel);
				
			}
			
			queueIDList.add(queue);
			
		}

		sc.close();

		// long start = System.currentTimeMillis();
		
		while(!queueIDList.isEmpty()) {
			
			ArrayList<Integer> queue = findQueueHavingCustomerWithMinimumPatienceLevel();
			
			if(queue == null) {
				break;
			}

			if(queue.isEmpty()) {
				queueIDList.remove(queue);
			}
			
		}
		
		
		System.out.println(count);
		
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);
		
	}

	
	private static ArrayList<Integer> findQueueHavingCustomerWithMinimumPatienceLevel() {

		minPatientLevel = Integer.MAX_VALUE;
		int minQueueID = 0;
		int indexOfMin = 0;
		
		for (ArrayList<Integer> queue : queueIDList) {
			
			int min = Collections.min(queue);
			
				if(min < minPatientLevel) {
					minPatientLevel = min;
					indexOfMin = queue.lastIndexOf(min) + 1;
					minQueueID = queueIDList.indexOf(queue);
				}
			
		}
		
		minPatientLevel = minPatientLevel - count;
		ArrayList<Integer> queue = queueIDList.get(minQueueID);
		
		if(indexOfMin > minPatientLevel) {
			count = count + minPatientLevel;
			
			return null;
			
		}
		
		if(indexOfMin <= minPatientLevel) {
			count = count + indexOfMin;
			
			// remove first 'indexOfMin' elements of the queue
			for (int i = 0; i < indexOfMin; i++) {
				queue.remove(0);
			}
			
		}
		

		return queue;
	}
	
	

	
	
	
}
