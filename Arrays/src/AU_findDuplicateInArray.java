/*
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1: Input: [1,3,4,2,2] Output: 2
Example 2: Input: [3,1,3,4,2] Output: 3

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

 */
public class AU_findDuplicateInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {};
		
		System.out.println(finddup(nums));
	}

	// Time: O(n) Space: O(1)
	// The numbers in array will be from 1 .. n 
	// So go thru the list 
	// access the index of the number present in i 
	// Say i = 0 nums[i]= 5 .. access index 5-1 = 4th index of array 	
	// make the number at 4th index -ve of itself 
	
	// Repeated
	// u will access the index of repeated number twice .. 
	// so if the num is already -ve that means that index is repeated
	static int finddup(int[] nums) {
		
		int dup = 0;
		
		for(int i=0 ; i< nums.length; i++) {
			
			if(nums[Math.abs(nums[i])] > 0)
				nums[Math.abs(nums[i])]  = - nums[Math.abs(nums[i])] ;
			
			else {
				dup = Math.abs(nums[i]) ;
			}
		}
		
		return dup;
	}
} 
