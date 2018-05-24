import java.util.*;
public class Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums  = {2,3,2,4,3,4,1,5,5};
		
		System.out.println(single_number(nums));
		
	}
	
	// Time = O(n) Space = O(1)
	static int single_num(int[] nums) {
		
		// If the array is null return 0
		if(nums.length ==0) {
			return 0;
		}
		// if the array has only 1 element return that element 
		else if (nums.length == 1) {
			return nums[0];
		}
		
		int singlenum =0;
		
		// XOR(^) .. a^0 = a .. a^a =0  ... a^b^a = b ... 
		// Therefore Xor all elements to get unique one.. Works only for int 
		// For char we have array[128] boolean ..  For Strings ?? 
		for(int i=0; i<nums.length; i++) {
			singlenum = singlenum^nums[i];
		}
		
		return singlenum;
	}
	
	
	// Time O(n) Space O(n)
	public static int single_number(int[] nums) {
		
		// If the empty array return 0
		if(nums.length == 0)
			return 0;
		// If array has only one element return 1
		else if(nums.length == 1) {
			return nums[0];
		}
		

		HashSet<Integer> hs = new HashSet<Integer>();
		
		//Iterate through the array 
		for(int i=0; i<nums.length; i++) {
			
			// Remove element from hashset if already present i.e appears twice otherwise add it
			if(hs.contains(nums[i])) {
				hs.remove(nums[i]);
			}
			
			else {
				hs.add(nums[i]);
			}
		}
		
		// In the end will contain only 1 element i.e unique element. 
		Iterator<Integer> it = hs.iterator();
		
		while(it.hasNext()) {
			return it.next();
		}
		
		return 1;
	}

}
