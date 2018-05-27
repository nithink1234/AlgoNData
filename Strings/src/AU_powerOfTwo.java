
public class AU_powerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(power2(8));
	}

	static boolean power2 (int n) {
		double num = n;
		if(n == 1)
			return true;
		
		while(num >= 2) {
			
			if(num == 2.0)
				return true;
			
			num = num/2;
		}
		
		return false;
	}
}
