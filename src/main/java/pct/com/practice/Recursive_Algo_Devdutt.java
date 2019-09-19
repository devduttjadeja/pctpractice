package pct.com.practice;

import java.util.Scanner;

public class Recursive_Algo_Devdutt {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		allPermutationOfString(line.toCharArray(),0,line.length()-1);
		
		sc.close();
		
	}

	private static void allPermutationOfString(char[] line, int i, int lastindex) {

		if(i == lastindex) {
			System.out.println(line);
		}
		
		else {
			
			for(int j = i; j <= lastindex; j++) {
				
				swap(line,i,j);
				allPermutationOfString(line,i+1,lastindex);
				swap(line,i,j);
			}
			
		}
		
		
	}

	private static void swap(char[] line, int i, int j) {
		
		char temp = line[i];
		line[i] = line[j];
		line[j] = temp;
	}


}