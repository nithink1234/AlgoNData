/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

Example 1: Input: [10,2] Output: "210"
Example 2: Input: [3,30,34,5,9] Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.
   0 1-9 10 13543..
 */
import java.util.*;

// Comparator .. Just add the two elements in straight and reverse order and compare both 
// Note that even though u add the elements here .. it just for comparision 
// When it returns it just sorts the original elements.
class sortit implements Comparator<String>{
	
	public int compare(String a , String b) {
	
		String s1 = a+b;
		String s2 = b+a;
		
		return s2.compareTo(s1);
	}
}


public class CB_largestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,0,0,0};
		
		System.out.println(largeNum(nums));
	}

	// Conevrt all nums to string 
	static String largeNum(int[] nums) {
		
		String[] nums_string = new String[nums.length];
		
		// Convert num to string
		for(int i=0; i<nums.length; i++) {
			nums_string[i] = String.valueOf(nums[i]);
		}
		
		// Sort it according in decreasing order by comparing Msb of both elements 
		sortit sorting = new sortit();
		Arrays.sort(nums_string, sorting);
		
		// Edge case when array contains only 0's then instead of returning 0000 return 0
		if(nums_string[0].equals("0")){
			return "0";
		}
		
		// add the string now that its in proper order and return. 
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< nums_string.length; i++) {
			
			//System.out.println(nums_string[i]);
			sb.append(nums_string[i]);
		}
		
		return sb.toString();
	}
}
