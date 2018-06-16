/*
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

 */
public class CC_maxUnsortedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {2, 6, 4, 8, 10, 9, 15};
		
		System.out.println(shortestUnsortedContinousSubarry(num));
	}

	
	static int shortestUnsortedContinousSubarry(int[] nums) {
		int length = 0;
		int lowerlimit = 0;
		int upperlimit = 0;
		int i = 1; 
		
		// find lower limit
		for( lowerlimit = 0; lowerlimit< nums.length-1; lowerlimit++ ){
			
			if(nums[lowerlimit] > nums[lowerlimit+1])
				break;
		}
		
		// incase array is sorted 
		if(lowerlimit == nums.length -1)
			return 0;
		
		System.out.println(lowerlimit);
		
		// find upper limit
		for( upperlimit = nums.length-1; upperlimit > 0; upperlimit-- ){
			
			if(nums[upperlimit] < nums[upperlimit-1])
				break;
		}
		
	    System.out.println(upperlimit);
		// Find max and min within these limits
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int j= lowerlimit; j<= upperlimit; j++) {
			
			max = Math.max(nums[i], max);
			min = Math.min(nums[i], min);
		}
		
		// 
		int j = 0;
		for(j=0 ; j<=lowerlimit; j++) {
			
			if(nums[j] > min)
				break;
		}
		
		int k = 0;
		for(k= nums.length-1; k>=upperlimit; k--) {
			
			if(nums[k] < max)
				break;
		}
		
		length = k-j;
		
		return length;
	}
}
