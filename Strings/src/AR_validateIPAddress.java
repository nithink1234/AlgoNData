/*
 * https://leetcode.com/problems/validate-ip-address/description/ 
 */
public class AR_validateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(valid("12..33.4"));
	}
	
	static String valid(String IP) {
		
		// if string contains . its a ip4 address 
		if(IP.contains(".")) {	
			if(validateIP4(IP.split("\\."))){
				return "IP4";
			}
		}
		
		// same for IP6 :
		else if(IP.contains(":")) {
			
			if(validateIP6(IP.split("\\:")))
				return "IP6";
		}
		
		return "Neither";
	}

	static boolean validateIP4(String[] ip) {
		
		boolean nonzero = false;
		// Must Contain 4 numbers
		if(ip.length!= 4)
			return false;
		
		for(int i=0; i<ip.length; i++) {
			
			if(ip[i].isEmpty() || ip[i].length()>3)
				return false;
			
			// To check if there are letters and detecting leading zeros 
			nonzero = false;
			for(int j=0; j<ip[i].length(); j++) {
				
				//if it contains letters or anything else 
				if(!Character.isDigit(ip[i].charAt(j)))
					return false;
				
				// if 0 comes before a non zero digit return false 
				if(ip[i].charAt(j) == '0' && !nonzero)
					return false;
				
				// else mark non zero true;
				else if(ip[i].charAt(j) != '0')
					nonzero =true;
			}
			
			// Each value must be within 0 - 255
			if(Integer.parseInt(ip[i]) <0 || Integer.parseInt(ip[i]) > 255) 
				return false;
			
		}
		
		return true;
	}
	
	static boolean validateIP6(String[] ip) {
		
		// Must Contain 8 numbers
		if(ip.length!= 8)
			return false;
		
		for(int i=0; i<ip.length; i++) {
			
			// In case of Extra leading 0's or numbers
			if(ip[i].length() > 4)
				return false;
			
			// To validate if each digit is Hexadecimal (alphanumeric) only 
			for(int j=0; j<ip[i].length(); j++) {
				
				if(!Character.isLetterOrDigit(ip[i].charAt(j)))
					return false;
				
			}
			
		}
		
		return true;
	}
}
