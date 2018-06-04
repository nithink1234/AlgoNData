/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

import java.util.*;
public class AW_spiralOrderMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static List<Integer> sprialtrav (int[][] matrix){
		List<Integer> ans = new ArrayList<Integer>();
		
		if (matrix.length == 0)
	        return ans;
	    
		int rstart = 0;
	    int rend = matrix.length - 1;
	    int cstart = 0; 
	    int cend = matrix[0].length - 1;
	    
	    while (rstart <= rend && cstart <= cend) {
	            
	    	//traverse first row from remaining rows
	    	for (int i = cstart; i <= cend; i++) {
	    		ans.add(matrix[rstart][i]);
	    	}
	            
	    	//Traverse last column from remaining columns
	    	for (int i = rstart + 1; i <= rend; i++) {
	    		ans.add(matrix[i][cend]);
	    	}
	    	
	            
	    	if (rstart < rend && cstart < cend) {
	            
	    		//Traverse the last row right to left 
	    		for (int i = cend - 1; i > cstart; i--) {
	    			ans.add(matrix[rend][i]);
	    		}
	    		
	    		// Traverse the first column down to top
	            for (int i = rend; i > rstart; i--) {
	                ans.add(matrix[i][cstart]);
	            }
	        }
	    		rstart++;
	            rend--;
	            cstart++;
	            cend--;
	        }
	        
	        return ans;
	}
	
	static List<Integer> spiral (int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		int rowstart = 0;
		int rowend = matrix.length; // no of rows in matrix  
		int colstart = 0;
		int colend = matrix[0].length;// Number of elements in 1st row: column
		
		while(rowstart < rowend && colstart < colend) {
			
			//traverse first row from remaining rows	
			for(int i= colstart; i<colend; ++i) {
				result.add(matrix[rowstart][i]);
			}
			rowstart++;
			
			//Traverse last column from remaining columns
			for(int i= rowstart; i<rowend; ++i) {
				result.add(matrix[i][colend-1]);
			}
			colend--;
			
			// Traverse the last row right to left 
			if(rowstart<rowend) {
				for(int i=colend-1; i>=colstart; --i) {
					result.add(matrix[rowend-1][i]);
				}
				rowend--;
			}
			
			if(colstart<colend) {
				for(int i=rowend-1; i>=rowstart; --i) {
					result.add(matrix[i][colstart]);
				}
				colstart--;
			}
		}
		
		
		return result;
	}
			
}
