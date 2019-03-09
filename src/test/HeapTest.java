package test;

import java.util.Random;

import main.datastructure.implementation.BinaryHeap;

public class HeapTest {
	
	public void testOne() {
		BinaryHeap<Integer> testHeap = new BinaryHeap<>();
		Random random = new Random();
		
		for(int i = 0; i < 6; i++) {
			int value = random.nextInt(100);
			testHeap.add(value);
			System.out.println(value);
		}
		
		System.out.println(testHeap.toString());
		
		for(int i = 0; i < 2; i++) {
			testHeap.remove();
		}
		
		System.out.println(testHeap.toString());
	}
	
	public void testTwo() {
		BinaryHeap<Character> testHeap = new BinaryHeap<>();
		Random random = new Random();
		char[] alphabet = {'A', 'B', 'C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		for(int i = 0; i < 6; i++) {
			int value = random.nextInt(alphabet.length-1);
			testHeap.add(alphabet[value]);
			System.out.println(alphabet[value]);
		}
		
		System.out.println(testHeap.toString());
		
		for(int i = 0; i < 2; i++) {
			testHeap.remove();
		}
		
		System.out.println(testHeap.toString());
	}
	
	public void testThree() {
		BinaryHeap<String> testHeap = new BinaryHeap<>();
		Random random = new Random();
		String[] dictionary = {"cat","bat","dog","mom","dad","car","disk","house","computer","parallelepiped", "mathematics", "machine learning"};
		
		for(int i = 0; i < 6; i++) {
			int value = random.nextInt(dictionary.length-1);
			testHeap.add(dictionary[value]);
			System.out.println(dictionary[value]);
		}
		
		System.out.println(testHeap.toString());
		
		for(int i = 0; i < 2; i++) {
			testHeap.remove();
		}
		
		System.out.println(testHeap.toString());
	}

	public void testFour() {
		BinaryHeap<Double> testHeap = new BinaryHeap<>();
		Random random = new Random();
		double[] float_array = {0.545, 312.3123, 65.34, 85685.532, 996885.4, 2.211110, 76.42, 17.4215, 9.0131};
		
		for(int i = 0; i < 6; i++) {
			int value = random.nextInt(float_array.length-1);
			testHeap.add(float_array[value]);
			System.out.println(float_array[value]);
		}
		
		System.out.println(testHeap.toString());
		
		for(int i = 0; i < 2; i++) {
			testHeap.remove();
		}
		
		System.out.println(testHeap.toString());
	}
	
	public static void main(String[] args) {
		HeapTest test = new HeapTest();
		test.testOne();
		test.testTwo();
		test.testThree();
		test.testFour();
	}
}
