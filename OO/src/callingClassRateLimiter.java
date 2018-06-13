
public class callingClassRateLimiter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*if (rateLimitert.isAllowed()) {
			 // expensiveCall();
			}
		*/
	}
	
	
	class rateLimiter{
		
		int rateLimiter = 100; 
		 int count = 0; 
		 long tend = 0;
		 long tstart = 0;

		public boolean isAllowed() {

		tend = System.currentTimeMillis();

		if((tend - tstart)< 1000){
		    if(count <= rateLimiter){
		         count++;
		         return true;
		}

		return false;
		}

		else if(count == 0 || (tend -tstart) >= 1000) {
		    count = 1;
		    tstart = System.currentTimeMillis();
		    return true;
		}

		return false;
		 }
		
	}
		 

	

	
}
