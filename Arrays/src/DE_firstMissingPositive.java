/*
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1: Input: [1,2,0] Output: 3

Example 2: Input: [3,4,-1,1] Output: 2

Example 3: Input: [7,8,9,11,12] Output: 1

Note:
Your algorithm should run in O(n) time and uses constant extra space.

 */
public class DE_firstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int smalletMissingPositive (int[] nums){
		
		int j= 0;
		int temp = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			//Push all negative numbers and zeros to start of the array. 
			if(nums[i] <=0) {
				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
			
		}
		
		// j will give index from where positive integers will start 
		int firstmissing = 0;
		
		// j will give number of non positive integers 
		// Consider the index from j to be 1 .. u can get this by (nums[i]+j-1) make it -ve
		for(int i=j; i<nums.length; i++) {
			
			if((nums[i]+j-1) < nums.length) {
				nums[(nums[i]+j-1)] = -Math.abs(nums[(nums[i]+j-1)]);
			}
		}
		
		
		for(int i=j ; i<nums.length; i++) {
			
			if(nums[i] >0) {
				firstmissing =(i+j-1) ;
			}
		}
		
		return firstmissing;
	}
}
