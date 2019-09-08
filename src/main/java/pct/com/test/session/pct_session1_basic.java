package pct.com.test.session;

import java.util.Scanner;

public class pct_session1_basic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String output = null;
		
		String[] names = sc.nextLine().split("\\s+");
		
		
		
		if(names.length == 1) {
			output = names[0];
		}
		if(names.length == 3) {
			output = names[2]+" "+names[0]+" "+names[1];
		}
		if(names.length == 2) {
			
			String lastchar = Character.toString(names[1].charAt(names[1].length()-1));   
			
			if(lastchar.equalsIgnoreCase("a")
					|| lastchar.equalsIgnoreCase("e")
					|| lastchar.equalsIgnoreCase("i")
					|| lastchar.equalsIgnoreCase("o")
					|| lastchar.equalsIgnoreCase("u")) {
				
				output = names[1]+" "+names[0];
				
			}
			
			output = names[0]+" "+names[1];
			
		}
		
		System.out.println(output);
		
		sc.close();
	}

}
