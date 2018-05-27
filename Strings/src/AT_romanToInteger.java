import java.util.*;
public class AT_romanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(romantoint(""));
	}
	
	static int romantoint(String s) {
		
		if(s.isEmpty())
			return 0;
		
		int result = 0;
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);

		
		for(int i=0; i<s.length() -1; i++) {
			
			if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))) {
				result -= hm.get(s.charAt(i));
			}
			else {
				result += hm.get(s.charAt(i));
			}
		}
		
		return result + hm.get(s.charAt(s.length()-1));
	}

}
