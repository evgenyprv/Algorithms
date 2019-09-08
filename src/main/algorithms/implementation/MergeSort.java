package main.algorithms.implementation;

import java.util.Comparator;

/**
* This file represents a MergeSort algorithm. It implements SortAlgoritms interface. 
*
* @author: ev_prv
* @since: 1 January 2019
*
*/

import main.algorithms.SortAlgorithms;


public class MergeSort<V> implements SortAlgorithms<V>, Comparator<V>{

	/**	Sorting method. Uses merge() method as a helper. 
	 * 
	 * @param: V[] unsorted_array
	 * @return: V[] array
	 * 
	 */

	@Override
	public V[] sort(V[] unsorted_array){
		if(unsorted_array.length <= 10) {
			SortAlgorithms insertionSort = new InsertionSort();
			return (V[]) insertionSort.sort(unsorted_array);
		}
		
		if(unsorted_array.length == 1){
			return unsorted_array;
		}else{
			int middle = (unsorted_array.length) / 2;
			V[] left_array = (V[]) new Object[middle];
			V[] right_array = (V[]) new Object[unsorted_array.length - middle];
			for(int i = 0; i < left_array.length; i++){
				left_array[i] = unsorted_array[i];
			}
			for(int j = 0; j < right_array.length; j++){
				right_array[j] = unsorted_array[middle + j];
			}
			merge(sort(left_array), sort(right_array), unsorted_array);
			return unsorted_array;
		}

	}
	
	/**	Merge method that merges two unsorted arrays together. Acts as a helper 
	 * to sort() method.  
	 * 
	 * @param: V[] left_array, V[] right_array
	 * @return: V[] array
	 * 
	 */

	public V[] merge(V[] left_array, V[] right_array, V[] unsorted_array){

        int i = 0, j = 0;
        for (int k = 0; k < unsorted_array.length; k++) {
            if(i >= left_array.length) {
            	unsorted_array[k] = right_array[j++];
            }
            else if (j >= right_array.length) {
            	unsorted_array[k] = left_array[i++];
            }
            else if (compare(left_array[i],right_array[j]) <= 0){ 
            	unsorted_array[k] = left_array[i++];
            }
            else {
            	unsorted_array[k] = right_array[j++];
            }
        }
        return unsorted_array;
	}


	@Override
	public int compare(V o1, V o2) {
		if(Math.abs(o1.hashCode()) < Math.abs(o2.hashCode())) {
			return -1;
		}else if(Math.abs(o1.hashCode())  > Math.abs(o2.hashCode())) {
			return 1;
		}else {
			return 0;
		}
	}


}
