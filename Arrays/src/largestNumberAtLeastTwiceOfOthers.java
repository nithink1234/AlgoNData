/*In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
*/

public class largestNumberAtLeastTwiceOfOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3, 6, 1, 0};
		
		System.out.println(dominantIndex(nums));
	}

	// Time O(n)  Space O(1)
	static int dominantIndex(int[] nums) {
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			if(nums[i] > max) {
				max = nums[i];
				index = i;
			}
				
		}
		
		for(int i=0; i<nums.length; i++) {
			
			if((nums[i] > max/2) &&( i!= index))
				return -1;
		}
		
		return index;
	}
}
