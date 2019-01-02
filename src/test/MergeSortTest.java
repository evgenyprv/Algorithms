package test;

/**
* This file represents a Test files. Its focus is to test MergeSort algorithms
* and LinkedList data structure. 
*
* @author: ev_prv
* @since: 2 January 2019
*
*/

import java.util.Random;

import main.algorithms.SortAlgorithms;
import main.algorithms.implementation.MergeSort;
import main.datastructure.implementation.LinkedList;

public class MergeSortTest {
	
	/** 
	 * TestOne focus on testing MergeSort on the List of max size 100.
	 */
	
	public void testOne() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Random random = new Random();
		int len = random.nextInt(100);
		
		System.out.println("List size: " + len);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(random.nextInt(100));
		}
		
		System.out.println(linkedList.toString());
		
		int[] mergeSortArray = new int[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort mergeSort = new MergeSort();
		
		int[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	/** 
	 * TestTwo focus on testing MergeSort on the List of max size 10.
	 * Specifically since it is faster to do InsertionSort on list of size 10 or less
	 * we are testing if MergeSort will call the InsertionSort algorithm. 
	 */
	
	public void testTwo() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Random random = new Random();
		int len = random.nextInt(10);
		
		System.out.println("List size: " + len);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(random.nextInt(100));
		}
		
		System.out.println(linkedList.toString());
		
		int[] mergeSortArray = new int[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort mergeSort = new MergeSort();
		
		int[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		MergeSortTest test = new MergeSortTest();
		
		test.testOne();
		test.testTwo();
	}

}
