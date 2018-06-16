/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1: Input: "A man, a plan, a canal: Panama"  Output: true

Example 2: Input: "race a car"  Output: false

 */
public class BA_validpalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
	}

	// two Pointers on both ends 
	// make sure to remove all spaces n stuff get only alphanumeric charc 
	// Iterate till halfway checking if they are same 
	static boolean validPalindrome(String s) {
		
		if(s.isEmpty())
			return true;
		
		s = s.replaceAll("[^a-zA-Z0-9]" , "").toLowerCase();

		int j= s.length()-1;
		
		for(int i=0; i<s.length()/2; i++) {
			
			if(s.charAt(i) != s.charAt(j))
				return false;
			
			j--;
		}
		
		return true;
	}
}
