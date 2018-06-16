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
public class AJ_maxSubArrayOfNonNegativeIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2, 3, 4, -1, -2, 1, 5, 6, 3};
		System.out.println(longestsubarray(nums));
	}

	
	static int longestsubarray(int[] nums) {
		
		int start =0; 
		
		int max = 0;
		
		for(int i=0; i< nums.length; i++) {
			
			if((i==0 && nums[i]> 0) || (nums[i]>0 && nums[i-1]<0)) {
				
				start = i;
			}
			else {
				if(i-start> max)
					max = i-start;
			}
		}
		
		return max;
	}
}
