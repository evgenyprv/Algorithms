package main.algorithms;


/**
* This file represents a interface for Sorting Algorithms.
*
* @author: ev_prv
* @since: 1 January 2019
*
*/

public interface SortAlgorithms<V> {
	
	/**	Sorting method. 
	 * 
	 * @param: V[] unsorted_array
	 * @return: V[] array
	 * 
	 */
	
	public V[] sort(V[] unsorted_array);

}
