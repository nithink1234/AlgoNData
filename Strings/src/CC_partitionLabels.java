/*
 *  A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.

 */


import java.util.*;
public class CC_partitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> result = partition("caedbdedda");
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// Greedy Algo 
	
	static List<Integer> partition (String s){
		List<Integer> result  = new ArrayList<Integer>();
		HashMap<Character, Integer> lastindex = new HashMap<Character, Integer>();
		
		// Put all charc as key and lastindex as value in hashmap .. 
		//if its duplicate it just replaces the index value
		for(int i=0; i<s.length(); i++) {
			lastindex.put(s.charAt(i), i);
			//System.out.println(s.charAt(i)+ ":" +  i);
		}
		
		// For null case;
		if(!s.isEmpty()) {
			
			// Set the partition point as lastindex of the first charcter
			int j = 0;
			int partition = lastindex.get(s.charAt(0));
			int start = 0;
			
			// Iterate thru the entire String 
			while (j != s.length()) {
			
				//When Iteration has reached the partition point
				if( j == partition) {
					
					// when partition before the end of string 
					// Add the length, Reset Start positionto new position 
					// Get the partition for next segment 
					if(partition+1< s.length()) {
						result.add(s.substring(start, partition+1).length());
						start = partition + 1;
						partition = lastindex.get(s.charAt(partition +1));
					}
					
					// if its last partition just add and leave 
					else {
						//System.out.println(s.substring(start));
						result.add(s.substring(start).length());
						break;
					}
				}
				
				// if current char last index is before partition .. all good move on to next char
				else if(lastindex.get(s.charAt(j)) <= partition) {
					j++;		
				}
				
				// if current char has partition after  current partition , update the partition. 
				else {
					partition = lastindex.get(s.charAt(j));
				}
				
			}
		}

		
		return result;
	}
}
