 /*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1: Input: "babad" Output: "bab"
Note: "aba" is also a valid answer.

Example 2: Input: "cbbd" Output: "bb"
 */

public class AL_longesPalindromicSubstring {

	static int start = 0;
	static int end = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestPalindrome("babad"));
	}
	
	
	// Time : O(n2) Space : O(1); 
	
	// Iterate thru the string and take each char as a center
	// Check if the letters around it make it a plaindrome, take boundarys left and right  .. start from center and keep left-- right ++
	// if it is a pali keep the count of which substring is max , when it doesnt no need to check further .. break it 
	// Repeat for all centers 
	// above will only work for odd length pali ..start with i , i
	//for even start with i , i+1.. 
	
	static String longestPalindrome(String s) {
	    int start = 0, end = 0;
	    
	    // Iterate thru the entire String 
	    for (int i = 0; i < s.length(); i++) {
	    	
	    	// Each char can be taken as center and it can be checked for palindrome by checking its charc around it eg aba
	    	// Should also consider case when pali is even .. bb so take i and i+1 as center as well 
	    	// Get the max length pali of the two centers 
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);	        
	        int len = Math.max(len1, len2);
	        //System.out.println("len: " + len + " start: " + start + " end: " + end);
	        
	        //Need to calc the start and end points of the pali given length and center of pali (i). 
	        // Make sure it satifies for both even and odd length pali 
	        // len-1/2 gives length of left side of center.. sub i to get start position 
	        // len/2 gives right 
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	        
	        //System.out.println(" start: " + start + " end: " + end);
	        //System.out.println("");
	    }
	    return s.substring(start, end + 1);
	}

	// Check for pali .i.e each charc at the center(for even) and around the center
	// The L & R will be at a position when it stopped being pali 
	// So length of pali will be R-L-1;
	static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    //System.out.println("L: " + L + " R: " + R);
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    //System.out.println("L: " + L + " R: " + R + " R-L " + (R-L));
	    return R - L -1;
	}
	
	// Brute Force .. Time O(n3)
	// Go thru all possible combinations of substrings : O(n2)
	// Check if its a palindrome : O(n)
	static String palsubstring(String s) {
		
		int max = 0;
		int start = 0;
		int end = 0;
		
		for(int i=0; i< s.length(); i++)
		{
			
			for(int j=i; j<s.length(); j++) {
				 	
				//System.out.println(s.substring(i, j+1));
				if( ValidPalindrome(s.substring(i, j+1))) {
					
					if(s.substring(i, j+1).length() > max) {
						max = s.substring(i, j+1).length();
						start = i ; end = j+1;
					}
				}
			}
		}
		
		if(s.substring(start, end).length() == 1)
			return "";
		
		return s.substring(start, end);
	}
	
	// To check if SubString is Palindrome
	static boolean ValidPalindrome(String s) {
		
		int j= s.length() -1;
		for(int i=0; i<s.length()/2; i++) {
			
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			
			j--;
		}
		
		return true;
	}
}
