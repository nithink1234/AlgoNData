import java.util.*;
public class longestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestsubstring("pwwkew"));
	}

	
	static int longestsubstring(String s) {
		
		char[] letters = s.toCharArray();
		boolean[] bits = new boolean[128];
		
		int max =0;
		int count =0;
		Arrays.fill(bits,false);
		
		for(int i=0; i<letters.length; i++) {
			
			System.out.println(letters[i] + " " + bits[(int)letters[i]]);
			
			if(!bits[(int)letters[i]]) {
				bits[(int)letters[i]] = true;
				count++;
				System.out.println(letters[i] + " " + bits[(int)letters[i]] + " " + count);
			}
			
			else {
				
				if(count > max) {
					max = count;
				}
				
				Arrays.fill(bits, false);
				bits[(int)letters[i]] = true;
				count = 1;
				System.out.println(letters[i] + " " + bits[(int)letters[i]]+ max + " " + count);
			}
		}
		
		if(max == 0) {
			max = count;
		}
		
		return max;
	}
}
