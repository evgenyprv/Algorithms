package main.datastructure;
/**
* This file represents a DoubleLinkedList data structure. It implements
* List interface and uses Generics T for type of elements. 
*
* @author: ev_prv
* @since: 30 December 2018
*
*/

public interface List<T>{
	
	/** Getter method for size variable. 
	*
	* @param: size
	* @return: int
	*
	*/

	public int size();

	/** Method to check if the list is empty. 
	*
	* @param: Nothing
	* @return: boolean
	*
	*/

	public boolean isEmpty();
	
	/**  Method that adds a new element to the beginning 
	* of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addFirst(T elem);

	/**  Method that adds a new element at the end of the list. 
	*
	* @param: T elem
	* @return: Nothing
	*
	*/

	public void addLast(T elem);


	/**  Method that removes an element at the beginning of the list. 
	*
	* @param: Nothing
	* @return: T element
	*
	*/

	public T removeFirst();

	/**  Method that removes an element at the end
	* of the list. 
	*
	* @param: Nothing
	* @return: T element
	*
	*/

	public T removeLast();

}