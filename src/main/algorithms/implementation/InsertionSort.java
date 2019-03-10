package main.algorithms.implementation;

import java.util.Comparator;

/**
* This file represents a MergeSort algorithm. It implements
* SortAlgoritms interface. 
*
* @author: ev_prv
* @since: 1 January 2019
*
*/

import main.algorithms.SortAlgorithms;


public class InsertionSort<V> implements SortAlgorithms<V>, Comparator<V> {
	
	/**	Sorting method. 
	 * 
	 * @param: V[] unsorted_array
	 * @return: V[] array
	 * 
	 */
	
	@Override
	public V[] sort(V[] unsorted_array) {
		int len = unsorted_array.length;
		for(int i = 0; i < len; i++) {
			V key = unsorted_array[i];
			int j = i - 1;
			
			while (j >= 0 && (compare(key,unsorted_array[j]) <=0 )) {
				unsorted_array[j + 1] = unsorted_array[j];
				j--;
			}
			unsorted_array[j+1] = key;
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
