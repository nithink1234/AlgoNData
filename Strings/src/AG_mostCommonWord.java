/*
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  
 * 
 * Example 
 * s = "Jack and Jill went up to hill Jack hill and and up"
 * words to be discarded = and, to, up
 * 
 * jack and hill occurs 2 times and it is max..  so return both
 */


import java.util.*;
public class AG_mostCommonWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Jack and Jill went up to hill Jack hill and and up";
		String[] words = {"and" , "up", "to"};
		
		List<String> result = commonWord(s, words);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// get a list of words from sentence
	// Add the banned words to a hashset 
	// exlucding the banned words , Add the rest into hastable with word as key and frequency as value. 
	// keep a count of the max freq 
	// use that count to extract all keys with max freq 
	static List<String> commonWord(String s, String[] banned) {
		
		List<String> result = new ArrayList<String>();
		
		if(!s.isEmpty()) {
			Hashtable<String, Integer> hs = new Hashtable<String, Integer>();
			String[] words = s.split(" ");
			
			//System.out.println(words.length);
			
			int max = 0;
			
			HashSet<String> bannedset = new HashSet<String>();
			
			for(int i=0; i<banned.length; i++) {
				bannedset.add(banned[i]);
			}
			
			for(int i=0; i<words.length; i++) {
				
				if(!bannedset.contains(words[i])) {
					
					if(hs.containsKey(words[i])) {
						hs.put(words[i], hs.get(words[i]) + 1);
		
						if(hs.get(words[i]) + 1 > max) {
							max = hs.get(words[i]);
							
						}
					}
					
					else {
						hs.put(words[i], 1);
					}
				}
				
				//System.out.println(words[i] + " " + max);
			}
			
			//System.out.println(hs.size() + " " + max);
			
			
			// iterate thru the hashtable and find the element with max 
			for(String key : hs.keySet()) {
				
				if(hs.get(key) == max) {
					
					result.add(key);
				}
			}
		}
		
		
		return result;
	}
}
