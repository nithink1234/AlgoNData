/*
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.


 */

import java.util.Arrays;

public class EB_Plus_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// o(n)
	static int[] plusone(int[] digits) {
		
		int i = digits.length -1;
		int sum = 0;
		
		while(true) {
			
			// Add 1 when it is within range of array
			if(i >= 0)
				sum = digits[i] + 1;
			// In case its 999 .. increase length by 1 n return 1000
			else {
				int[] result = new int[digits.length + 1];
				result[0] = 1 ;
				
				result = Arrays.copyOfRange(digits, 1 , digits.length-1);
				
				return result;
			}
			
			// if number is less than 10 just add n return
			if(sum < 10) {
				digits[i] = sum;
				return digits;
			}
			
			// if its 10 make it 0 n carry 1
			else {
				digits[i] = 0;
				i--;
			}			
		}	
	}
}
