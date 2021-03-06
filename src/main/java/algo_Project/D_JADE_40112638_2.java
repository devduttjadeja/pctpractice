package algo_Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class D_JADE_40112638_2 {

	private static ArrayList<String> vertexList;
	private static Map<String,ArrayList<String>> graph = new HashMap<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long count = 0;
		long prime = 1000000007;
		int n = Integer.parseInt(sc.nextLine());
		
		vertexList = new ArrayList<String>(n);
		
		
		for (int i = 0; i < n; i++) {
			vertexList.add(sc.nextLine());
		}
		
		
		for (int i = 0; i < vertexList.size(); i++) {
		
			String[] vertexU = vertexList.get(i).split("\\s+");
			String u = vertexList.get(i);
			int lU = Integer.parseInt(vertexU[0]);
			int rU = Integer.parseInt(vertexU[1]);
			
			if(!graph.containsKey(u)) {
				ArrayList<String> al = new ArrayList<String>();
				graph.put(u, al);
			}
			
			
			for (int j = i+1; j < vertexList.size(); j++) {
				
				String[] vertexV = vertexList.get(j).split("\\s+");
				String v = vertexList.get(j);
				int lV = Integer.parseInt(vertexV[0]);
				int rV = Integer.parseInt(vertexV[1]);
				
				if(Math.max(lU, lV) <= Math.min(rU, rV)) {
					addEdgeToGraph(u,v);
				}
				
			}
		}

		sc.close();
		
		// long start = System.currentTimeMillis();
		
		double numberofsubsets = Math.pow(2, n);
		
		for (long i = 0; i < numberofsubsets ; i++) {
			
			ArrayList<String> subset = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				
				if( (i & (1 << j))  > 0) {
					subset.add(vertexList.get(j));
				}

			}
			
			if(checkSubsetIsDominating(subset)) {
				count++;
				// System.out.println(subset);
			}
			
		}
  
        System.out.println(count % prime); 
        // System.out.println("check for base case when no edges");
        // long end = System.currentTimeMillis();
        // System.out.println(end-start);
		
	}

	
	private static boolean checkSubsetIsDominating(ArrayList<String> subset) {
		
		Set<String> adjacentVertex = new HashSet<>();
		
		for (String element : subset) {
			
			adjacentVertex.add(element);
			
			for (String vertex : graph.get(element)) {
				adjacentVertex.add(vertex);
			}
			
		}
		
		return adjacentVertex.size() == vertexList.size();
	}

	private static void addEdgeToGraph(String vertexU, String vertexV) {
		
		if(graph.containsKey(vertexU)) {
			graph.get(vertexU).add(vertexV);
		}else {
			ArrayList<String> al = new ArrayList<String>();
			al.add(vertexV);
			graph.put(vertexU, al);
		}
		
		if(graph.containsKey(vertexV)) {
			graph.get(vertexV).add(vertexU);
		}else {
			ArrayList<String> al = new ArrayList<String>();
			al.add(vertexU);
			graph.put(vertexV, al);
		}
		
	}

	
}
