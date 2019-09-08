package main.datastructure;

public interface PriorityQueue<K, V> {
	
	int size();
	boolean isEmpty();
	Entry<K, V> peek();
	Entry<K, V> remove();
	void add(K key, V value);
}
