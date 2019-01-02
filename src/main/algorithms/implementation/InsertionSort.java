package main.algorithms.implementation;

/**
* This file represents a MergeSort algorithm. It implements
* SortAlgoritms interface. 
*
* @author: ev_prv
* @since: 1 January 2019
*
*/

import main.algorithms.SortAlgorithms;

public class InsertionSort implements SortAlgorithms {
	
	/**	Sorting method. 
	 * 
	 * @param: int[] unsorted_array
	 * @return: int[] array
	 * 
	 */
	
	@Override
	public int[] sort(int[] unsorted_array) {
		int len = unsorted_array.length;
		for(int i = 0; i < len; i++) {
			int key = unsorted_array[i];
			int j = i - 1;
			
			while (j >= 0 && (key <= unsorted_array[j])) {
				unsorted_array[j + 1] = unsorted_array[j];
				j--;
			}
			unsorted_array[j+1] = key;
		}
		
		return unsorted_array;
	}

}
