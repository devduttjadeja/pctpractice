package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*

link -- https://www.hackerrank.com/challenges/kindergarten-adventures/problem

input
3
0 1 2

output
1

input
9
0 5 5 5 5 10 10 10 8

output
??



*/
public class Array_Kindergarten_Adventures {


	private static int solve(int[] t) {

		Map<Integer,Integer> map = new HashMap<>();
		
		// convert to List
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < t.length; i++) {
			al.add(t[i]);
		}

		// rotate al size times and pass to the method and get the number of students
		// that will complete drawings

		for (int i = 0; i < al.size(); i++) {
			
			int complete = 0;
			
			for (int j = 0; j < al.size(); j++) {

				if (al.get(j) == 0 || j >= al.get(j)) {
					complete++;
				}

			}
			
			Collections.rotate(al, -1); // rotate to the left
			map.put(i, complete);
		}
		
		int max = 0;
		int maxindex = 0;
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(entry.getValue() > max) {
				max = entry.getValue();
				maxindex = entry.getKey();
			}
			
			
		}
		
		int position = maxindex + 1;

		return position;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tCount = Integer.parseInt(scanner.nextLine().trim());

        int[] t = new int[tCount];

        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);

        System.out.println(id);
        
    }


}
