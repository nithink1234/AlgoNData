/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. 
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1: Input: J = "aA", S = "aAAbbbb" Output: 3

Example 2: Input: J = "z", S = "ZZ" Output: 0

Note:
    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.

 */


import java.util.*;
public class DA_jewelsAndStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numJewelsInStones("aA" , "aAAbbbb"));
	}

	
	// Add All jewels in hasset(its distinct anyways)
	// iterate thru stones n check if each charc is there in jewels ... will account for duplicates as well
	// Faster coz less number of jewels. 
	static int numJewelsInStonesFaster(String J, String S) {
		
		HashSet<Character> hs = new HashSet<Character>();
		int count =0;
		
		for(int i=0; i<J.length(); i++) {
			hs.add(J.charAt(i));
		}
		
		for(int i=0; i<S.length(); i++) {
			
			if(hs.contains(S.charAt(i))) {
				count++;
			}
		}
		
		return count;
			
	}
	
	// Add all the stones to hastable with key as charc and value as number of ocurances 
	// Go to jewels n look up in tha table and add it 
	 static int numJewelsInStones(String J, String S) {
		 
		 Hashtable<Character, Integer>hs = new Hashtable<Character,Integer>();
		 int count = 0;
		 
		 
		 for(int i=0; i<S.length(); i++) {
			 
			 if(hs.containsKey(S.charAt(i)))
				 hs.put(S.charAt(i), hs.get(S.charAt(i)) + 1);
			 
			 else {
				 hs.put(S.charAt(i), 1);
			 }
			 
		 }
		 
		 
		 for(int i=0; i<J.length(); i++) {
			 
			 if(hs.containsKey(J.charAt(i))) {
				 count += hs.get(J.charAt(i));
			 }
		 }
		 
		 return count;
	 }
}
