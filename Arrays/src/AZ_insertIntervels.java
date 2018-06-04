/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */

import java.util.*;

public class AZ_insertIntervels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1,5));
		//input.add(new Interval(3,5));
		//input.add(new Interval(6,7));
		//input.add(new Interval(8,10));
		//input.add(new Interval(12,16));
		
		List<Interval> result = new ArrayList<Interval>();
		
		result = insertit(input,new Interval(2,3));
		
		for(int i=0; i< result.size(); i++) {
			System.out.println(result.get(i).start + " : " + result.get(i).end);
		}
	}

	static List<Interval> insertit (List<Interval> intervals, Interval newInterval){
		
		
		for(int i=0; i< intervals.size(); i++) {
		
			//System.out.println(i);
			if(i>0 && intervals.get(i).start >= newInterval.start) {
				//System.out.println(i);
				intervals.add(i, newInterval);
				break;
			}
			else if(i==0 && intervals.get(i).start >= newInterval.start) {
				intervals.add(0, newInterval);
				break;
			}
			
			// If you dont add break , it will keep adding forever
			if(i== intervals.size()-1) {
				intervals.add(intervals.size(),newInterval);
				break;
				}
				
		}
		
		for(int i=0; i<intervals.size(); i++) {
			System.out.println(i  + " : " +  intervals.get(i).start + ": " + intervals.get(i).end);
		}
		
		int i= 0;
		while(i<intervals.size()) {
			
			if(i+1 < intervals.size() && intervals.get(i).end >= intervals.get(i+1).start ) {
				
				//System.out.println(i  + " : " +  intervals.get(i).end + ": " + intervals.get(i+1).start);
				if(intervals.get(i).end <= intervals.get(i+1).end)
					intervals.get(i).end = intervals.get(i+1).end;
				
				intervals.remove(i+1);
			}
			
			else {
				i++;
			}
		}
		
		// In Case when interval is null but there is a new interval to be added 
		// In case when new interval is also null just return. 
		if(intervals.size() == 0 && newInterval != null)
			intervals.add(newInterval);
		
		return intervals;
	}
}
