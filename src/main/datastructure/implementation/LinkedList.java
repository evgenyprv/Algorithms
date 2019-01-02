package main.datastructure.implementation;

/**
* This file represents a DoubleLinkedList data structure. It implements
* List interface and uses Generics T for type of elements. 
*
* @author: ev_prv
* @since: 30 December 2018
*
*/

import main.datastructure.List;


public class LinkedList<T> implements List<T>{
	

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

		/* Node that points to previous Node in the list. */
		Node<T> prev;

		/* Node that points to the next Node in the list. */
		Node<T> next;

		public Node(T element, Node<T> prev, Node<T> next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		/** Getter for element.
		*
		* @param: Nothing
		* @return: T element.
		*
		*/

		public T getElement(){return element;}

		/** Getter for previous Node
		*
		* @param: Nothing
		* @return: Node<T> node.
		*
		*/

		public Node<T> getPrev(){return prev;}

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

		/** Setter for previous Node.
		*
		* @param: Node<T> node
		* @return: Nothing
		*
		*/

		public void setPrev(Node<T> prv){prev = prv;}

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

	/* The size is used to count the number of elements in the list.*/

	private int size;

	public LinkedList(){
		head = new Node<>(null, null, null);
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

	/**  Method that adds a new element at the beginning  of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addFirst(T elem){
		if(this.isEmpty()){
			add(elem, head, head);
		}	
		add(elem, head, head.getNext());
	}


	/**  Method that adds a new element at the end of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addLast(T elem){
		if(this.isEmpty()){
			add(elem, head, head);
		}
		add(elem, head.getPrev(), head);
	}

	/**  Method that adds a new element between two nodes of the list. 
	*
	* @param: T elem, Node<T> previous and Node<T> next
	* @return: Nothing
	*
	*/

	public void add(T elem, Node<T> previous, Node<T> next){
		Node<T> newNode = new Node<>(elem, previous, next);
		previous.setNext(newNode);
		next.setPrev(newNode);
		size++;
	}

	/**  Method that removes an element at the beginning of the list. 
	*
	* @param: Nothing
	* @return: T element
	*
	*/

	public T removeFirst(){
		return remove(head.getNext().getElement());
	}

	/**  Method that removes an element at the end of the list. 
	*
	* @param: Nothing
	* @return: T element
	*
	*/

	public T removeLast(){
		return remove(head.getPrev().getElement()); 
	}

	/**  Method that removes a Node from anywhere in the list.
	*
	* @param: T element 
	* @return: T element
	* @throws: NullPointerException when list is empty.
	*
	*/

	public T remove(T element){
		if(this.isEmpty()){
			throw new NullPointerException("Error: the list is empty");
		}
		Node<T> node = this.search(element);
		Node<T> previous = node.getPrev();
		Node<T> next = node.getNext();
		previous.setNext(next);
		next.setPrev(previous);
		T elem = node.getElement();
		node = null;
		size--;
		return elem; 
	}

	/**  Helper Method for remove(T element) Method. Finds the node that 
	* has the T element. 
	*
	* @param: T elem
	* @return: Node<T> node
	*
	*/

	private Node<T> search(T element){
		Node<T> iter = head.getNext();

		while(iter.getElement() != null){
			if(iter.getElement() == element){
				break;
			}
			iter = iter.getNext();
		}
		return iter;
	}

	/**  Method that returns the string represtation of the list. Helpful 
	* in debugging.
	*
	* @param: Nothing
	* @return: String result
	*
	*/

	public String toString(){
		Node<T> iter = head.getNext();
		String result = "";

		while(iter.getElement() != null){
			result += "Prev: " + iter.getPrev().getElement() + 
				" Current: " + iter.getElement() + 
				" Next: " + iter.getNext().getElement() + "\n";
			iter = iter.getNext();
		}

		return result;
	}
}