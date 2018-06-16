/*
 * Given an unsorted array of integers, sort the array into a wave like array. 
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..

Examples:

 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
                 {20, 5, 10, 2, 80, 6, 100, 3} OR
                 any other array that is in wave form

 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
                 {10, 8, 20, 2, 6, 4} OR
                 any other array that is in wave form

 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
                 any other array that is in wave form

 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
                 any other array that is in wave form

 */

import java.util.Arrays;
public class AE_waveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] wave = {10, 5, 6, 3, 2, 20, 100, 80};
		
		int[] result = waveRearrange(wave);
		
		for(int i=0; i<result.length; i++) {
			
			System.out.print(result[i] + " ");
		}
	}
	
	//Solution 1
	// Time O(nlogn) Space O(1)
	// Sort it to ascending order , swap all the elements at odd index with its previous element
	static int[] waveitsort (int[] wave) {
		
		if(wave.length >= 2) {
			Arrays.sort(wave);
			int j=0;
			int temp =0;
			for(int i=1; i< wave.length; i++, j++) {
				
				temp = wave[j];
				wave[j] = wave[i];
				wave[i] = temp;
				
				i++; j++;
			}
		}
		
		return wave;
	}
	
	
	//Soultion 2
	// Time O(n) Space O(1)
	
	// Access the odd elements in the array 
	// Make sure it is the smallest among its previous element and next element, If not swap it.
	// Can also be done by using even element with reverse conditions
	// Have to iterate thru only once. 
	static int[] waveRearrange (int[] wave) {
		
		if(wave.length >= 2) {
			
			int j = 0;
			for(int i=1; i< wave.length; i+=2, j+=2) {
				
				if(wave[j]<wave[i]) {
					swap(wave,j,i);
				}
				
				else if(i+1< wave.length && wave[i]>wave[i+1]) {
					swap(wave, i, i+1);
				}
			}
		}
		
		return wave;
	}
	
	static void swap(int[] wave, int a , int b) {
		
		int temp  =0;
		
		temp = wave[a];
		wave[a] = wave[b];
		wave[b] = temp;
		
	}

}
