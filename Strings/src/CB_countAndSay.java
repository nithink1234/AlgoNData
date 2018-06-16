/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1: Input: 1 Output: "1"
Example 2: Input: 4 Output: "1211"
 */
public class CB_countAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countit(4));
	}

	
	// Time : O(n2) .. 
	// Other Solution : Recursive 
	static String countit(int n) {
		
		int j = 1;
		String result = "1";
		char prev  = '1'; 
		int count = 0; 
		StringBuilder sb = new StringBuilder();
		
		// Count up to needed num . Build a string for each num and use that as input
		// until u reach the nedded num 
		while (j < n) {
			
			// Go thru the current num and count frequency of every char
			for(int i=0; i<result.length(); i++) {
			
				// If the char is same as prev , count it
				if(result.charAt(i) == prev) {
					count++;
				}
				
				// When the char is different, Add the freq and num and restart for next char 
				else {
					sb.append(count);
					sb.append(prev);
					count = 1;
					prev = result.charAt(i);
				}
				
			}
			
			// Make sure last char and its freq is appended 
			// Reset count and stringbuilder 
			// Move on to next num
			sb.append(count);
			sb.append(prev);
			count = 0;
			result = sb.toString();
			
			prev = result.charAt(0);
			sb.delete(0, sb.length());
			j++;
		}
		
		return result;
	}
}
