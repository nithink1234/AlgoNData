/*
 * 
 */


import java.util.*;
public class AQ_minContinousSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> nums = new ArrayList<Integer>();
		List<String> targetList = new ArrayList<String>();
		List<String> availableList = new ArrayList<String>();
		
		// Life , ups , is, world
		targetList.add("life");targetList.add("ups");targetList.add("is");targetList.add("world");
		
		//The world is here this is a life full of ups and downs life is world
		availableList.add("The");availableList.add("world");availableList.add("is");availableList.add("here");availableList.add("this");availableList.add("is");availableList.add("a");availableList.add("life");availableList.add("full");availableList.add("of");availableList.add("ups");availableList.add("and");availableList.add("downs");availableList.add("life");availableList.add("is");availableList.add("world");
		
		nums = subsequence(targetList,availableList );
		
		for(int i=0; i<nums.size(); i++) {
			System.out.println(nums.get(i));
		}
	}

	// Time: O(n*m) m is size of target list .. Space O(n)
	// Add all the targets to hashmap and iterate thru the available and update the last positon of the target in available 
	// Until all the tags have not been count we dont do anything
	// Once it has been found we keep track of shortest length between indexs
	//Everytime a a tag is found.
	static List<Integer> subsequence(List<String> targetList, List<String> availableList){
		List<Integer> result = new ArrayList<Integer>();
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		int count = 0;
		int max = 0;
		int min =0;
		int length = Integer.MAX_VALUE;
		int start =0;
		int end =0;
		
		// Add all the targets to a hashmap and update its value as -1
		for(int i=0; i< targetList.size(); i++) {
			hm.put(targetList.get(i), -1);
		}
		
		//Iterate thru the available list 
		for(int i=0; i<availableList.size(); i++) {
			
			//When tag is present 
			if(hm.containsKey(availableList.get(i))) {
				
				//If the tag is encounterd the first time , update count
				//Update the last index of tag either ways.
				if(hm.get(availableList.get(i)) ==-1) {
					count++;
				}
				hm.put(availableList.get(i),i);
				
				//Each time all needed tags have been found
				if(count == targetList.size()) {
					
					// Find the max and min index value
					// this will contain all tags
					 min = Integer.MAX_VALUE;
					 max = Integer.MIN_VALUE;
					for(String key: hm.keySet()) {		
						min = Math.min(hm.get(key), min);
						max = Math.max(hm.get(key), max);
					}
					
					// Keep track of the shortest of these indexs 
					if((max-min) < length) {
						length = max - min;
						start = min;
						end = max;
					}
					
				}
			}
		}
		
		result .add(start); result.add(end);
		return result;
	}
}
