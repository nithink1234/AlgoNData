/*
 * Given an integer, write a function to determine if it is a power of two.

Example 1: Input: 1 Output: true

Example 2: Input: 16 Output: true

Example 3: Input: 218 Output: false
 */

public class AU_powerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(power2(8));
	}

	//Wont get ans with srqrt of 2 because its 2^n ..So 8 is valid 
	//So divide by 2 until u get 2.. then its valid
	static boolean power2 (int n) {
		double num = n;
		if(n == 1)
			return true;
		
		while(num >= 2) {
			
			if(num == 2.0)
				return true;
			
			num = num/2;
		}
		
		return false;
	}
}
