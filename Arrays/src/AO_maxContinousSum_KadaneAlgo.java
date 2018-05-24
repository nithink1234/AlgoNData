
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],  Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class AO_maxContinousSum_KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxsum(nums));
	}
	
	// Kadane Algo
	
	static int maxsumkande(int[] nums) {
		
	}

	// Brute Force O(n2)
	// add all possible combinations of num 
	// Loop thru twice n add every num from i to n 
	// at every step check if its max num so far
	static int maxsum(int[] nums) {
		
		int sum = 0;
		int highsum = 0;
		
		for(int i=0; i<nums.length; i++) {
			sum = 0;
			
			for(int j=i; j<nums.length; j++) {
				
				sum += nums[j];
				
				if(sum > highsum)
					highsum = sum;
				
				System.out.print(sum + ":" + highsum + " " );
			}
			
			System.out.println(" ");
		}
		
		return highsum;
	}
	
	
	
}
