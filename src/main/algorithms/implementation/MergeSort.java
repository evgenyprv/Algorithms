package main.algorithms.implementation;

import main.algorithms.SortAlgorithms;

public class MergeSort implements SortAlgorithms{

	@Override
	public Object[] sort(Object[] unsorted_array){
		
		if(unsorted_array.length == 1){
			return unsorted_array;
		}else{
			int middle = (unsorted_array.length) / 2;
			Object[] left_array = new Object[middle];
			Object[] right_array = new Object[unsorted_array.length - middle];
			for(int i = 0; i < left_array.length; i++){
				left_array[i] = unsorted_array[i];
			}
			for(int j = 0; j < right_array.length; j++){
				right_array[j] = unsorted_array[middle + j];
			}
			return merge(sort(left_array), sort(right_array));
		}

	}
	
	public Object[] merge(Object[] left_array, Object[] right_array){

		Object[] result = new Object[left_array.length + right_array.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            if(i >= left_array.length) {
            	result[k] = right_array[j++];
            }
            else if (j >= right_array.length) {
            	result[k] = left_array[i++];
            }
            else if (((Comparable) left_array[i]).compareTo((Comparable) right_array[j])) <= 0){ 
            	result[k] = left_array[i++];
            }
            else {
            	result[k] = right_array[j++];
            }
        }
        return result;
	}
}
