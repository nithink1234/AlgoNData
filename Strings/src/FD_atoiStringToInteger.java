/*
 * Dumbass Problem. 
 */
public class FD_atoiStringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// "42"  // "   -42"// "-000000000000000000000000000000284" // "4193 with words" // "words and 987" //
		//"-91283472332" // "+" // 
		System.out.println(myatoi("+"));
	}

	static int myatoi(String str) {
		int result = 0;
		int sign = 1;
		int index = 0;
		
		// Takes care of Leading and trailing Whitespaces 
		str = str.trim();
		
		// Empty String 
		if(str.isEmpty())
			return result;
		
		//Handles Signs 
		if(str.charAt(0) == '-') {
			sign = -1;
			index++;
		}
		else if(str.charAt(0) == '+')
			index++;
		
		//When first digit after sign is not digit
		if(index < str.length() && Character.isDigit(str.charAt(index))){
			
			// Gets only the number 
			for(int i= index; i<str.length(); i++) {
				if(!Character.isDigit(str.charAt(i)))
					str = str.substring(0, i);
			}

			//Leading Zeros
			for(int i= index; i<str.length(); i++) {
				if(str.charAt(i) == '0')
					index++;
				
				if(str.charAt(i) != '0') {
					str = str.substring(index);
					break;
				}
			}
			
			
			// handling Overflow
			if((str.length()> 19 && (str.charAt(0) == '+' || Character.isDigit(str.charAt(0)))) || Double.parseDouble(str) >= Integer.MAX_VALUE)
				result = Integer.MAX_VALUE;
			
			// In case its smaller than size of int and is negative 
			else if((str.length()> 19 && (str.charAt(0) == '-' || Character.isDigit(str.charAt(0)))) || Double.parseDouble(str) <= Integer.MIN_VALUE)
				result =  Integer.MIN_VALUE -1;
			
			else {
				result = Integer.parseInt(str);
			}
		}
		
		return result * sign;
	}
	
}
