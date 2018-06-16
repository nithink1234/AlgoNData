/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


 */
import java.util.*;
public class FB_rotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static void rotate(int[][] matrix) {
		
		// Considering all squares within squares one by one 
		int n=matrix.length;
		for (int i=0; i<n/2; i++) {
    	
			// Considering the current square
			for (int j=i; j<n-i-1; j++) {
				
				//Copy the current element;
				int tmp=matrix[i][j];
				
				// move element from bottom to top
				matrix[i][j]=matrix[n-j-1][i];
				
				// move element from right to left
				matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
				
				// move element from top to bottom 
				matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
				
				// move element from start to top
				matrix[j][n-i-1]=tmp;
            }
		}
        
	}
	
}
