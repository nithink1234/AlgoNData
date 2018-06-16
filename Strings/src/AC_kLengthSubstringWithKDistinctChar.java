/*
 * In a String s, find all substrings of size K with K distinct characters 
 */

import java.util.*;
public class AC_kLengthSubstringWithKDistinctChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> result = ksubstring("abs" , 4);
		
		for(int i =0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// Time: O(n2) Space O(k)
	//Iterate thru the String 
	// For each char check if the next k char are distinct by adding them to hashset 
	// If it is add to results // Make sure to clear the hashset 
	// when sequence has a duplicate char break and move on to next char
	static List<String> ksubstring (String s , int k){
		
		ArrayList<String> result = new ArrayList<String>();
		HashSet<Character> hs = new HashSet<Character>();
		
		
		for(int i=0; i<s.length(); i++) {
			
			// Make sure the k length subsequence doesn't exceed length of string towards the end of the iteration
			if(i+k <=s.length()) {
				// iterate thru the length (k) of the subsequence 
				for(int j=i; j<i+k; j++) {
					// When the char is distinct within its subsequence add it to hs
					if(!hs.contains(s.charAt(j))) {
						hs.add(s.charAt(j));
						
						// When iteration thru subsequence is done meaning all char are distinct
						// add it to result set 
						// Make sure to clear hs for next subsequence 
						if(j == i+k-1) {
							result.add(s.substring(i, i+k));
							hs.clear();
						}
					}
					
					// When it already contains letters break and move on to next char
					// Make sure to clear the hs before u break
					else {
						hs.clear();
						break;
					}
				}
			}
			
		}
		
		return result;
	}
}
