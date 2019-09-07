package pct.com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab5_Devdutt_String_Manipulation {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String letters = sc.nextLine();
		
		int subStringSize;
		int minSize = 70;
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		
		for(int i = 0; i < str.length(); i++ ) {
			
			for(int j = i + 1; j < str.length(); j++) {
				
				String subString = str.substring(i, j+1);
				
				subStringSize = getSizeOfSubstringWithLetters(subString,letters);
				
				if(subStringSize>0) {
					
					//System.out.println("subString -- "+subString);
					
					if(subStringSize < minSize) {
						minSize = subStringSize;
						map.put(minSize,subString);
					}
					
				}
				
			}
			
		}
		
		System.out.println(map.get(minSize));
		
		sc.close();
	}

	private static int getSizeOfSubstringWithLetters(String subString, String letters) {

		int size;
		
		if(subString.length() < letters.length()) {
			size = 0;
		}else {
			size = findSizeOfMatchedSubstring(subString,letters);
		}
		
		return size;
	}

	private static int findSizeOfMatchedSubstring(String subString, String letters) {

		// if all letters of letters are present in subString then return size of subString
		
		int match = 0;
		int size = 0;
		StringBuffer sb = new StringBuffer(subString);
		
		for(int i = 0; i < letters.length(); i++) {
			
			
			if(sb.toString().contains(Character.toString(letters.charAt(i)))) {
				int index = sb.indexOf(Character.toString(letters.charAt(i)));
				sb.deleteCharAt(index);
				match++;
			}
			
		}
		
		if(match==letters.length()) {
			size = subString.length();
		}

		return size;
	}


}
