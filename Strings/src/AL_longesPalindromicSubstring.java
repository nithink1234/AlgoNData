
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
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
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
