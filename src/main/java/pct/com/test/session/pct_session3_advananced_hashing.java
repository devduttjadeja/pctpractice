package pct.com.test.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Input:
7
38 52 145 16 179 4 -1

Output:
3
3 5
5 5 4
2
4 0
4 4 3 2 1

*/
public class pct_session3_advananced_hashing {

	private static List<Integer> listNumber = new ArrayList<>();
	private static Integer[] array;
	private static List<Integer> indexList = new ArrayList<>();
	private static int size = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		size = Integer.parseInt(sc.nextLine());
		array = new Integer[size];

		String[] strings = sc.nextLine().split("\\s+");

		for (int i = 0; i < strings.length; i++) {

			if (!(Integer.parseInt(strings[i]) == -1)) {
				listNumber.add(Integer.parseInt(strings[i]));
			}

		}

		for (Integer number : listNumber) {
			int index = number % 7;
			insertNumberInArrayAndGetIndexList(number, index, number);
			System.out.println(indexList);
			indexList.clear();
		}

		sc.close();

	}

	private static List<Integer> insertNumberInArrayAndGetIndexList(Integer number, int index, Integer originalNumber) {

		//int tempNumber = number;

		if (array[index] == null) {
			array[index] = originalNumber;
			indexList.add(index);
		} else {
			indexList.add(index);
			int lastDigit = number % 10;
			
			if(number == 0) {
				
				if(index > lastDigit) {
					insertNumberInArrayAndGetIndexList(number, index-1, originalNumber);
					return indexList;
				}
				if(index < lastDigit) {
					insertNumberInArrayAndGetIndexList(number, index+1, originalNumber);
					return indexList;
				}
				
			}
			
			number = number / 10;
			int newJ = number % size;

			if (lastDigit % 2 == 1) {

				// move newJ location fwd from index
				int newLocation;
				if(index + newJ > size-1) {
					newLocation = (index + newJ) - size;
				}else {
					newLocation = index + newJ;
				}
				
				insertNumberInArrayAndGetIndexList(number, newLocation,originalNumber);

			} 
			
			if (lastDigit % 2 == 0) {

				// move newJ location back from index
				int newLocation;
				if (index - newJ < 0) {
					newLocation = (index - newJ) + size;
				} else {
					newLocation = index - newJ;
				}
				
				insertNumberInArrayAndGetIndexList(number, newLocation,originalNumber);
				
			}

		}

		return indexList;

	}

}
