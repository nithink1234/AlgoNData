import java.util.HashMap;

public class AZ_IntegerToWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static HashMap<Integer,String> hm = new HashMap<Integer,String>(); 
	
	static String convertowords (int num) {
		mapfill();
		StringBuilder sb = new StringBuilder();
		
		// Edge case of 0 or -ve num. 
		if(num == 0 || num < 0) {
			return hm.get(0);
		}
		
		// We start from biggest and convert our way down
		// num is greater than billion 
		if(num >= 1000000000) {
			int extra = num/1000000000;
			sb.append(convert(extra));
			sb.append("Billion");
			num = num/1000000000;
		}
		
		// num is greater than Million 
		if(num >= 1000000) {
			int extra = num/1000000;
			sb.append(convert(extra));
			sb.append("Million");
			num = num/1000000;
		}
		
		// num is greater than Thousand 
		if(num >= 1000) {
			int extra = num/1000;
			sb.append(convert(extra));
			sb.append("Thousand");
			num = num/1000;
		}
		
		// in the end the leftover digits. 
		sb.append(convert(num));
		
		return sb.toString();
	}
	
	// this has to convert the three digit 
	static String convert (int num) {
		StringBuilder sb = new StringBuilder();
		
		if(num >= 100) {
			sb.append(hm.get(num/100));
			sb.append("Hundred");
			num = num/100;
		}
		
		if(num >= 20) {
			sb.append(hm.get(num/100));
			sb.append("Hundred");
			num = num/100;
		}
		
		
		if(num <= 20) {
			sb.append(hm.get(num));
		}
		
		return sb.toString();
	}
	
	
	public static void mapfill () {
		
		hm.put(0, "zero");
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");
		hm.put(10, "ten");
		hm.put(11, "eleven");
		hm.put(12, "Tweleve");
		hm.put(13, "Thirteen");
		hm.put(14, "Fourteen");
		hm.put(15, "Fifteen");
		hm.put(16, "Sixteen");
		hm.put(17, "Seventeen");
		hm.put(18, "Eighteen");
		hm.put(19, "Nineteen");
		hm.put(20, "Twenty");
		hm.put(30, "Thirty");
		hm.put(40, "Forty");
		hm.put(50, "Fifty");
		hm.put(60, "Sixity");
		hm.put(70, "Seventy");
		hm.put(80, "Eighty");
		hm.put(90, "Ninety");
		hm.put(100, "Hundred");
	}

}
