/*
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1: Input: s = "anagram", t = "nagaram" Output: true

Example 2: Input: s = "rat", t = "car" Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
import java.util.*;
public class DD_validAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isana("aacc" ,"ccac" ));
	}
	
	static boolean isana(String s,String t) {
		
		//Null Case
		if((s.isEmpty() && !t.isEmpty()) || !s.isEmpty() && t.isEmpty())
			return false;
		
		if(s.isEmpty() && t.isEmpty())
			return true;
		
		// Add all char of one string to hashmap with its value as count of the char in the string
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0; i<s.length(); i++) {
			
			if(hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), hm.get(s.charAt(i)) +1);
			else
				hm.put(s.charAt(i), 1);
		}
		
		// iterate thru t and -1 for everytime a matching charc occurs
		// if there is no char in hm that mean its false
		for(int i=0; i<t.length(); i++) {
			
			if(hm.containsKey(t.charAt(i)))
				hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
			else
				return false;
		}
		
		// If its anagram all values should be 0 else false
		for(char key: hm.keySet()) {
			System.out.println(key + ":" + hm.get(key));
			if(hm.get(key) != 0)
				return false;
		}
		
		return true;
	}

}
