package main.datastructure.implementation;

import java.util.Comparator;

import main.datastructure.Tree;

public class BinarySearchTree<E> implements Tree, Comparator<E> {

	@SuppressWarnings({ "unused", "hiding" })
	private class Node<E>{
		
		private E element;
		private Node<E> left_child;
		private Node<E> right_child;
		private Node<E> parent;

		public Node(E element) {
 			this.element = element;
 			this.left_child = null; 
 			this.right_child = null;
 			this.parent = null;
		}
		
		public E getElement() {return this.element;}
		public void setElement(E element) {this.element = element;}
		
		public Node<E> getLeftChild(){return this.left_child;}
		public void setLeftChild(Node<E> left_child) {this.left_child = left_child;}
		
		public Node<E> getRightChild(){return this.right_child;}
		public void setRightChild(Node<E> right_child) {this.right_child = right_child;}
		
		public Node<E> getParent(){return this.parent;}
		public void setParent(Node<E> parent) {this.parent = parent;}
		
		public boolean hasRightChild() {return this.right_child != null;}
		public boolean hasLeftChild() {return this.left_child != null;}
		
	}
	
	private Node<E> root;
	private int size;
	
	public BinarySearchTree() {
		this.root = new Node<>(null);
		this.size = 0;
	}
	
	public E getRoot(){return this.root.getElement();}
	
	public Node<E> getRootNode(){return this.root;}
	
	public void setRoot(Node<E> root) {this.root = root;}
	
	public int size() {return this.size;}
	
	public boolean isEmpty() {return this.size == 0;}
	
	public double getTreeHeight() {return Math.floor(Math.log(this.size())/Math.log(2)) + 1;}
	
	public boolean isLeaf(Node<E> node) {

		if(node.hasLeftChild() || node.hasLeftChild()) {
			return false;
		}
		return true;
	}
	
	public boolean containsElement(E element) {
		return containsElement(element, this.root);
	}
	
	private boolean containsElement(E element, Node<E> node) {
		if(node == null || node.getElement() == null) {
			return false;
		}
		
		if(compare(node.getElement(), element) == 0) {
			return true;
		}

		if(compare(node.getElement(), element) < 1) {
			return containsElement(element, node.getRightChild());
		}else {
			return containsElement(element, node.getLeftChild());
		}

	}
	
	public void add(E element) throws Exception {
		if(element == null || element.toString().isEmpty()) {
			throw new Exception("You cannot add a null or empty value");
		}
		
		if(this.isEmpty()) {
			root.setElement(element);
			size++;
			return;
		}
		
		add(element, root);
	}
	
	public void add(E element, Node<E> node) {

		if(compare(node.getElement(), element) > 0) {
			if(!node.hasLeftChild()) {
				Node<E> left_child = new Node<>(element);
				left_child.setParent(node);
				node.setLeftChild(left_child);
				size++;
			}else {
				add(element, node.getLeftChild());
			}

		}else if(compare(node.getElement(), element) < 0) {
			if(!node.hasRightChild()) {
				Node<E> right_child = new Node<>(element);
				right_child.setParent(node);
				node.setRightChild(right_child);
				size++;
			}else {
				add(element, node.getRightChild());
			}
		}

	}
	
	public E remove(E element) {
		return remove(element);
	}
	
	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
		
	}
	
	private void inOrderTraversal(Node<E> node) {
		if(node != null) {
			inOrderTraversal(node.getLeftChild());
			System.out.println(" " + node.getElement());
			inOrderTraversal(node.getRightChild());
		}
	}
	
	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
	}
	
	private void preOrderTraversal(Node<E> node) {
		if(node != null) {
			System.out.println(" " + node.getElement());
			preOrderTraversal(node.getLeftChild());
			preOrderTraversal(node.getRightChild());
		}
	}
	
	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
	}
	
	private void postOrderTraversal(Node<E> node) {
		if(node != null) {
			preOrderTraversal(node.getLeftChild());
			preOrderTraversal(node.getRightChild());
			System.out.println(" " + node.getElement());
		}
	}
	
	@Override
	public int compare(E o1, E o2) {
		if(Math.abs(o1.hashCode()) < Math.abs(o2.hashCode())) {
			return -1;
		}else if(Math.abs(o1.hashCode())  > Math.abs(o2.hashCode())) {
			return 1;
		}else {
			return 0;
		}
	}

}
