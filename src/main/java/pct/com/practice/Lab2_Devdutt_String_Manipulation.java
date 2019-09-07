package pct.com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/*

input
2
abcd
z z. z,z. z z. z,z.
1
output
Unigram z

input
3
a a. a,a.
bc bc
abcd abcd abcd
2
output
Bigram bc

input
1
abababababababababa
3

output
Trigram aba
*/
public class Lab2_Devdutt_String_Manipulation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String noOfLines = sc.nextLine();
		Map<String,Integer> map = new TreeMap<String,Integer>();
		
		List<String> al = new ArrayList<String>();
		
		for(int i = 0; i < Integer.parseInt(noOfLines); i++) {
			String line = sc.nextLine();
			
			String[] strings = line.split("\\s+");
			
			for (String string : strings) {
				
				al.add(string.trim());
				
			}
			
		}

		//System.out.println(al);
		
		int ngram = sc.nextInt();
		
		if(ngram == 1) {
			
			String str = concatAllStringAndRemoveSpecialCharacter(al);
			String unigram = getCharWithMostOccurrence(str);
			
			System.out.println("Unigram "+unigram);
			
		}else {
			
			for (String string : al) {
				
				if(string.length() < ngram) {
					continue;
				}
				
				if(string.length() == ngram) {
					
					// check if all char in string are actually char
					
					String alphaString = string.replaceAll("[^a-zA-Z]+","");
					
					if(alphaString.length() < ngram) {
						continue;
					}else {
						
						if(map.containsKey(alphaString)) {
							map.put(alphaString, map.get(alphaString)+1);
						}else {
							map.put(alphaString, 1);
						}
						
					}
				}
				
				if(string.length() > ngram) {
					
					List<String> listOfNgrams = getListOfNgrams(string,ngram);
					
					for (String ngramstring : listOfNgrams) {
						
						// check if all char in string are actually char
						
						String alphaString = ngramstring.replaceAll("[^a-zA-Z]+","");
						
						if(alphaString.length() < ngram) {
							continue;
						}else {
							
							if(map.containsKey(alphaString)) {
								map.put(alphaString, map.get(alphaString)+1);
							}else {
								map.put(alphaString, 1);
							}
							
						}
						
						
						
						
					}
				}
			}
		}
		
		
		//System.out.println(map);
		
		displayNgram(map,ngram);
		
		sc.close();
	}

	private static void displayNgram(Map<String, Integer> map, int ngram) {

		String maxNgram = "";
		int maxcount = 0;
		
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			if(value > maxcount) {
				maxNgram = key;
				maxcount = value;
			}
			
		}
		
		if(ngram == 2) {
			System.out.println("Bigram "+maxNgram);
		}
		
		if(ngram == 3) {
			System.out.println("Trigram "+maxNgram);
		}
		
		
	}

	private static List<String> getListOfNgrams(String string, int ngram) {

		
		List<String> al = new ArrayList<String>();
		
		for(int i = 0; i < string.length()-ngram+1; i++) {
			
			StringBuilder sb = new StringBuilder();
			sb.append(string.charAt(i));
			
			for(int j = i+1; j < i+ngram; j++ ) {
				
				sb.append(string.charAt(j));
				
			}
			
			al.add(sb.toString());
			
		}
		
		return al;
	}

	private static String getCharWithMostOccurrence(String str) {
		
		String maxchar = Character.toString(str.charAt(0));
		int maxcount = 0;
		Map<Character,Integer> mapCharOccurr = new HashMap<Character,Integer>();
		
		char[] charArray = str.toCharArray();
		
		for (char character : charArray) {
			
			if(mapCharOccurr.containsKey(character)) {
				mapCharOccurr.put(character, mapCharOccurr.get(character)+1);
			}else {
				mapCharOccurr.put(character, 1);
			}
			
		}
		
		for (Entry<Character, Integer> entry : mapCharOccurr.entrySet()) {
			
			Character key = entry.getKey();
			Integer value = entry.getValue();
			
			if(value > maxcount) {
				maxchar = key.toString();
				maxcount = value;
			}
			
		}
		
		
		return maxchar;
	}

	private static String concatAllStringAndRemoveSpecialCharacter(List<String> al) {
		
		String str = "";
		
		for (String string : al) {
			str = str + string;
		}
		
		str = str.replaceAll("[^a-zA-Z]+","");
		
		return str;
	}

}
