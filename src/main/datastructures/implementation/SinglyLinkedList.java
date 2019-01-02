package main.datastructures.implementation;

/**
* This file represents a DoubleLinkedList data structure. It implements
* List interface and uses Generics T for type of elements. 
*
* @author: Evgeny Prokoptsov
* @since: 30 December 2018
*
*/

import main.datastructures.List;


public class SinglyLinkedList<T> implements List<T>{
	

	public class Node<T>{

		/** Visual Represenation of Node
		*	_________________
		*	| 	|	   |	|
		*	| P | Elem | N	|
		*	|	|	   |	|
		*	-----------------
		*/

		/* The element of the node. Can have any data type. */
		T element;

		/* Node that points to the next Node in the list. */
		Node<T> next;

		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}

		/** Getter for element.
		*
		* @param: Nothing
		* @return: T element.
		*
		*/

		public T getElement(){return element;}


		/** Getter for next Node
		*
		* @param: Nothing
		* @return: Node<T> node.
		*
		*/

		public Node<T> getNext(){return next;}


		/** Setter for element.
		*
		* @param: T elem
		* @return: Nothing
		*
		*/

		public void setElement(T elem){element = elem;}

		/** Setter for next Node.
		*
		* @param: Node<T> node
		* @return: Nothing
		*
		*/

		public void setNext(Node<T> nxt){next = nxt;}
	}
	/* Head Node represents the root of the list.*/

	private Node<T> head;

	/* Tail Node represents the tail of the list or the last node 
	* that was added to the list.
	*/
	private Node<T> tail;

	/* The size is used to count the number of elements in the list.*/

	private int size;

	public SinglyLinkedList(){
		head = new Node<>(null, null);
		tail = new Node<>(null, null);
		size = 0;
	}

	/** Getter method for size variable. 
	*
	* @param: size
	* @return: int
	*
	*/

	public int size(){return size;}

	/** Method to check if the list is empty. 
	*
	* @param: Nothing
	* @return: boolean
	*
	*/

	public boolean isEmpty(){return size == 0;}

	/**  Method that adds a new element at the beginning 
	* of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addFirst(T elem){
		Node<T> newNode = new Node<>(elem, null);

		if(isEmpty()){
			head.setNext(newNode);
		}else{
			newNode.setNext(head.getNext());
			head.setNext(newNode);
		}

		tail = newNode;
		size++;
	}

	/**  Method that adds a new element at the end of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addLast(T elem){
		Node<T> newNode = new Node<>(elem, null);

		if(isEmpty()){
			head.setNext(newNode);
		}else{
			tail.setNext(newNode);
		}

		tail = newNode;
		size++;
	}

	/**  Method that removes an element at the beginning of the list. 
	*
	* @param: Nothing
	* @return: T element
	* @throws: NullPointerException when list is empty.
	*
	*/

	public T removeFirst(){
		if(this.isEmpty()){
			throw new NullPointerException("Error: the list is empty");
		}
		T elem = head.getNext().getElement();
		head.setNext(head.getNext().getNext());
		size--;
		return elem; 
	}

	/**  Method that removes an element at the end
	* of the list. 
	*
	* @param: Nothing
	* @return: T element
	* @throws: NullPointerException when list is empty.
	*
	*/

	public T removeLast(){
		if(this.isEmpty()){
			throw new NullPointerException("Error: the list is empty");
		}
		T elem = tail.getElement();
		tail = null;
		size--;
		return elem;
	}

	/**  Method that prints the list. Helpful in debugging.
	*
	* @param: Nothing
	* @return: Nothing
	*
	*/

	public void printList(){
		Node<T> iter = head.getNext();

		while(iter.getElement() != null){
			System.out.println(" Current: " + iter.getElement() + 
				" Next: " + iter.getNext().getElement()+ "\n");
			iter = iter.getNext();
		}
	}
}