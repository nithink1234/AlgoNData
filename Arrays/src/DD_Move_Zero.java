/*
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

 */


public class DD_Move_Zero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Two pointer Method .. Time O(n) Space O(1) 
	static void move_1 (int[] nums) {
		
		int j = 0;
		
		// Copy all non 0 numbs to start of arry 
		// j will keep count of nums of zeros 
		for(int i=0; i< nums.length; i++) {
			
			if(nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		
		// add j number of zeros to end of array
		for(int i=j ; i<nums.length; i++) {
			
			nums[i] = 0;
		}
		
	}
	
	
	
	// Time O(n2) 
	static void move (int[] nums) {

		// Look for zero in the array
        for(int i=0; i<nums.length; i++) {
            
        	// When u find it
            if(nums[i] == 0) {
                
            	// find the next not zero integer
                for(int j=i; j<nums.length; j++) {
                    
                	// swap the positions. 
                	if(nums[j] !=0) {
                		nums[i] = nums[j];
                		nums[j] = 0;
                		break;
                	}
                }
            }
        }
        
        
	}

}
