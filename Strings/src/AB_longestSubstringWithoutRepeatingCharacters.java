/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.*;
public class AB_longestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestsubstring("pwwkew"));
	}

	// Time: O(n2)  Space O(n)
	// Iterate thru the entire string and add char with its position to hashmap 
	// When u find a charc thats already present .i.e repeating charc
	// delete all the chars until then and add that charc 
	// At each point when u add keep track of longest substring
	static int longestsubstring(String s) {
		
		HashMap<Character,Integer> ht = new HashMap<Character,Integer>();
		int start =0;
		int max =0;
	
		for(int i=0; i<s.length(); i++) {
			
			if(ht.containsKey(s.charAt(i))) {
				
				int prev = ht.get(s.charAt(i));
				
				while(start <= prev) {
					ht.remove(s.charAt(start));
					start++;
				}
			}
			
			ht.put(s.charAt(i), i);
			max = Math.max(max,ht.size());
		}
		
		return max;
	}
}
