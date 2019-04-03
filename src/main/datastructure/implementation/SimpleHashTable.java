package main.datastructure.implementation;

import java.util.Comparator;

public class SimpleHashTable<K, E> implements Comparator<E> {
	
	private static final int MIN_SIZE = 10;
	
	private E[] element_array;
	private K[] key_array;
	private int size;
	
	public SimpleHashTable() {this(MIN_SIZE);}
	
	@SuppressWarnings("unchecked")
	public SimpleHashTable(int size) {
		element_array=(E[]) new Object[size];
		key_array=(K[]) new Object[size];
		this.size = size;
	}
	
	public int size() {return this.size;}
	
	public boolean isEmpty() {return this.key_array.length == 0;}
	
	public boolean contains(E element) {
		for(E elem: element_array) {
			if(compare(elem, element) == 0){
				return true;
			}
		}
		return false;
	}
	
	public void put(K key, E element) {
		int index = hash(key);
		element_array[index] = element;
		key_array[index] = key;
	}
	
	
	public E delete(K key) {
		int index = hash(key);
		E elem = element_array[index];
		element_array[index] = null;
		key_array[index] = null;
		return elem; 
	}
	
	public E[] values() {return this.element_array;}
	
	public K[] keys() {return this.key_array;}
	
	private int hash(K key) {
		return key.hashCode() % this.size;
	}
	
	@Override
	public int compare(E o1, E o2) {
		if(Math.abs(o1.hashCode()) == Math.abs(o2.hashCode())) {
			return 0;
		}else if(Math.abs(o1.hashCode()) <= Math.abs(o2.hashCode())) {
			return -1;
		}else {
			return 1;
		}

	}		
}
