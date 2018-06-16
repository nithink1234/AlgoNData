/*
 * 
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
 */
public class AF_maxDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		
		System.out.println(levelMethddist(nums));
	}

	
	static int levelMethddist (int[] nums) {
		
		int[] minNums = new int[nums.length];
		int[] maxNums = new int[nums.length];
		
		// Creating an array minNums which will store the mim value seen from 0 untill i in nums[] at minNums[i]
		minNums[0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			minNums[i] = Math.min(nums[i], minNums[i-1]);
		}
		
		// Creating a maxNums array which will store max value seen from end of arry till i in nums[] at maxNums[i]
		maxNums[nums.length-1] = nums[nums.length-1];
		for(int i=nums.length-2; i>=0; i--) {
			
			if(nums[i] > maxNums[i+1])
				maxNums[i] = nums[i]; 
			else {
				maxNums[i] = maxNums[i+1];
			}
		}
		
		int j= 0;
		int i= 0;
		int max = 0;
		
		// Traverse both arrays from left to right and at which point j-1 will be max
		while(j<maxNums.length) {
			
			if(maxNums[j] >= minNums[i]) {
				j++;
			}
			
			else {
				i++;
			}
			
			if(j-i > max)
				max = j-1;
		}
		
		
		return max;
	}
	
	// Time worst case: O(n2) else O(n+m) Efficient .. Space O(1)
	// Loop thru the array . For every element at i 
	// for the first element check from  j = end of array, the first occarance of bigger element than nums[i]. that will be max distance for that element
	// next element onwards we only need to check from  wnd of array to i + max distance so far .. so the number of second loop iterations are reduced drastically  
	static int maxDist(int[] nums) {
		
		int max = 0;
		int length = 0;
		int j = 0;
		
		for(int i=0; i< nums.length; i++) {
			// Reset to end of arry every time 
			j = nums.length-1;
			
			// Reduce j until it has bigger element than i within j+max , end of array
			while(j >= i+max && nums[j] <= nums[i])
				j--;
			
			// Get the max value so far
			length = j-i;
			if(length > max)
				max = length;
			
		}
		
		// In the case there is no bigger element .. sorted in descending order?
		if( max == 0)
			return -1; 
		
		return max;
	}
	
}
