/*
 * Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

Examples:

  arr[] = {3, 1, 3}
  Output: 2, 3   // 2 is missing and 3 occurs twice 

  arr[] = {4, 3, 6, 2, 1, 1}
  Output: 1, 5  // 5 is missing and 1 occurs twice 

 */
public class AM_missingAndRepeatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {};
		missingnrepeat(nums);
		
	}
	
	// The numbers in array will be from 1 .. n 
	// So go thru the list 
	// access the index of the number present in i 
	// Say i = 0 nums[i]= 5 .. access index 5-1 = 4th index of array 	
	// make the number at 4th index -ve of itself 
	
	// Repeated
	// u will access the index of repeated number twice .. 
	// so if the num is already -ve that means that is repeated
	
	//Missing
	// Go thru the list again 
	// The index  + 1 which has a positive num will be missing
	
	// Other Methods
	// Sorting 	nlogn
	// using another array to do same O(n) space
	static void missingnrepeat(int[] nums) {
		
		int missing = 0;
		int repeat = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			if(nums[Math.abs(nums[i]) -1] > 0) {
				nums[Math.abs(nums[i]) -1]  = - nums[Math.abs(nums[i]) -1] ;
			}
			else {
				repeat = Math.abs(nums[i]);
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			
			if(nums[i] > 0)
				missing = i+1;
		}
		
	}

}
