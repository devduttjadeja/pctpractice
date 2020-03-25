package algo_Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SocratesCow {

	private static Map<String, HashMap<String, Integer>> graph = new HashMap<>();
	private static Map<String,Integer> distanceFromSourceMap = new HashMap<>();
	private static List<String> visitedList = new ArrayList<>();
	private static PriorityQueue<Node> queue = new PriorityQueue<Node>(5);
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int p = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < p; i++) {

			String line = sc.nextLine();
			String[] lineData = line.split("\\s+");

			String strA = lineData[0];
			String strB = lineData[1];
			int distance = Integer.parseInt(lineData[2]);

			addEdgesToGraph(strA,strB,distance);
			
		}
		
		sc.close();
		
		
		// long start = System.currentTimeMillis();
		
		// select source as z
		String source = "z";
		initializeNodes(source);
		
		findShortestPath();
		
		int minValue = Integer.MAX_VALUE;
		String minKey = "";
		
		for (Entry<String, Integer> entry : distanceFromSourceMap.entrySet()) {
			
			String key = entry.getKey();
			int value = entry.getValue();
			
			if(value < minValue && key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') {
				
				minKey = key;
				minValue = value;
				
			}
			
		}
		
		// long end = System.currentTimeMillis();
		
		System.out.println(minKey+" "+minValue);
		
	}

	
	private static void findShortestPath() {

		while (!queue.isEmpty()) {

			Node node = queue.remove();
			visitedList.add(node.getName());

			for (String adjacentNode : graph.get(node.getName()).keySet()) {

				if(!visitedList.contains(adjacentNode)) {
					
					int distV = distanceFromSourceMap.get(adjacentNode);
					int distU = distanceFromSourceMap.get(node.getName());
					int costUV = graph.get(node.getName()).get(adjacentNode);
					
					if(distU + costUV <  distV ) {
						
						queue.remove(new Node(adjacentNode,distV));
						distV = distU + costUV;
						distanceFromSourceMap.put(adjacentNode, distV);
						queue.add(new Node(adjacentNode,distV));
						
						
					}
				}
			}
		}
	}

	private static void initializeNodes(String source) {
		
		for (String node : graph.keySet()) {
			queue.add(new Node(node,source.equals(node) ? 0:Integer.MAX_VALUE));
			distanceFromSourceMap.put(node, source.equals(node) ? 0:Integer.MAX_VALUE);
		}
		
	}

	private static void addEdgesToGraph(String strA, String strB, int distance) {

		if(graph.containsKey(strA)) {
			graph.get(strA).put(strB, distance);
		}else {
			HashMap<String,Integer> keyValueDistanceMap = new HashMap<>();
			keyValueDistanceMap.put(strB, distance);
			graph.put(strA, keyValueDistanceMap);
		}
		
		if(graph.containsKey(strB)) {
			graph.get(strB).put(strA, distance);
		}else {
			HashMap<String,Integer> keyValueDistanceMap = new HashMap<>();
			keyValueDistanceMap.put(strA, distance);
			graph.put(strB, keyValueDistanceMap);
		}
		
	}

	
}


class Node implements Comparable<Node> {
	
	private String name;
	private Integer distanceFromSource;
	
	public Node(String name, int distanceFromSource) {
		this.name = name;
		this.distanceFromSource = distanceFromSource;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistanceFromSource() {
		return distanceFromSource;
	}
	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node other = (Node) obj;
		return name.equals(other.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Node o) {
		return distanceFromSource.compareTo(o.getDistanceFromSource());
	}
}

