/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */


import java.util.*;
public class AA_Two_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,7,11,15}; 
		
		

	}
	
	// Hash Table Time o(n) Space O(n)
	static int[] sum_1(int[] nums, int target) {
		
		int[] result  = new int[2];
		Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
		
		for(int i=0; i<nums.length; i++) {
			hs.put(target- nums[i], i);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(hs.containsKey(target- nums[i]) && hs.get(target- nums[i]) != i) {
				result[0] = i;
				result[1] = hs.get(target- nums[i]);
				return result;
			}
		}
		
		return result;
	}
	
	static int[] sum (int[] nums,int target) {
		
		int[] result = new int[2];
		
		for(int i=0; i<nums.length; i++) {
			
			for(int j=i+1; j<nums.length; j++) {
			
				if((j<nums.length) && nums[i] + nums[j] == target) {
					
					result[0] = i;
					result[1] = j;
				}
			}
			
		}
		
		return result;
	}
}
