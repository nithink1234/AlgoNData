import java.util.*;
public class AH_sortSringsLexciographically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lines = new ArrayList<String>();
		lines.add("a1 9 2 3 1");
		lines.add("g1 act car");
		lines.add("zo4 4 7");
		lines.add("ab1 off key car");
		lines.add("a8 act car");
		
		List<String> result = lexo(lines);
		
		//System.out.println(" ");
		System.out.println("Result: ");
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
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> nums = new ArrayList<String>();
		
		
		for(int i=0; i<lines.size(); i++) {
			ArrayList<String> identifiers = new ArrayList<String>();
			//System.out.println(lines.get(i));
			String[] words  = lines.get(i).split(" ");
			
			// remove the first word. 
			line = lines.get(i).replaceFirst(words[0], "");
			
			if(Character.isLetter(words[1].charAt(0))) {
				
				//System.out.println("line: " + line);
				if(hm.containsKey(line)) {
					identifiers = hm.get(line);
					identifiers.add(words[0]);
					Collections.sort(identifiers);
				}
				
				else {
					identifiers.add(words[0]);
				}
				
				hm.put(line, identifiers);
				
			}
			
			else {
				nums.add(lines.get(i));
			}
			
		}
		
		
		for(String key: hm.keySet()) {
			
			for(int i=0; i<hm.get(key).size(); i++) {
				
				//System.out.println(hm.get(key).get(i));
				result.add(hm.get(key).get(i)  +  key);
			}
			
		}
		
		result.addAll(nums);
		
		return result;
	}
	
}
