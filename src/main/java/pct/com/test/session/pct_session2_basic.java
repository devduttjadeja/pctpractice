package pct.com.test.session;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class pct_session2_basic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Set<String> set = new HashSet<String>();
		
		String string = sc.nextLine();
		
		String[] strings = string.split("\\s+");
		
		for (String str : strings) {
			set.add(str.toLowerCase());
		}
		
		System.out.println(set.size());
		
		sc.close();
		
	}

}
