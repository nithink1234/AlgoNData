/*
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.


 */
import java.util.*;
class Interval {
	
	int start;
	int end;
	
	Interval(){
		start = 0;
		end = 0;
	}
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class BA_mergeIntervels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1,4));
		input.add(new Interval(2,3));
		//input.add(new Interval(8,10));
		//input.add(new Interval(15,18));
		
		List<Interval> result = new ArrayList<Interval>();
		
		result = merge(input);
		
		for(int i=0; i< result.size(); i++) {
			System.out.println(result.get(i).start + " : " + result.get(i).end);
		}
		
	}
	
	static List<Interval> merge(List<Interval> intervals){
		
		// Sort the intervals by start times. If the start times are same then sort by end times. 
		Collections.sort(intervals, new Comparator<Interval>() {
			
			public int compare(Interval a, Interval b) {
				
				// Sort by start times
				if(a.start > b.start)
					return 1;
				else if(a.start < b.start)
					return -1;
				
				// if start times are same then sort by end times
				else {
					
					if(a.end > b.end)
						return 1;
					else if(a.end < b.end)
						return-1;
				}
				
				return 0;
			}
		});
		
		
		int i= 0;
		while(i<intervals.size()) {
			
			// When they overlapp merge it. 
			// Remove the 2nd interval which has been merged.
			if( i+1 < intervals.size() && intervals.get(i).end >= intervals.get(i+1).start) {
				
				// Only when the second interval end is bigger than first interval end we need to update the end of merged
				if(intervals.get(i+1).end > intervals.get(i).end)				
					intervals.get(i).end = intervals.get(i+1).end;
				
				// otherwise if second interval is completley within the first then we just have to remove it
				intervals.remove(i+1);
			}
			
			// go to next element only when its not overlapping
			else {
				i++;
			}
		}
		
		return intervals;
	}

}
