/*
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "mississippi", needle = "issip"
Output: 4

Clarification:

The needle might overlap in haystack as show in problem 2 

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 */


public class implementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(strStr("mississippi","issip"));
	}
	
	// Time O(n) Space O(1)
	// Take the difference in length 
	// compare small string with big if not equal increment position by 1 and repeat. 
	static int strStr (String haystack, String needle) {
		
		if(needle.isEmpty())
			return 0;
		
		if(needle.length() > haystack.length() || haystack.isEmpty())
			return -1;
		
		int diff = haystack.length() - needle.length();
		
		for(int i = 0; i<= diff; i++) {
			if(haystack.substring(i, i+needle.length()).equals(needle))
				return i;
		}
		
		return -1;
	}
	

}
