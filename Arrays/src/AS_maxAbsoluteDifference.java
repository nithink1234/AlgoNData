/* 
 * Given an unsorted array nums of N integers. Return max value f(i,j) such that i>=1 , j<=N
 * 
 * We will calculate the value of f(i, j) for each pair
of (i, j) and return the maximum value thus obtained.

Input : A = {1, 3, -1}
Output : 5
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
So, we return 5.

Input : A = {3, -2, 5, -4}
Output : 10
f(1, 1) = f(2, 2) = f(3, 3) = f(4, 4) = 0
f(1, 2) = f(2, 1) = |3 - (-2)| + |1 - 2| = 6
f(1, 3) = f(3, 1) = |3 - 5| + |1 - 3| = 4
f(1, 4) = f(4, 1) = |3 - (-4)| + |1 - 4| = 10
f(2, 3) = f(3, 2) = |(-2) - 5| + |2 - 3| = 8
f(2, 4) = f(4, 2) = |(-2) - (-4)| + |2 - 4| = 4
f(3, 4) = f(4, 3) = |5 - (-4)| + |3 - 4| = 10

So, we return 10
 */

public class AS_maxAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
