package main.datastructure;

public interface PriorityQueue<V> {
	
	public int size();
	public boolean isEmpty();
	public V peek();
	public V remove();
	public void add(V value);
}
