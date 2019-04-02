package test;

import java.util.Random;

import main.datastructure.implementation.BinarySearchTree;

public class BinaryTreeTest {
	/***
	 * Test for empty tree all traversals;
	 */
	
	public void testOne() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		System.out.println("Tree size: 0");
		
		tree.inOrderTraversal();
		
	}
	
	public void testTwo() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		Random random = new Random();
		int len = 7;
		int value = 0;
		System.out.println("Tree size: " + len);
		
		for(int i = 0; i < len; i++) {
			value = random.nextInt(100);
			try {
				tree.add(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(value);
		}
		
		System.out.println("In order traversal: ");
		tree.inOrderTraversal();
		
		System.out.println("Pre order traversal: ");
		tree.preOrderTraversal();
		
		System.out.println("Post order traversal: ");
		tree.postOrderTraversal();
		
		value = random.nextInt(100);
		System.out.println("Element contains "+ value + " ? " +tree.containsElement(value));
		
		System.out.println("Tree heigh is: " +tree.getTreeHeight());
	}

	public static void main(String[] args) {
		BinaryTreeTest test = new BinaryTreeTest();
		
		test.testOne();
		test.testTwo();
	}
}
