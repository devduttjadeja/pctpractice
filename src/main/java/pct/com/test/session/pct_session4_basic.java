package pct.com.test.session;

import java.util.Scanner;
import java.util.Stack;

public class pct_session4_basic {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numberoflines = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < numberoflines; i++) {
			
			String string = sc.nextLine();
			
			String str = checkValidString(string);
			
			System.out.println(str);
		}
		
		sc.close();
	}

	
	
	private static String checkValidString(String string) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < string.length(); i++) {
			
			if(string.charAt(i) == '(' 
					|| string.charAt(i) == '{'
					|| string.charAt(i) == '[') {
				stack.push(string.charAt(i));
			}
			if(string.charAt(i) == ')' 
					|| string.charAt(i) == '}'
					|| string.charAt(i) == ']') {
				
				Character pop = stack.pop();
				if(pop == '(') {
					pop = ')' ;
				}else if(pop == '{') {
					pop = '}' ;
				}else if (pop == '[') {
					pop = ']' ;
				}
				
				
				if(pop == string.charAt(i)) {
					continue;
				}else {
					return "FALSE";
				}
				
			}
			
		}

		
		if(stack.size() > 0) {
			return "FALSE";
		}
		
		return "TRUE";
	}

}
