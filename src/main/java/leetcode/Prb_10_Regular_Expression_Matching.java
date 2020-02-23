package leetcode;

import java.util.Scanner;


/*

understanding -- https://www.youtube.com/watch?v=bSdw9rJYf-I&feature=youtu.be

aa
a
false

aa
a*
true

ab
.*
true

aab
c*a*b*
true

mississippi
mis*is*p*.
false

*/

public class Prb_10_Regular_Expression_Matching {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String string = sc.nextLine();
		String pattern = sc.nextLine();
		
		boolean match = isMatch(string,pattern);
		
		System.out.println(match);
		
		sc.close();
	}

	private static boolean isMatch(String string, String pattern) {
		
		if(pattern.length() == 0) {
			return string.length() == 0;
		}

		boolean a = string.length() > 0 && string.charAt(0) == pattern.charAt(0);
		boolean b = pattern.charAt(0) == '.' ;
		
		boolean firstMatch = (a || b);

		
		if(pattern.length()>=2 && pattern.charAt(1) == '*') {
			
			boolean c = isMatch(string, pattern.substring(2)); // s = aaaaab , p = c*a*b
			boolean d = firstMatch && isMatch(string.substring(1), pattern); // s = aa , p = a*
			
			return (c || d);  
					
			
		}else {
			return firstMatch && isMatch(string.substring(1), pattern.substring(1));
		}
		
		
	}

}
