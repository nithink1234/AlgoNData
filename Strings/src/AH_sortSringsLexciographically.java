import java.util.*;
public class AH_sortSringsLexciographically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lines = new ArrayList<String>();
		lines.add("a1 9 2 3 1");
		lines.add("g1 act car");
		lines.add("zo4 4 7");
		lines.add("ab1 off key car");
		lines.add("a8 act zoo");
		
		List<String> result = lexo(lines);
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	// get each line from the log file 
	// For each line split it in spaces and remove the identifier at the start and make the rest a string
	
	// Check if string is nums or words by checking the ascii value of the first letter
	// or we could try Integer parse in a try catch block .. if there is a exception then its a word. 
	
	// Add the string to a treemap(sorts it on insertion) and its identifier as value in the form of list
	// in case of duplicate string add its identifier to list and sort it 
	// build the line by extracting the line and adding its identifiers
	static List<String> lexo(List<String> lines){
			
		String line ;
		TreeMap<String, ArrayList<String>> hm = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> identifiers = new ArrayList<String>();
		ArrayList<String> nums = new ArrayList<String>();
		
		
		for(int i=0; i<lines.size(); i++) {
			System.out.println(lines.get(i));
			String[] words  = lines.get(i).split(" ");
			
			System.out.println(words[0]);
			line = words.toString();
			
			//System.out.println(line);
			
			if(checkifwords(words)) {
				
				if(hm.containsKey(line)) {
					identifiers = hm.get(line);
					Collections.sort(identifiers);
				}
				
				identifiers.add(words[0]);
				hm.put(line, identifiers);
			}
			
			else {
				nums.add(line);
			}
			
			identifiers.clear();
		}
		
		for(String key: hm.keySet()) {
			
			for(int i=0; i<hm.get(key).size(); i++) {
				identifiers.add(hm.get(key).get(i) + key);
			}
			
		}
		
		identifiers.addAll(nums);
		
		return identifiers;
	}
	
	
	static boolean checkifwords(String[] words) {
		
		int num = 0;
		
		if(words.length > 1) {
			String word = words[1];
			
			if(!word.isEmpty()) {
				num = (int)word.charAt(0);
			}
			
			if(num > 64 && num<123)
				return true;
		}
		
		return false;
	}
}
