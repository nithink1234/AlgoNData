
public class AD_longestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = {"leetcode" , "leets" , "letmenstine" };
		
		System.out.println(longCommonPrefix(str));
	}

	// Time O(S) where S is the sum of all charc in string
	static String longCommonPrefix(String[] strs) {
		
		// Find the index of the smallest string and use that as comparison. To reduce the number of comparisons. 
		int mim = Integer.MAX_VALUE;
		int index = 0;
		
		for( int i=0; i<strs.length; i++ ) {
			
			if(strs[i].length() < mim) {
				mim = strs[i].length();
				index = i;
			}
		}
		
		String first = strs[index];
		
		// in each word 
		for( int i=0; i<strs.length; i++) {
			
			// Check if it matches .. if it does the index will be 0 as it is a prefex
			// When it doesn't keep reducing the length of the comparison string until it does 
			//or until its null in which case there is no common prefix
			// if it does move on to next one  and repeate 
			// it finally reduced to the longest common one 
			while(strs[i].indexOf(first) != 0) {
				// System.out.println( i + " " + strs[i].indexOf(first) + " " + first );
				first = first.substring(0, first.length()-1);
				
				if(first.length() == 0)
					return "";
			}
			
			//System.out.println( i + " out " + strs[i].indexOf(first) + " " + first );
 		}
		return first;
	}
}
