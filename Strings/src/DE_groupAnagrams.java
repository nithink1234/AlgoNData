
import java.util.*;
public class DE_groupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	static List<List<String>> groupAnagrams(String[] strs){
		
		if (strs.length == 0) return new ArrayList();
		
		HashMap<int[] , ArrayList<String>> hm = new HashMap<int[] , ArrayList<String>>();
		
		int[] letters = new int[26];
		
		for(int i=0; i<strs.length; i++) {
			Arrays.fill(letters, 0);
			
			for(int j=0; j<strs[i].length(); j++) {
				letters[strs[i].charAt(j) -'a'] =  letters[strs[i].charAt(j) -'a'] +1;
			}
			
			if(!hm.containsKey(letters)) {
				hm.put(letters, new ArrayList<String>());
			}
			hm.get(letters).add(strs[i]);
		}
		
		return new ArrayList(hm.values());
	}

}
