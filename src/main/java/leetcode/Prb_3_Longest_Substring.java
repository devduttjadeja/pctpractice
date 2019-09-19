package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eclipsesource.json.JsonArray;

/*
link -- https://leetcode.com/problems/longest-substring-without-repeating-characters/
input -- "abcabcbb" with quotes
output -- 3


*/
public class Prb_3_Longest_Substring {

	public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        String s = stringToString(line);
        
        int ret = new Solution().lengthOfLongestSubstring(s);
        
        String out = String.valueOf(ret);
        
        System.out.print(out);
    
    
    }

    
    private static class Solution{
    	
    	private int lengthOfLongestSubstring(String str) {
    		
    		int longest = 0;
    		
    		// get all substring of str
    		for (int i = 0; i < str.length(); i++) {
    			
    			for (int j = i+1; j <= str.length(); j++) {
					
    				String substring = str.substring(i, j);
    				
    				if(allUniqueCharacter(substring)) {
    					
    					if(substring.length() > longest) {
    						longest = substring.length();
    					}
    					
    				}
				}
			}
    		
            return longest;
        }

		private boolean allUniqueCharacter(String substring) {
			
			for (int i = 0; i < substring.length(); i++) {
				
				for (int j = i+1; j < substring.length(); j++) {
					
					if(substring.charAt(i) == substring.charAt(j)) {
						return false;
					}
				}
			}
			
			return true;
		}
    	
    }
    
}
