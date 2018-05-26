/*
 * Given an input string, reverse the string word by word.

Example:   Input: "the sky is blue", Output: "blue is sky the".

Note:
    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class AM_reverseWordsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reversesb("the sky is blue"));
	}
	
	// Using stringbuilder its just O(n) time O(1) Space 
	static String reversesb(String s) {
		
		StringBuilder sb = new StringBuilder();
		int end = s.length();
		for(int i=s.length()-1; i>=0; i--) {
			
			if(Character.isWhitespace(s.charAt(i))) {
				sb.append(s.substring(i+1, end));
				sb.append(s.charAt(i));
				end = i;
			}
		}
		
		sb.append(s.substring(0, end));
		
		return sb.toString();
	}
	
	// Without using StringBuilder or extra space
	// Time : O(n2) Space : O(1)
	static String reverse(String s) {
		
		// Trim all the leading and trailing spaces 
		// Replace multiple spaces between spaces to single space. 
		s = s.trim().replaceAll(" +", " ");
		
		// Reverse the Entire sentence
		char[] words = s.toCharArray();
		int start =0;
		words = reverseit(words, 0, words.length);
		
		// Reverse each word by detecting spaces
		// when there is a space .. reverse the word untill then
		for(int i=0; i<words.length; i++) {
			
			if(Character.isWhitespace(words[i])) {
				words = reverseit(words,start,i);
				start = i+1;
			}
		}
		
		// Reverse the last word 
		words = reverseit(words,start,words.length);
		
		return String.valueOf(words);
	}
	
	// Reverse the word given its start and end 
	static char[] reverseit(char[] words, int start, int end) {
		char temp;
		
		// reverse the entire String 
		for(int i=start, j= end-1; i<j; i++, j--) {
			temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}	
		return words;
	}

	

}
