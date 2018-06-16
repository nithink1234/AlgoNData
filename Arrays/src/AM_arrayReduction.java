
import java.util.*;
public class AM_arrayReduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4};
		System.out.println(reduction(nums));
	}

	static int  reduction(int[] num) {
		
		if(num.length == 1)
			return num[0];
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<num.length; i++) {
			pq.add(num[i]);
		}
		
		int sum = 0 ;
		int num1 = 0;
		int num2 = 0;
		int cost = 0;
		
		while(pq.size() > 1) {
			
			num1 = pq.poll();
			num2 = pq.poll();
			
			sum = num1 + num2;
			cost += sum;
			
			pq.add(sum);
		}
		
		return cost;
		
		
	}
	
	
	static int reductiononline(int [] num) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for(int i=0; i<num.length; i++) {
			priorityQueue.add(num[i]);
		}
        int sum = priorityQueue.poll();
        int cost = 0;
        
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } 
            else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
        }
        
        return cost;
	}
}
