/*
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:

    You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
    Try to solve it in linear time/space.


 */
class bucket {
	
	int min ; 
	int max ;
	boolean isempty;
	
	public bucket() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isempty = true;
	}
}

public class BA_maximumGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int maxGap(int[] nums) {
		
		// Null case
		if(nums.length<2) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		// Get min and max value of array; 
		for(int i=0; i<nums.length; i++) {
			max = Math.max(nums[i], max);
			min = Math.min(nums[i], min);
		}
		
		// Create an array of buckets 
		bucket[] buckets = new bucket[nums.length-1];
		for(int i=0; i<buckets.length; i++) {
			buckets[i] = new bucket();
		}
		
		// Get Bucket size 
		int width = (max - min)/(nums.length -1);
		
		// fill buckets with min and max values
		for(int i =0; i< nums.length; i++) {
			
			// determine which bucket the current value belongs to
			int index = (nums[i] -min)/width;
			
			// Check if its min or max and add it. 
			buckets[index].min = Math.min(buckets[index].min, nums[i]);
			buckets[index].max = Math.max(buckets[index].max, nums[i]);
			buckets[index].isempty = false;
		}
		
		int gap = 0;
		int maxgap = 0;
		bucket prev = buckets[0];
		
		// Calculate the gap between min and max of consecutive buckets. 
		for(int i=1; i< buckets.length; i++) {
			
			// Need to remember the prev bucket which wasnt empty so prev is ness 
			// Case 1,1
			if(!buckets[i].isempty && !prev.isempty ) {
				gap = buckets[i].min - prev.max;
				prev = buckets[i];
			}
			
			// In case of 0 ,1 
			else if(prev.isempty && !buckets[i].isempty) {
				prev = buckets[i];
			}
			
			maxgap = Math.max(gap, maxgap);
		}
		
		return maxgap;
	}
}
