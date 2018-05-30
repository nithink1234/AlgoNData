import java.util.*;

// Comparator Class defining how to sort the string lines 
// In case it isn't defined in main class 
class sortItLexico implements Comparator<String>{
	
	public int compare(String a, String b) {
		String data1 = a.substring(a.indexOf(" ")); 
		String header1 = a.substring(0, a.indexOf(" "));
		
		String data2 = b.substring(b.indexOf(" ")); 
		String header2 = b.substring(0, b.indexOf(" "));
		
		if(data1.compareTo(data2) == 0)
			return header1.compareTo(header2);
		
		return data1.compareTo(data2);
		
	}
}

public class AC_lexicograhicalSortingComparator {

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

	
	
	static List<String> lexo(List<String> lines) {
		
		List<String> result = new ArrayList<String>();
		
		// Split the lines into two lists 
		// One containing only lines with words which we will sort 
		// the other containing lines with numbers. 
		
		// Checking null case
		if(!lines.isEmpty()) {
			
			List<String> nums = new ArrayList<String>();
			
			for(int i=0; i<lines.size(); i++) {
				
				String[] words = lines.get(i).split(" ");
				
				if(Character.isLetter(words[1].charAt(0))) {
					result.add(lines.get(i));
				}
				
				else {
					nums.add(lines.get(i));
				}
			}
			
			// If the compare method is defined outside this class 
			//Then we need to create of object of the class where it is defined and pass it to collections to sort 
			
			//sortItLexico sortit = new sortItLexico();
			//Collections.sort(result, sortit);
			
			
			// The other way is to define our custom sorting method here 
			Collections.sort(result, new Comparator<String>() {
				
				public int compare(String a, String b) {
					
					// Separate the header and data of first line
					String data1 = a.substring(a.indexOf(" ")); 
					String header1 = a.substring(0, a.indexOf(" "));
					
					// Separate the header and data of second line
					String data2 = b.substring(b.indexOf(" ")); 
					String header2 = b.substring(0, b.indexOf(" "));
					
					//  if data of both lines are same then sort it by comparing header's
					if(data1.compareTo(data2) == 0)
						return header1.compareTo(header2);
					
					// otherwise sort it by comparing the data line
					return data1.compareTo(data2);
					
				}
			});
			
			// Add all the lines containing numbers
			result.addAll(nums);
		}
		
		
		return result;
	}
}
