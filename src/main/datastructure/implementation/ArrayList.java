package main.datastructure.implementation;

public class ArrayList<E> {
	
	private static final int ARRAY_SIZE = 10;
	private E[] array;
	private int size;
	
	public ArrayList() {this(ARRAY_SIZE);}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int array_size) {
		array = (E[]) new Object[ARRAY_SIZE];
		this.size = 0;
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size == 0;}
	
	public E get(int index) {
		checkIndex(index);
		return array[index];
	}
	
	public void add(E element) {
		if(size == array.length) {
			resize();
		}
		array[size++] = element;
	}
	
	public void set(int index, E element) {
		checkIndex(index);
		array[index] = element;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] temp = (E[]) new Object[size * 2];
		for(int i = 0; i  < size; i++) {
			temp[i] = array[i];
		}
		array = temp;
		temp = null;
	}
	
	public E remove(int index) {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Error: the array is out of bounds");
		}
		E result = array[index];
		reshuffle(index);
		size--;
		return result;
	}
	
	private void reshuffle(int index) {
		int len = array.length;
		for(int i = index; i < len-1; i++) {
			array[i] = array[i+1];

		}
	}
	
	private void checkIndex(int index) {
		if(index < 0) {
			throw new ArrayIndexOutOfBoundsException("Error: the array is out of bounds");
		}
	}
	
	public String toString() {
		int len = array.length;
		String result = "[";
		
		for(int i = 0; i < len; i++) {
			if(i+1 == len) {
				result += array[i] + "]";
				break;
			}
			result += array[i] + ", ";
		}
		return result;
	}
}
