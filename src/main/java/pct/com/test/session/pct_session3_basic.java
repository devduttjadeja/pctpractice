package pct.com.test.session;

import java.util.Scanner;


/*

Input:
1
1
50 20 60
30 40 80

Output:
1


Input:
2
2
25 25 80
75 25 80
25 25 80
75 25 80

Output:
4

Input:
1
2
50 0 100
50 0 75
50 25 100

Output:
2

*/
public class pct_session3_basic {

	private static int intersections = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberofverticlelines = Integer.parseInt(sc.nextLine());
		int numberofhorizontallines = Integer.parseInt(sc.nextLine());

		int[][] verlines = new int[numberofverticlelines][3];
		int[][] horlines = new int[numberofhorizontallines][3];
		
		for (int i = 0; i < numberofverticlelines; i++) {
			
			String[] arr = sc.nextLine().split("\\s+");
			
			for (int j = 0; j < arr.length; j++) {

				verlines[i][j] = Integer.parseInt(arr[j]);

			}

		}

		for (int i = 0; i < numberofhorizontallines; i++) {
			
			String[] arr = sc.nextLine().split("\\s+");
			
			for (int j = 0; j < arr.length; j++) {

				horlines[i][j] = Integer.parseInt(arr[j]);

			}
		}


		for (int i = 0; i < numberofhorizontallines; i++) {

			for (int j = 0; j < numberofverticlelines; j++) {

				if (   (horlines[i][1] <= verlines[j][0]) 
					&& (horlines[i][0] <= verlines[j][2])
					&& (verlines[j][1] <= horlines[i][0])
					&& (verlines[j][0] <= horlines[i][2]))
					
					intersections++;

			}
		}
		
       System.out.println(intersections);
       
       sc.close();
	}

}
