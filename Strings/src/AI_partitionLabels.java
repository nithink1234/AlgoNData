import java.util.*;
public class AI_partitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> result = partition("caedbdedda");
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	static List<Integer> partition (String s){
		List<Integer> result  = new ArrayList<Integer>();
		HashMap<Character, Integer> lastindex = new HashMap<Character, Integer>();
		
		// Put all charc as key and lastindex as value in hashmap .. 
		//if its duplicate it just replaces the index value
		for(int i=0; i<s.length(); i++) {
			lastindex.put(s.charAt(i), i);
			//System.out.println(s.charAt(i)+ ":" +  i);
		}
		
		if(!s.isEmpty()) {
			
			int j=1;
			int partition = lastindex.get(s.charAt(0));
			int start = 0;
			
			while (j != s.length()) {
				
				//.out.println(j + ":" + partition);
				//
				if( j == partition) {
					
					// when partition is inbwtween.  
					if(partition+1< s.length()) {
						result.add(s.substring(start, partition+1).length());
						start = partition + 1;
						partition = lastindex.get(s.charAt(partition +1));
					}
					
					else {
						//System.out.println(s.substring(start));
						result.add(s.substring(start).length());
						break;
					}
				}
				
				else if(lastindex.get(s.charAt(j)) <= partition) {
					j++;		
				}
				
				else {
					partition = lastindex.get(s.charAt(j));
				}
				
			}
		}

		
		return result;
	}
}
