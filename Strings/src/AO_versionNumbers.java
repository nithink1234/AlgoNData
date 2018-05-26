/*
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1; 
if version1 < version2 return -1;
otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1: Input: version1 = "0.1", version2 = "1.1" Output: -1

Example 2: Input: version1 = "1.0.1", version2 = "1" Output: 1

Example 3: Input: version1 = "7.5.2.4", version2 = "7.5.3" Output: -1
*/


import java.util.regex.Pattern;
public class AO_versionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(versionin("1.0","1"));
	}
	
	//Time O(n)  Space O(1)
	// Insane
	static int versionin(String version1, String version2) {
		
		// Split the string on . .. use \\. as pattern or Pattern.quote(.) 
		 String[]v1=version1.split("\\.");
		 String[]v2=version2.split("\\.");
	     int i;
	     
	     // check all the numbers from first till the shortest length version
	     // As long as its not equal , result can be given one way of the other 
	     // eg 0.1 & 1.1   7.5.2.4 & 7.5.3
	     for(i =0; i<v1.length && i<v2.length; i++) {
	    	 
	    	 if(Integer.parseInt(v1[i]) != Integer.parseInt(v2[i])) {
	    		 
	    		 if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i]))
	    			 return 1;
	    		 else
	    			 return -1;			 
	    	 }
	     }

	     // If v1 is longer and its consicutive numbers are not 0 
	     // That means its bigger no matter the numbers
	     // eg 1.0.1 && 1  
	     // Note : it wont count if its 1.0 && 1 as we have excluded 0 
	     for(;i<v1.length;i++) {
	    	 if(Integer.parseInt(v1[i])!=0)
	    		 return 1;
	     }
	     
	     // Same for v2
	     for(;i<v2.length;i++) {	    	 
	    	 if(Integer.parseInt(v2[i])!=0)
	    		 return -1;
	     }
	     
	     // In case its equal or if its 
	     // 1.0 && 1 
	     return 0;
	}
	
	// Mine .. Wont cover the case when its 1.0 and 1 
	static int version(String s1, String s2) {
		
		String[] s1num = s1.split(Pattern.quote("."));
		String[] s2num = s2.split(Pattern.quote("."));	
		
		if(s1num.length > s2num.length) {
			
			for(int i=0, j=0; i<s1num.length; i++,j++) {
				if( i<s2num.length) {
					if(Integer.parseInt(s1num[i]) >  Integer.parseInt(s2num[j]))
						return 1;
					else if(Integer.parseInt(s1num[i]) <  Integer.parseInt(s2num[j]))
						return -1;
				}

				else {
					return 1;
				}
			}
		}
			
		else {
			
			for(int i=0, j=0; i<s2num.length; i++,j++) {
				
				if( j<s1num.length) {
					if(Integer.parseInt(s2num[i]) >  Integer.parseInt(s1num[j]))
						return -1;
					else if(Integer.parseInt(s2num[i]) <  Integer.parseInt(s1num[j]))
						return 1;
				}

				else {
					return -1;
				}
			}
		}
		
		return 0;
	}
	

}
