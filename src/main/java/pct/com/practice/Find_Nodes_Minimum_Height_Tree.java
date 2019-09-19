package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*

input
4
3
1 0
1 2
1 3

output
[1]

input
6
5
0 3
1 3
2 3
4 3
5 4

output
[3, 4]

*/
public class Find_Nodes_Minimum_Height_Tree {

	private static Map<String,ArrayList<String>> map = new HashMap<>();
	private static List<String> listLeaf = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numberOfVertices = Integer.parseInt(sc.nextLine());
		int numberofEdges = Integer.parseInt(sc.nextLine()); 
		
		for (int i = 0; i < numberofEdges; i++) {
			
			String[] strings = sc.nextLine().split("\\s+");
			
			addEdgesToGraph(strings[0],strings[1]);
			
			
		}
		
		System.out.println(map);
		
		findLeafInMap();
		
		listLeaf = getListMHT(numberOfVertices);
		
		System.out.println(listLeaf);
		System.out.println(numberOfVertices);
		
		sc.close();
	}
	
	private static List<String> getListMHT(int numberOfVertices) {

		while( numberOfVertices > 2) {
			
			numberOfVertices = numberOfVertices - listLeaf.size();
			
			// remove leaf from map and clear listLeaf
			removeLeafFromGraphTreeMap();
			
			// find new leaves and add to listLeaf
			findLeafInMap();
			
		}
		
		return listLeaf;
	}

	private static void removeLeafFromGraphTreeMap() {

		for (String leaf : listLeaf) {
			
			if(map.containsKey(leaf)) {
				String value = map.get(leaf).get(0);
				map.remove(leaf);
				map.get(value).remove(leaf);
			}
		}
		
		listLeaf.clear();
		
	}

	private static void findLeafInMap() {
		
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			
			if(entry.getValue().size() == 1
					|| entry.getValue().size() == 0) {
				listLeaf.add(entry.getKey());
			}
			
		}
		
	}

	private static void addEdgesToGraph(String stra, String strb) {

		if(map.containsKey(stra)) {
			map.get(stra).add(strb);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(strb);
			map.put(stra, al);
		}
		
		
		if(map.containsKey(strb)) {
			map.get(strb).add(stra);
		}else {
			ArrayList<String> al = new ArrayList<>();
			al.add(stra);
			map.put(strb, al);
		}
		
	}

}
