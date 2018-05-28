/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */

import java.util.*;
public class AT_romanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(romantoint(""));
	}
	
	// Time: O(n)  Space: O(n)
	//Store all roman char and their values in a hashmap 
	//If number at I is less than I +1 then u have to subtract from sum Otherwise add it
	//Make sure to add the last number 
	static int romantoint(String s) {
		
		//Null Case
		if(s.isEmpty())
			return 0;
		
		//Store all roman char and their values in a hashmap 
		int result = 0;
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);

		//If number at i is less than number at i +1 then u have to subtract from sum Otherwise add it
		for(int i=0; i<s.length() -1; i++) {
			
			if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))) {
				result -= hm.get(s.charAt(i));
			}
			else {
				result += hm.get(s.charAt(i));
			}
		}
		
		//Make sure to add the last number 		
		return result + hm.get(s.charAt(s.length()-1));
	}

}
