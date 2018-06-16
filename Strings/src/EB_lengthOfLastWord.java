/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
If its a signle word return its length.

Note: A word is defined as a character sequence consists of non-space characters only.
Example: Input: "Hello World" Output: 5
 */
public class EB_lengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(lastword("the "));
	}

	//Time: O(n)  Space O(1)
	// Iterate thru the String and get index of the last space in the sentence 
	// Can get length of the last word from that. 
	static int lastword(String s) {
		
		s = s.trim();
		
		char[] words = s.toCharArray();
		int lastspace =0;
		
		for(int i=0; i<words.length; i++) {
			
			if(Character.isWhitespace(words[i]))
				lastspace = i;
		}
		
		if(lastspace == 0 && !s.isEmpty())
			return s.length();
		else if (s.isEmpty())
			return 0;
		
		return (s.length()-1-lastspace);
	}
}
