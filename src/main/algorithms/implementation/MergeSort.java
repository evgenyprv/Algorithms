package main.algorithms.implementation;

/**
* This file represents a MergeSort algorithm. It implements SortAlgoritms interface. 
*
* @author: ev_prv
* @since: 1 January 2019
*
*/

import main.algorithms.SortAlgorithms;

public class MergeSort implements SortAlgorithms{

	/**	Sorting method. Uses merge() method as a helper. 
	 * 
	 * @param: int[] unsorted_array
	 * @return: int[] array
	 * 
	 */
	
	@Override
	public int[] sort(int[] unsorted_array){
		if(unsorted_array.length <= 10) {
			SortAlgorithms insertionSort = new InsertionSort();
			return insertionSort.sort(unsorted_array);
		}
		
		if(unsorted_array.length == 1){
			return unsorted_array;
		}else{
			int middle = (unsorted_array.length) / 2;
			int[] left_array = new int[middle];
			int[] right_array = new int[unsorted_array.length - middle];
			for(int i = 0; i < left_array.length; i++){
				left_array[i] = unsorted_array[i];
			}
			for(int j = 0; j < right_array.length; j++){
				right_array[j] = unsorted_array[middle + j];
			}
			return merge(sort(left_array), sort(right_array));
		}

	}
	
	/**	Merge method that merges two unsorted arrays together. Acts as a helper 
	 * to sort() method.  
	 * 
	 * @param: int[] left_array, int[] right_array
	 * @return: int[] array
	 * 
	 */
	
	public int[] merge(int[] left_array, int[] right_array){

		int[] result = new int[left_array.length + right_array.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            if(i >= left_array.length) {
            	result[k] = right_array[j++];
            }
            else if (j >= right_array.length) {
            	result[k] = left_array[i++];
            }
            else if ((left_array[i]) <=  right_array[j]){ 
            	result[k] = left_array[i++];
            }
            else {
            	result[k] = right_array[j++];
            }
        }
        return result;
	}
}
