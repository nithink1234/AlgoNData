/*
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


 */

public class AB_binarySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(addBinary("", ""));
	}
	
	// Check which length is bigger and send that first 
	// Makes things easier 
	static String addBinary(String a, String b) {
		
		if(a.length() > b.length()) {
			
			return addit(a,b);
		}
		
		return addit(b,a);

	}
	
	// a will be bigger or at least as big as b
	
	static String addit (String a , String b) {
		
		StringBuilder sb = new StringBuilder();
		
		int i = a.length()-1;
		int j = b.length()-1;
		int num =0;
		int carry = 0;
		
		while(i>=0 || j>=0) {
			
			// As long as the smaller number is still there 
			// Add Digits
			if(j>=0) {
				num = add2nums(Character.getNumericValue(a.charAt(i)) , Character.getNumericValue(b.charAt(j)), carry);
				j--;
				i--;
			}
			
			// When the smaller number is done
			// Add if there is still carry else right the rest
			else if ( j< 0 && i>=0) {
				num = add2nums(Character.getNumericValue(a.charAt(i)) , 0, carry);
				i--;
			}
			
			// Only 4 cases possible 
			// sum is 10 or 11 .. in case carry 1 and append the other
			// sum is 0 or 1 .. in which case just append it 
			if(num == 10) {
				sb.append(0);
				carry = 1;
			}
			
			else if (num == 11) {
				sb.append(1);
				carry = 1;
			}
			
			else {
				sb.append(num);
				carry =0;
			}
			
				
		}
		
		// In some cases there might be left over carry like 11 + 1 
		// add that
		if(carry == 1)
			sb.append(1);
		
		// it will be added in reverse i.e 11 + 1 = 001.. so reverse it
		return sb.reverse().toString();
		
	}
	
	// doing the binary addition
	static int add2nums(int a, int b, int c) {
		
		if( (a == 1 && b == 1 && c == 0) || (a == 0 && b == 1 && c == 1) || (a == 1 && b == 0 && c == 1) )
			return 10;
		
		if(a == 1 && b == 1 && c == 1)
			return 11;
		
		return a + b +c;
	}
}
