
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],  Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class EC_maxContinousSum_KadaneAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxsum(nums));
	}
	
	// Kadane Algo
	// Keep a sum of elements .. reset it when it goes negative .. keep track of max sum at every node.. 
	// O(n) Divide and conquer 
	static int maxsumkande(int[] nums) {
		
		// In case there is only -ve numbers in arry
		int max = nums[0];
		int sum = nums[0];
		
		// Get the sum untill then .. n check to see if its bigger than current num
		// keep track of max num. 
		for(int i=1; i< nums.length; i++) {
			
			sum  = Math.max(sum + nums[i] , nums[i]);
			max = Math.max(sum, max);
		
		}
		
		return max;
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
