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

import main.algorithms.implementation.MergeSort;
import main.datastructure.implementation.LinkedList;

public class MergeSortTest {
	
	/** 
	 * TestOne focus on testing MergeSort on an empty List.
	 */
	
	public void testOne(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		int len = 0;
		
		System.out.println("List size: " + len);

		System.out.println(linkedList.toString());
		
		Integer[] mergeSortArray = new Integer[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<Integer> mergeSort = new MergeSort<>();
		
		Integer[] result = mergeSort.sort(mergeSortArray);
		
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
		
		Integer[] mergeSortArray = new Integer[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<Integer> mergeSort = new MergeSort<>();
		
		Integer[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	
	/** 
	 * TestThree focus on testing MergeSort on the List of max size 10 using Character Wrapper class.
	 * Specifically since it is faster to do InsertionSort on list of size 10 or less
	 * we are testing if MergeSort will call the InsertionSort algorithm. 
	 */
	
	public void testThere() {
		LinkedList<Character> linkedList = new LinkedList<>();
		Random random = new Random();
		char[] alphabet = {'A', 'B', 'C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int len = random.nextInt(10);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(alphabet[random.nextInt(alphabet.length-1)]);
		}
		
		Character[] mergeSortArray = new Character[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<Character> mergeSort = new MergeSort<>();
		
		Character[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	
	/** 
	 * TestOne focus on testing MergeSort on the List of max size 100.
	 */
	
	public void testFour() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Random random = new Random();
		int len = random.nextInt(100);
		
		System.out.println("List size: " + len);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(random.nextInt(100));
		}
		
		System.out.println(linkedList.toString());
		
		Integer[] mergeSortArray = new Integer[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<Integer> mergeSort = new MergeSort<>();
		
		Integer[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	
	public void testFive() {
		LinkedList<Character> linkedList = new LinkedList<>();
		Random random = new Random();
		char[] alphabet = {'A', 'B', 'C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int len = random.nextInt(alphabet.length-1);
		
		System.out.println("List size: " + len);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(alphabet[random.nextInt(alphabet.length-1)]);
		}
		
		System.out.println(linkedList.toString());
		
		Character[] mergeSortArray = new Character[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<Character> mergeSort = new MergeSort<>();
		
		Character[] result = mergeSort.sort(mergeSortArray);
		
		for(int i = 0; i < result.length; i++) {
			if(i+1 == result.length) {
				System.out.println(result[i]);
				break;
			}
			System.out.print(result[i] + ", ");
		}
		
	}
	
	public void testSix() {
		LinkedList<String> linkedList = new LinkedList<>();
		Random random = new Random();
		String[] dictionary = {"cat","bat","dog","mom","dad","car","disk","house","computer","parallelepiped", "mathematics", "machine learning"};
		int len = random.nextInt(dictionary.length-1);
		
		System.out.println("List size: " + len);
		
		for(int i = 0; i < len; i++) {
			linkedList.addFirst(dictionary[random.nextInt(dictionary.length-1)]);
		}
		
		System.out.println(linkedList.toString());
		
		String[] mergeSortArray = new String[linkedList.size()];
		
		for(int i = 0; i < mergeSortArray.length; i++) {
			mergeSortArray[i] = linkedList.removeFirst();
		}
		
		MergeSort<String> mergeSort = new MergeSort<>();
		
		String[] result = mergeSort.sort(mergeSortArray);
		
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
		test.testThere();
		test.testFour();
		test.testFive();
		test.testSix();
	}

}
