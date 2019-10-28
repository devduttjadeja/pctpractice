package leetcode.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.eclipsesource.json.JsonArray;

public class Prb_5_Longest_Palindromic_Substring {

	public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            String ret = new Solution().longestPalindrome(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
    
    private static class Solution{
    	
    	public String longestPalindrome(String s) {
            
    		List<String> list = new ArrayList<>();
    		
    		String longestPalindrome = s;
    		for (int i = 0; i < s.length(); i++) {
    			for (int j = i; j < s.length(); j++) {
					String substring = s.substring(i, j+1);
					if(checkPalindorme(substring)) {
						list.add(substring);
					}
				}
				
			}
    		
    		int maxSize = 0;
    		
    		for (String subString : list) {
				
    			if(subString.length() > maxSize) {
    				maxSize = subString.length();
    				longestPalindrome = subString;
    			}
    			
			}
    		
    		return longestPalindrome;
        }

		private boolean checkPalindorme(String substring) {
			StringBuilder sbSubstring = new StringBuilder(substring);
			String reverserString = sbSubstring.reverse().toString();		
			
			if(reverserString.equals(substring)) {
				return true;
			}
			
			return false;
		}
    }

}
