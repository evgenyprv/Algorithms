package main.datastructure.implementation;

public class Entry<K, E> {
	private K key;
	private E element;
	
	public Entry(K key, E element) {
		this.key = key;
		this.element = element;
	}
	
	public K getKey() {return this.key;}
	public E getElement() {return this.element;}
	
	public void setKey(K key) {this.key = key;}
	public void setElement(E element) {this.element = element;}

}
