/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1: Input: [3,0,1]  Output: 2

Example 2: Input: [9,6,4,2,3,5,7,0,1]  Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 */

public class AC_missingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		System.out.println(missing(nums));
	}

	// Add all nums 1- n 
	// there is a gauss formula to fins sum of n numbers: n(n+1)/2 .. Can use this instead of looping. 
	// Add all the nums in array 
	// Difference is missing num 
	
	// Other Methods 
	// Sorting .. 
	// Hashset.. add nums in arr in hashset .. loop thru 1-n n check which is missing
	static int missing(int[] nums) {
		
		int sum = 0;
		int check  = 0;
		
		for(int i=1 ; i<= nums.length; i++) {
			check += i;
		}
		
		for(int i=0 ; i< nums.length; i++) {
			sum += nums[i];
		}
		
		return check - sum;
	}
}
