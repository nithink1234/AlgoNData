/*
 * Given an array, return length of the longest subarray of non- negative integers

Examples :

Input : {2, 3, 4, -1, -2, 1, 5, 6, 3}
Output : 4

The subarray [ 1, 5, 6, 3] has length 4 and 
contains no negative integers

Input : {1, 0, 0, 1, -1, -1, 0, 0, 1, 0}
Output : 4

Subarrays [1, 0, 0, 1] and [0, 0, 1, 0] have 
equal lengths but sum of first one is greater
so that will be the output.

 */
public class AP_maxSubArrayOfNonNegativeIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2, 3, 4, -1, -2, 1, 5, 6, 3};
		System.out.println(longestsubarray(nums));
	}

	
	static int longestsubarray(int[] nums) {
		
		int sum =0; 
		int max = 0;
		
		for(int i=0; i< nums.length; i++) {
			
			if(nums[i]>0) {
				
				sum += nums[i];
				
				if(sum> max)
					max = sum;
			}
			else {
				sum = 0;
			}
		}
		
		return max;
	}
}
